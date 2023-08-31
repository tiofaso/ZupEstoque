package com.catalisa.ZupEstoque.controller;

import com.catalisa.ZupEstoque.dto.HistoricoDTO;
import com.catalisa.ZupEstoque.mapper.HistoricoMapper;
import com.catalisa.ZupEstoque.model.Historico;
import com.catalisa.ZupEstoque.model.Produto;
import com.catalisa.ZupEstoque.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/zupestoque")
public class HistoricoController {
    @Autowired
    HistoricoService historicoService;

    @Autowired
    HistoricoMapper historicoMapper;


    @GetMapping(path = "/historico") //Exibe o histórico de edições dos produtos
    public List<HistoricoDTO> exibeHistorico() {
        List<Historico> listaHistorico = historicoService.exibeHistorico();
        return listaHistorico.stream().map(historicoMapper::toDto).collect(Collectors.toList());
    }
}
