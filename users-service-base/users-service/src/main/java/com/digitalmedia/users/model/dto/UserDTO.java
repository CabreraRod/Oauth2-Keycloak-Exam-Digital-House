package com.digitalmedia.users.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Id
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private String avatar;
}
