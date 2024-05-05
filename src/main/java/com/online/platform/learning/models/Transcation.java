package com.online.platform.learning.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transcation")
@NoArgsConstructor
@Getter
@Setter
public class Transcation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codeTransaction;

    private String nomTransaction;
    private String typeOperation;

}
