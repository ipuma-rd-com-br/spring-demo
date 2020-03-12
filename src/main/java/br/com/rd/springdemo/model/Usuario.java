package br.com.rd.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @Column(name = "CD_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DS_NOME")
    @NotNull
    private String nome;

    @Column(name = "DS_SOBRENOME")
    @NotNull
    private String sobrenome;

    @Column(name = "NR_IDADE")
    private Integer idade;

}
