package com.online.platform.learning.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class Encaissment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private String matricule;
    private String fullname;
    private String cin;
    private String motif;
    private String somme;
    private String status;

    @ManyToOne
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank banque;
}