package br.com.rd.springdemo.repository;

import br.com.rd.springdemo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNome(String nome);

    List<Usuario> findBySobrenome(String sobrenome);

}