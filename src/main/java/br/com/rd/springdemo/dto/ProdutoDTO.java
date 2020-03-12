package br.com.rd.springdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String descricao;
    private String descricaoCompleta;
    private Long idCategoria;
    private Long quantidadeEstoque;
    private BigDecimal valorUnitario;

}
