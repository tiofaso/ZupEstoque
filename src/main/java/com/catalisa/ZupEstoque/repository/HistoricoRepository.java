package com.catalisa.ZupEstoque.repository;

import com.catalisa.ZupEstoque.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}
