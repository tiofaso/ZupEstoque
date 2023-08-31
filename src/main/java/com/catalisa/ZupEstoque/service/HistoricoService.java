package com.catalisa.ZupEstoque.service;

import com.catalisa.ZupEstoque.model.Historico;
import com.catalisa.ZupEstoque.repository.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class HistoricoService {

    @Autowired
    HistoricoRepository historicoRepository;

    //Método para salvar histórico
    public Historico salvaHistorico(String status, Long id) {
        Historico registroEstoque = new Historico();

        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.now();

        registroEstoque.setIdProduto(id);
        registroEstoque.setData(data);
        registroEstoque.setHora(hora);
        registroEstoque.setStatus(status);

        return historicoRepository.save(registroEstoque);

    }
}
