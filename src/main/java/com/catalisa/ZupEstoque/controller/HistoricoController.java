package com.catalisa.ZupEstoque.controller;

import com.catalisa.ZupEstoque.model.Historico;
import com.catalisa.ZupEstoque.model.Produto;
import com.catalisa.ZupEstoque.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/zupestoque")
public class HistoricoController {
    @Autowired
    HistoricoService historicoService;

    @GetMapping(path = "/historico") //Exibe o histórico de edições dos produtos
    public List<Historico> exibeHistorico() {
        return null;
    }
}
