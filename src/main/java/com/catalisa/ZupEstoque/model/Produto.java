package com.catalisa.ZupEstoque.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;


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
    @NotBlank(message = "O nome do produto não pode estar em branco")
    private String nome;

    @Column(nullable = false)
    @Positive(message = "A quantidade do produto não pode estar em branco")
    private int quantidade;

    @Column(nullable = false)
    @Positive(message = "O preço do produto não pode estar em branco")
    private double preco;

    @Column(length = 255, nullable = false)
    @NotBlank(message = "As informações do produto não podem estar em branco")
    @Size(min = 5, max = 255, message = "Você pode digitar até 255 caracteres")
    private String informacoes;

    @Column(length = 3, nullable = false)
    @NotBlank(message = "O valor do depósito não pode estar em branco")
    @Size(min = 1, max = 3, message = "Você pode digitar até 3 caracteres")
    private String deposito;

    @Column(length = 3, nullable = false)
    @NotBlank(message = "O valor do corredor não pode estar em branco")
    @Size(min = 1, max = 3, message = "Você pode digitar até 3 caracteres")
    private String corredor;

    @Column(length = 3, nullable = false)
    @NotBlank(message = "O valor da estante não pode estar em branco")
    @Size(min = 1, max = 3, message = "Você pode digitar até 3 caracteres")
    private String estante;

    @Column(length = 3, nullable = false)
    @NotBlank(message = "O valor da prateleira não pode estar em branco")
    @Size(min = 1, max = 3, message = "Você pode digitar até 3 caracteres")
    private String prateleira;

    @Column(length = 13, nullable = false)
    @NotBlank(message = "O código de barras do produto não podem estar em branco")
    @Size(min = 12,max = 13, message = "O código de barras tem pelo menos 12 números")
    private String codigoDeBarras;

    @Column(nullable = false)
    private Boolean status;
}
