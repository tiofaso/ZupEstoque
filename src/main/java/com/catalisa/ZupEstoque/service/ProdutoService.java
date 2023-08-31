package com.catalisa.ZupEstoque.service;

import com.catalisa.ZupEstoque.model.Produto;
import com.catalisa.ZupEstoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    HistoricoService historicoService;

    //Método para cadastrar produto
    public Produto cadastraProdutoBase(Produto produto) {
        produtoRepository.save(produto);

        //Atualizando o histórico
        Long id = produtoRepository.count();
        historicoService.salvaHistorico("cadastra",id);

        return produtoRepository.getReferenceById(id);


    }

    //Método que apaga produto
    public void deletaProdutoBase(Long id) {
        Produto deleta = buscarProdutoPorIdBase(id).get();
        deleta.setStatus(false);

        //Atualizando o histórico
        historicoService.salvaHistorico("deleta",id);


        produtoRepository.save(deleta);
    }

    //Método que lista todos os produtos
    public List<Produto> buscaTodosProdutosBase() { return produtoRepository.findAllByStatusTrue();}
    //Método que atualiza produtos
    public Produto atualizaProdutoBase(Long id, Produto produto) {
        Produto atualizaProduto = buscarProdutoPorIdBase(id).get();

        if(atualizaProduto.getId() != null) {
            atualizaProduto.setNome(produto.getNome());
            atualizaProduto.setQuantidade(produto.getQuantidade());
            atualizaProduto.setPreco(produto.getPreco());
            atualizaProduto.setInformacoes(produto.getInformacoes());
            atualizaProduto.setDeposito(produto.getDeposito());
            atualizaProduto.setCorredor(produto.getCorredor());
            atualizaProduto.setEstante(produto.getEstante());
            atualizaProduto.setPrateleira(produto.getPrateleira());
            atualizaProduto.setCodigoDeBarras(produto.getCodigoDeBarras());
            atualizaProduto.setStatus(produto.getStatus());

            //Atualizando o histórico
            historicoService.salvaHistorico("atualiza",id);
        }
        return produtoRepository.save(atualizaProduto);
    }

    //Método que busca um produto pelo id
    public Optional<Produto> buscarProdutoPorIdBase(Long id) {
        return produtoRepository.findById(id);
    }
}
