package org.launchcode.DropCatch.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email. Try again.")
    private String userEmail;

    @NotBlank(message = "Password is required")
    @Size(min=6, max=16, message = "Password must be between 6-16 characters")
    private String userPassword;

    @NotBlank(message= "Please re-type password")
    @Size(min=6, max=16, message = "Password must be between 6-16 characters")
    private String verifyPassword;


    // Constructors

    public User(int id, String userEmail, String userPassword, String verifyPassword) {
        this.id = id;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.verifyPassword = verifyPassword;
    }
    // Will be needed for abstract entity
    public User() {};


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserPassword() { return userPassword; }

    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public String getVerifyPassword() { return verifyPassword; }

    public void setVerifyPassword(String verifyPassword) { this.verifyPassword = verifyPassword; }

    // toString
    @Override
    public String toString() {
        return "User{" + "userEmail='" + userEmail + '\'' + '}';
    }

    // Equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}



