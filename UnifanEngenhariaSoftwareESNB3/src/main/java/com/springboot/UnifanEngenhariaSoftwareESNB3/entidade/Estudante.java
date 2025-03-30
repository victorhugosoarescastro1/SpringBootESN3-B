package com.springboot.UnifanEngenhariaSoftwareESNB3.entidade

import jaka.persistence.*;
import lombok.Data;

@Data
@Entity
Public class Estudante {

    @Id
    @GenerateValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long matricula;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    private Boolean active;

    @Override
    public String toString() {
        return "Estudante{" +
                "id=" + id +
                ", matricula=" + matricula +
                ", nome=" + nome + "\'" +
                ", genero=" + genero +
                '}';
    }

}