package com.springboot.UnifanEngenhariaSoftwareESNB3.controlador;

import com.springboot.UnifanEngenhariaSoftwareESNB3.entidade.Estudante;
import com.springboot.UnifanEngenhariaSoftwareESNB3.service.AlunoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
@Slf4j
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public ResponseEntity<List<Estudante>> buscarTodos() {
        return ResponseEntity.ok(estudanteService.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Estudante> buscarPorId(@PathVariable Long id){

        Estudante response = estudanteService.buscarPorId(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<List<Aluno>> buscarPorNome(@PathVariable String nome){

        List<Estudante> response = alunoService.buscarPorNome(nome);
        if (response != null && !response.isEmpty()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<Aluno> salvarEstudante(@RequestBody Estudante estudante){
        log.info("salvarEstudante() - estudante:{}", estudante );
        return ResponseEntity.ok(estudanteService.salvar(estudante));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Aluno aluno){

        Estudante response = estudanteService.buscarPorId(aluno.getId());
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        estudanteService.atualizar(estudante);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Estudante response = estudanteService.buscarPorId(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        estudanteService.excluir(id);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/inactive/{id}")
    public ResponseEntity<?> desativar(@PathVariable Long id) {
        Estudante response = estudanteService.buscarPorId(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        estudanteService.desativar(response);
        return ResponseEntity.ok(null);
    }
}