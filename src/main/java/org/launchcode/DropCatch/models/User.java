package org.launchcode.DropCatch.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Objects;
import java.util.Optional;

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


    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Constructors

    public User(int id, String userEmail, String userPassword) {
        this.id = id;
        this.userEmail = userEmail;
        this.userPassword = encoder.encode(userPassword);
    }

    // Will be needed for abstract entity
    public User() {};

    public User(Optional<User> currentUser) {

    }


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


    // Check if given password matches stored password
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, userPassword);
    }

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



