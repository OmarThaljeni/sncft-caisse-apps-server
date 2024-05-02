package com.online.platform.learning.models;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(using = User.UserSerializer.class)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;
  private String email;
  private String address;
  private String fullName;
  private String matricule;
  private String caisse;
  private String phoneNumber;
  private String password;
  private String status;
  private String token;

  public static class UserSerializer extends JsonSerializer<User> {
    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, IOException {
      jsonGenerator.writeStartObject();
      jsonGenerator.writeNumberField("id", user.getId());
      jsonGenerator.writeStringField("username", user.getUsername());
      jsonGenerator.writeStringField("email", user.getEmail());
      jsonGenerator.writeStringField("address", user.getAddress());
      jsonGenerator.writeStringField("fullName", user.getFullName());
      jsonGenerator.writeStringField("matricule", user.getMatricule());
      jsonGenerator.writeStringField("caisse", user.getCaisse());
      jsonGenerator.writeStringField("status", user.getStatus());
      jsonGenerator.writeStringField("phoneNumber", user.getPhoneNumber());
      jsonGenerator.writeStringField("password", user.getPassword());
      jsonGenerator.writeStringField("token", user.getToken());
      jsonGenerator.writeEndObject();
    }
  }

  @JsonCreator
  public User(String fullName) {
    this.fullName = fullName;
  }


  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  private User(Builder builder) {
    this.username = builder.username;
    this.email = builder.email;
    this.address = builder.address;
    this.fullName = builder.fullName;
    this.phoneNumber = builder.phoneNumber;
    this.matricule = builder.matricule;
    this.caisse = builder.caisse;
    this.password = builder.password;
    this.status = builder.status;
  }



  // Builder class for User
  public static class Builder {
    private String username;
    private String email;
    private String address;
    private String fullName;
    private String phoneNumber;
    private String password;
    private String matricule;
    private String caisse;
    private String status;


    public Builder username(String username) {
      this.username = username;
      return this;
    }


    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder fullName(String fullName) {
      this.fullName = fullName;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Builder phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public Builder caisse(String caisse) {
      this.caisse = caisse;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }

    public Builder matricule(String matricule) {
      this.matricule = matricule;
      return this;
    }


    public Builder status(String status) {
      this.status = status;
      return this;
    }



    // Build method to create User instance
    public User build() {
      return new User(this);
    }
  }

}
