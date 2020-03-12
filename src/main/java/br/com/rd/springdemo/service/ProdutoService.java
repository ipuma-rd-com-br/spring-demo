package br.com.rd.springdemo.service;

import br.com.rd.springdemo.dto.ProdutoDTO;
import br.com.rd.springdemo.model.Categoria;
import br.com.rd.springdemo.model.Produto;
import br.com.rd.springdemo.repository.ProdutoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ProdutoService")
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    /**
     * Serviço para inserir um Produto novo.
     *
     * @param produtoDTO
     * @return
     */
    public ProdutoDTO inserir(@NotNull ProdutoDTO produtoDTO) {

        // TODO: validacao parametros input - dados do produto

        Produto produto = new Produto();
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setDescricaoCompleta(produtoDTO.getDescricaoCompleta());
        produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
        produto.setValorUnitario(produtoDTO.getValorUnitario());
        produto.setCategoria(new Categoria(produtoDTO.getIdCategoria(), null));

        Produto produtoSaved = this.repository.save(produto);

        produtoDTO.setId(produtoSaved.getId());

        return produtoDTO;
    }

    /**
     * Serviço que retonra um Produto por ID.
     *
     * @param id
     * @return
     */
    public ProdutoDTO buscarPorId(Long id) {

        // TODO: validacao parametros input - ID

        Produto produto = this.repository.findById(id).get();

        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setDescricao(produto.getDescricao());
        dto.setDescricaoCompleta(produto.getDescricaoCompleta());
        dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        dto.setValorUnitario(produto.getValorUnitario());
        dto.setIdCategoria(produto.getCategoria().getId());

        return dto;
    }

    public List<ProdutoDTO> buscarPorDescricaoContendo(String descricao) {

        // TODO: validacao parametros input - descricao

        List<Produto> produtos = this.repository.findByDescricaoLike("%"+descricao+"%");

        List<ProdutoDTO> dtos = new ArrayList<>();

        for (Produto produto :
                produtos) {

            ProdutoDTO dto = new ProdutoDTO();
            dto.setId(produto.getId());
            dto.setDescricao(produto.getDescricao());
            dto.setDescricaoCompleta(produto.getDescricaoCompleta());
            dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
            dto.setValorUnitario(produto.getValorUnitario());
            dto.setIdCategoria(produto.getCategoria().getId());

            dtos.add(dto);
        }

        return dtos;
    }
}
