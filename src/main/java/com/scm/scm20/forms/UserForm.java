package com.scm.scm20.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class UserForm {

    @NotBlank(message = "Name is required")
    @Size(min = 3,message = "min 3 chracter required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8,message = "atleast 8 character required")
    private String password;

    @NotBlank(message = "Phone number is required")
    @Size(min = 10,max = 10,message = "invalid phone number")
    private String phoneNumber;

    @NotBlank(message = "about is required")
    private String about;
}
