package com.catalisa.ZupEstoque.mapper;

import com.catalisa.ZupEstoque.dto.HistoricoDTO;
import com.catalisa.ZupEstoque.model.Historico;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class HistoricoMapper {

    public HistoricoDTO toDto (Historico historico) {
        HistoricoDTO dto = new HistoricoDTO();

        dto.setIdProdutoDTO(historico.getIdProduto());
        dto.setDataDTO(historico.getData());
        dto.setHoraDTO(historico.getHora());
        dto.setStatusDTO(historico.getStatus());

        return dto;
    }
}
