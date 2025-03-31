package com.springboot.UnifanEngenhariaSoftwareESNB3.repositorio;

import com.example.universidadeESN3.entidade.Estudante;
import org.springframework.data.jpa.repositorio.JpaRepository;
import org.springframework.data.jpa.repositorio.Query;
import org.springframework.data.repositorio.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudanteRepository extends JpaRepository <Estudante, long> {
    List<Estudante> findByNome(String nome);

    List<Estudante> findByNomeStartingWith(String nome);


    @Query(value = "SELECT * From aluno a WHERE LOWER(a.nome) LIKE LOWER(CONCAT(:nome, '%'))", nativeQuery = true)
    List<Estudante> findByNomeStartingWithIgnoreCase(@Param("nome")String nome);

}