package com.catalisa.ZupEstoque.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private String nomeDTO;
    private int quantidadeDTO;
    private double precoDTO;
    private String informacoesDTO;
    private String depositoDTO;
    private String corredorDTO;
    private String estanteDTO;
    private String prateleiraDTO;
    private String codigoDeBarrasDTO;
}
