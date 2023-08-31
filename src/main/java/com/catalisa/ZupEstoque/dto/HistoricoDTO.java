package com.catalisa.ZupEstoque.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoDTO {

    private Long idProdutoDTO;
    private LocalDate dataDTO;
    private LocalTime horaDTO;
    private String statusDTO;
}
