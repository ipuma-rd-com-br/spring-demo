package br.com.rd.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @Column(name = "CD_PRODUTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DS_PRODUTO")
    private String descricao;

    @Column(name = "DS_PRODUTO_COMPLETA")
    private String descricaoCompleta;

    @ManyToOne
    @JoinColumn(name = "CD_CATEGORIA")
    private Categoria categoria;

    @Column(name = "QT_ESTOQUE")
    private Long quantidadeEstoque;

    @Column(name = "VL_UNITARIO")
    private BigDecimal valorUnitario;

}
