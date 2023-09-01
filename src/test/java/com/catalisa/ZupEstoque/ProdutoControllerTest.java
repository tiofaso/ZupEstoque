package com.catalisa.ZupEstoque;

import com.catalisa.ZupEstoque.controller.ProdutoController;
import com.catalisa.ZupEstoque.mapper.ProdutoMapper;
import com.catalisa.ZupEstoque.service.ProdutoService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProdutoController.class)
public class ProdutoControllerTest {
    @MockBean
    private ProdutoService produtoService;

    @MockBean
    private ProdutoMapper produtoMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test //Teste do endpoint de cadastro de produto
    public void cadastraNovoProdutoTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/zupestoque/cadastro")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"papel novo\",\"quantidade\":10,\"preco\":50.0,\"informacoes\":\"segundo produto do estoque\",\"deposito\":\"B\",\"corredor\":\"4\",\"estante\":\"6\",\"prateleira\":\"11\",\"codigoDeBarras\":\"978020137966\",\"status\":true}"))
                .andExpect(status().isCreated());
    }

    @Test //Teste do endpoint de delete
    public void apagarProdutoTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/api/zupestoque/produto/{id}", "0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test // Teste do endpoint de atualizacao de produto
    public void atualizarProdutoTest() throws Exception {
        Long produtoId = 1L;

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/zupestoque/produto/{id}", produtoId) // Provide the actual ID here
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"papel novo de novo\",\"quantidade\":10,\"preco\":50.0,\"informacoes\":\"segundo produto do estoque\",\"deposito\":\"B\",\"corredor\":\"4\",\"estante\":\"6\",\"prateleira\":\"11\",\"codigoDeBarras\":\"978020137966\",\"status\":true}"))
                .andExpect(status().isCreated());
    }

    @Test // Teste do endpoint para listar um produto específico
    public void buscaProdutoEspecificoTest() throws Exception {
        Long produtoId = 1L;

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/zupestoque/produto/{id}", produtoId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"papel novo de novo\",\"quantidade\":10,\"preco\":50.0,\"informacoes\":\"segundo produto do estoque\",\"deposito\":\"B\",\"corredor\":\"4\",\"estante\":\"6\",\"prateleira\":\"11\",\"codigoDeBarras\":\"978020137966\",\"status\":true}"))
                .andExpect(status().isOk());
    }


    @Test // Teste do endpoint para listar todos os produtos
    public void listarProdutosTest() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/zupestoque/produtos/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"papel novo de novo\",\"quantidade\":10,\"preco\":50.0,\"informacoes\":\"segundo produto do estoque\",\"deposito\":\"B\",\"corredor\":\"4\",\"estante\":\"6\",\"prateleira\":\"11\",\"codigoDeBarras\":\"978020137966\",\"status\":true}"))
                .andExpect(status().isOk());
    }

}
