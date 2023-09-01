package com.catalisa.ZupEstoque;

import com.catalisa.ZupEstoque.controller.HistoricoController;
import com.catalisa.ZupEstoque.controller.ProdutoController;
import com.catalisa.ZupEstoque.mapper.HistoricoMapper;
import com.catalisa.ZupEstoque.service.HistoricoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(HistoricoController.class)
public class HistoricoControllerTest {
    @MockBean
    private HistoricoService historicoService;

    @MockBean
    private HistoricoMapper historicoMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test // Teste do endpoint para listar log
    public void listarProdutosTest() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/zupestoque/historico/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"idProdutoDTO\":1,\"dataDTO\":\"2023-08-31\",\"horaDTO\":\"11:28:32\",\"statusDTO\":\"cadastra\"}"))
                         .andExpect(status().isOk());
    }
}
