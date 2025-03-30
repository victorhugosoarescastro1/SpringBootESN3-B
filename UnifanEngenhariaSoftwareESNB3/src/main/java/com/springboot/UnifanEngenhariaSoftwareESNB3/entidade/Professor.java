package com.springboot.UnifanEngenhariaSoftwareESNB3.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTIFY)
    private Long id;
    private Long matricula;
    private String nome;
}