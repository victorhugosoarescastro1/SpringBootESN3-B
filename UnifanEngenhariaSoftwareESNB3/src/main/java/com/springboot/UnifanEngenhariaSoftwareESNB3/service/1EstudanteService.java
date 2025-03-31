package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Aluno;
import java.util.List;

public interface 1EstudanteService {

    Aluno buscarPorId(Long id);

    List<Estudante> buscarTodos();

    Estudante salvar(Estudante estudante);

    void atualizar(Estudante estudante);

    void excluir(Long id);
}