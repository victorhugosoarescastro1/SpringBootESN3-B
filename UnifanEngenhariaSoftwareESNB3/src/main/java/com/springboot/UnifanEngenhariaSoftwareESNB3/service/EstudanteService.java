package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Aluno;
import com.example.universidadeESN3.repository.AlunoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EstudanteService implements 1EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Override
    public Estudante buscarPorId(Long id) {
        Optional<Estudante> response = estudanteRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    @Override
    public List<Estudante> buscarTodos() {
        return estudanteRepository.findAll();
    }

    @Override
    public Estudante salvar(Estudante estudante) {
        log.info("salvar() - estudante:{}", estudante );
        return estudanteRepository.save(estudante);
    }

    @Override
    public void atualizar(Estudante estudante) {
        log.info("atualizar() - estudante:{}", estudante );
        alunoRepository.save(estudante);
    }

    @Override
    public void excluir(Long id) {
        estudanteRepository.deleteById(id);
    }

    public void desativar(Estudante estudante) {
        estudante.setActive(Boolean.FALSE);
        estudanteRepository.save(estudante);
    }

    public List<Estudante> buscarPorNome(String nome) {

        return estudanteRepository.findByNomeStartingWithIgnoreCase(nome);
    }
}