package com.CheckingAcc.checkingacc.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "account")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE)
 private Long id;

 @Column(name = "firstname")
 private String firstname;

 @Column(name = "lastname")
 private String lastname;

 @Column(name = "email")
 private String email;

 @Column(name = "username")
 private String username;

 @Column(name = "password")
 private String password;

 @Column(name = "is_active")
 private boolean isActive;
}
