package br.com.rd.springdemo.controller;

import br.com.rd.springdemo.dto.ProdutoDTO;
import br.com.rd.springdemo.dto.ResponseDTO;
import br.com.rd.springdemo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping("/produto")
    public ResponseEntity inserir(@RequestBody ProdutoDTO produto) {
        ResponseEntity response = null;
        try {
            ProdutoDTO produtoInserido = this.service.inserir(produto);
            if (produtoInserido != null && produtoInserido.getId() > 0L) {
                response = ResponseEntity
                        .created(URI.create("http://localhost:8080/spring-demo" + "/produto" + "/" + produtoInserido.getId()))
                        .build();
            } else {
//                response = ResponseEntity.badRequest().body(new Exception("Erro ao inserir o Produto."));
                response = ResponseEntity.badRequest().body(ResponseDTO.erro("Erro ao inserir o Produto."));
            }
        } catch (Exception e) {
            response = ResponseEntity.badRequest().body(ResponseDTO.erro(e.getMessage(), e));
        }
        return response;
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity buscarPorId(@PathVariable("id") Long id) {
        ResponseEntity response = null;
        try {
            ProdutoDTO produtoDTO = this.service.buscarPorId(id);
//            response = ResponseEntity.ok().body(produtoDTO);
            List<ProdutoDTO> dtos = new ArrayList<>();
            dtos.add(produtoDTO);
            response = ResponseEntity.ok().body(ResponseDTO.sucesso(dtos));
        } catch (NoSuchElementException e) {
//            response = ResponseEntity.badRequest().body(new Exception(e.getClass().getName()+": Produto não localizado. ID="+id));
            response = ResponseEntity.badRequest().body(ResponseDTO.erro(String.format("Produto não localizado. ID=%s", id), e));
        } catch (Exception e) {
            response = ResponseEntity.badRequest().body(ResponseDTO.erro(e.getMessage(), e));
        }
        return response;
    }

    @GetMapping("/produto")
    public ResponseEntity buscarPorDescricao(@PathParam("descricao") String descricao) {
        ResponseEntity response = null;
        try {
            List<ProdutoDTO> dtos = this.service.buscarPorDescricao(descricao);
            if (dtos.size() > 0) {
//                response = ResponseEntity.ok().body(dtos);
                response = ResponseEntity.ok().body(ResponseDTO.sucesso(dtos));
            } else {
                response = ResponseEntity.badRequest().body(new Exception("Nenhum Produto com a descrição informada."));
            }
        } catch (Exception e) {
            response = ResponseEntity.badRequest().body(new Exception(e.getClass().getName()+": "+e.getMessage()));
        }
        return response;
    }
}
