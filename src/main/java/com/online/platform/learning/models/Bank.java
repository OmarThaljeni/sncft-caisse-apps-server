package com.online.platform.learning.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bank")
@NoArgsConstructor
@Getter
@Setter
public class Bank {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String codeBank;

  private String socialRaison;
  private String codeComptable;

  private String rib;


}
