package com.digitalmedia.users.controller;

import com.digitalmedia.users.model.User;
import com.digitalmedia.users.model.dto.UserDTO;
import com.digitalmedia.users.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
  private final IUserService userService;
 //TODO  estos dos endpoints funcionaran cuando este configurada la seguridad en el proyecto

  @GetMapping("/me")
  public User getUserExtra(Principal principal) {
    return userService.validateAndGetUserExtra(principal.getName());
  }


  @PostMapping("/me")
  public User saveUserExtra(@Valid @RequestBody UserDTO updateUserDTO, Principal principal) {
    Optional<User> userOptional = userService.getUserExtra(principal.getName());
    User userExtra = userOptional.orElseGet(() -> new User(principal.getName()));
    userExtra.setAvatar(updateUserDTO.getAvatar());
    return userService.saveUserExtra(userExtra);
  }
  @GetMapping("/users/admin")
  @PreAuthorize("hasGroup('ADMIN')")
  public List<User> getAllUsersNoAdmin(){
    return userService.getAllUsersNoAdmin();   }

  @GetMapping("/users/admin/{username}")
  @PreAuthorize("hasGroup('ADMIN')")
  public User userDetail(@PathVariable String username){
    return userService.findByUsername(username);   }

  @PostMapping("/users/admin/{userId}")
  public User saveUserExtra(@PathVariable String userId, @RequestBody User user){
    user.setId(userId);
    return userService.saveUserExtra(user);   }

  @GetMapping("/users/{username}")
  @PreAuthorize("hasAuthority('GROUP_admin')")
  public ResponseEntity<UserDTO> getUsersByUsername(@RequestParam String username){
    Optional<UserDTO> user = userService.findByUsername(username);
    if (user.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(user.get());
  }

}
