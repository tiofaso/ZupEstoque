package com.catalisa.ZupEstoque.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private double preco;

    @Column(length = 255, nullable = false)
    private String informacoes;

    @Column(length = 3, nullable = false)
    private String deposito;

    @Column(length = 3, nullable = false)
    private String corredor;

    @Column(length = 3, nullable = false)
    private String estante;

    @Column(length = 3, nullable = false)
    private String prateleira;

    @Column(length = 13, nullable = false)
    private String codigoDeBarras;

    @Column(nullable = false)
    private Boolean status;
}
