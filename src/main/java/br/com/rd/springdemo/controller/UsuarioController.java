package br.com.rd.springdemo.controller;

import br.com.rd.springdemo.model.Usuario;
import br.com.rd.springdemo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/usuario")
    public Usuario save(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @GetMapping("/usuario/todos")
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @GetMapping("/usuario")
    public Usuario findById2(@PathParam("id") Long id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/usuario/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/usuario")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
        Usuario usuarioEntity = repository.getOne(usuario.getId());
        usuarioEntity.setIdade(usuario.getIdade());
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setSobrenome(usuario.getSobrenome());
        Usuario usuarioUpdated = repository.save(usuarioEntity);
        return ResponseEntity.ok().body(usuarioUpdated);
    }

    @PatchMapping("/usuario")
    public ResponseEntity<Usuario> updateIdade(@RequestBody Usuario usuario) {
        Usuario usuarioEntity = repository.getOne(usuario.getId());
        usuarioEntity.setIdade(usuario.getIdade());
        Usuario usuarioUpdated = repository.save(usuarioEntity);
        return ResponseEntity.ok().body(usuarioUpdated);
    }
}
