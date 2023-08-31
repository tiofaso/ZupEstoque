package com.catalisa.ZupEstoque.controller;

import com.catalisa.ZupEstoque.dto.ProdutoDTO;
import com.catalisa.ZupEstoque.mapper.ProdutoMapper;
import com.catalisa.ZupEstoque.model.Produto;
import com.catalisa.ZupEstoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/zupestoque")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ProdutoMapper produtoMapper;

    @PostMapping(path = "/cadastro") //Cadastra produto no estoque
    public ResponseEntity<ProdutoDTO> cadastrarNovoProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.cadastraProdutoBase(produto);
        return new ResponseEntity<>(produtoMapper.toDto(novoProduto), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/apaga/{id}") //Apaga produto do estoque
    public void apagarProduto(@PathVariable Long id) {
        produtoService.deletaProdutoBase(id);
    }

    @GetMapping(path = "/produtos") //Lista todos os produtos do estoque
    public List<Produto> listarProdutos() {
        return produtoService.buscaTodosProdutosBase();
    }

    @PutMapping(path = "/atualiza/{id}") //Atualiza determinado produto
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto atualizaProduto = produtoService.atualizaProdutoBase(id,produto);
        return new ResponseEntity<>(produtoMapper.toDto(atualizaProduto), HttpStatus.CREATED);

    }

    @GetMapping(path = "/produto/{id}") //Exibe um produto específico
    public Optional<Produto> mostrarProduto(@PathVariable Long id){
        return produtoService.buscarProdutoPorIdBase(id);
    }

}
