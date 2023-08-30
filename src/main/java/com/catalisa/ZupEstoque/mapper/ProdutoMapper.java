package com.catalisa.ZupEstoque.mapper;

import com.catalisa.ZupEstoque.dto.ProdutoDTO;
import com.catalisa.ZupEstoque.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public ProdutoDTO toDto(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();

        dto.setNomeDTO(produto.getNome());
        dto.setQuantidadeDTO(produto.getQuantidade());
        dto.setPrecoDTO(produto.getPreco());
        dto.setInformacoesDTO(produto.getInformacoes());
        dto.setDepositoDTO(produto.getDeposito());
        dto.setCorredorDTO(produto.getCorredor());
        dto.setEstanteDTO(produto.getEstante());
        dto.setPrateleiraDTO(produto.getPrateleira());
        dto.setCodigoDeBarrasDTO(produto.getCodigoDeBarras());

        return dto;
    }
}
