package com.springboot.UnifanEngenhariaSoftwareESNB3.repository;

import com.example.universidadeESN3.entidade.Professor;
import org.springframework.data.jpa.repositorio.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProfessor extends JpaRepository<Professor, Long> {
}