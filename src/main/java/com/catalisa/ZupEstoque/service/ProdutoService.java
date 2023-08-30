package com.catalisa.ZupEstoque.service;

import com.catalisa.ZupEstoque.model.Produto;
import com.catalisa.ZupEstoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.element.ModuleElement;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    //Método para cadastrar produto
    public Produto cadastraProdutoBase(Produto produto) {
        return produtoRepository.save(produto);
    }

    //Método que apaga produto
    public void deletaProdutoBase(Long id) { produtoRepository.deleteById(id); }

    //Método que lista todos os produtos
    public List<Produto> buscaTodosProdutosBase() { return produtoRepository.findAll(); }

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
        }

        return produtoRepository.save(atualizaProduto);
    }

    //Método que busca um produto pelo id
    public Optional<Produto> buscarProdutoPorIdBase(Long id) {
        return produtoRepository.findById(id);
    }
}
