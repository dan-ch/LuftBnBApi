package com.example.api.dto;

import com.example.api.annotation.Password;

import javax.validation.constraints.Email;

public class RegisterRequest {

  @Email
  private String email;
  private String firstName;
  private String lastName;
  @Password
  private String password;

  public RegisterRequest() {
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
