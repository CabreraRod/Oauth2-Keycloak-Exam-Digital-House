package com.digitalmedia.users.repository;

import com.digitalmedia.users.exceptions.UserExtraNotFoundException;
import com.digitalmedia.users.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class UserRepository {
  private IUserRepository userRepository;


  public User validateAndGetUser(String username) {
    return  userRepository.validateAndGetUser(username);
  }

  public Optional<User> getUserExtra(String username) {
    return userRepository.getUserExtra(username);
  }

  public User saveUserExtra(User user) {
    var userSaver = keycloakUserRepository.save(user);
    if(userSaver == null){
      return null;
    }
    return userRepository.saveUserExtra(user);
  }
  public List<User> findAllUserNoAdmin(){
    return keycloakUserRepository.findUserNoAdmin();
  }
  public User findeByUsername(String username){
    return keycloakUserRepository.findBy(username);
  }
  public List<User> getAllUsersMongoDb(){
    return userRepository.getAllUserMongoDB();
  }

  public List<User> findByFirstName(String name);

  public User findById(String id);

}
