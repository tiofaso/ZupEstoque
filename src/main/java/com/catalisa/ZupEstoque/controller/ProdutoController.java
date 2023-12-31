package com.catalisa.ZupEstoque.controller;

import com.catalisa.ZupEstoque.dto.ProdutoDTO;
import com.catalisa.ZupEstoque.mapper.ProdutoMapper;
import com.catalisa.ZupEstoque.model.Produto;
import com.catalisa.ZupEstoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/zupestoque")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ProdutoMapper produtoMapper;

    @PostMapping(path = "/cadastro") //Cadastra produto no estoque
    public ResponseEntity<ProdutoDTO> cadastrarNovoProduto(@RequestBody @Valid Produto produto) {
        Produto novoProduto = produtoService.cadastraProdutoBase(produto);
        return new ResponseEntity<>(produtoMapper.toDto(novoProduto), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/produto/{id}") //Apaga produto do estoque
    public void apagarProduto(@PathVariable Long id) {
        produtoService.deletaProdutoBase(id);
    }

    @GetMapping(path = "/produtos") //Lista todos os produtos do estoque
    public List<ProdutoDTO> listarProdutos() {
        List<Produto> listaProdutos = produtoService.buscaTodosProdutosBase();
        return listaProdutos.stream().map(produtoMapper::toDto).collect(Collectors.toList());
    }

    @PutMapping(path = "/produto/{id}") //Atualiza determinado produto
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody @Valid Produto produto) {
            Produto atualizaProduto = produtoService.atualizaProdutoBase(id,produto);
            return new ResponseEntity<>(produtoMapper.toDto(atualizaProduto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/produto/{id}") //Exibe um produto específico
    public List<ProdutoDTO> mostrarProduto(@PathVariable Long id){
        Optional<Produto> listaProdutoPorId = produtoService.buscarProdutoPorIdBase(id);
        return listaProdutoPorId.stream().map(produtoMapper::toDto).collect(Collectors.toList());


    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}
