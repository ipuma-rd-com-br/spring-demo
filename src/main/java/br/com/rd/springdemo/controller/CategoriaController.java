package br.com.rd.springdemo.controller;

import br.com.rd.springdemo.model.Categoria;
import br.com.rd.springdemo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping("/categoria/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable("id") Long id) {
        Categoria categoriaEntity = this.repository.findById(id).get();
        if (categoriaEntity != null) {
            return ResponseEntity.ok().body(categoriaEntity);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> buscarTodos() {
        List<Categoria> list = this.repository.findAll();
        if (list != null && !list.isEmpty()) {
            return ResponseEntity.ok().body(list);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/categoria")
    public ResponseEntity<Categoria> inserir(@RequestBody Categoria categoria) {
        Categoria categoriaEntity = this.repository.getOne(categoria.getId());
        categoriaEntity.setDescricao(categoria.getDescricao());
        Categoria categoriaUpdated = this.repository.save(categoriaEntity);
        if (categoriaUpdated != null) {
            return ResponseEntity.ok().body(categoriaUpdated);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
