package br.com.rd.springdemo.model;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class UsuarioTests {

    @Test
    public void teste() {
        Usuario usuario = new Usuario(1L, "Ivo", "La Puma", 39);
        Long id = usuario.getId();
        Assert.isTrue(id==1L, "id");
    }
}
