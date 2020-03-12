package br.com.rd.springdemo.repository;

import br.com.rd.springdemo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
