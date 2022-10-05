package dev.carlosandrade.investimentos.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.carlosandrade.investimentos.entity.Ativo;
import dev.carlosandrade.investimentos.repository.AtivoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(AtivosController.class)
class AtivosControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private AtivoRepository repository ;

    @Test
    void getAll() throws Exception {
        //Arrange
        RequestBuilder request = MockMvcRequestBuilders.get("/ativos/all");
        //Act
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();;
        //Assert

    }

    @Test
    void getCreate() throws Exception {

        Ativo ativo = Ativo.builder().ticker("VALE3").nome("VALE ON").tipoAtivo("Ações").build();

        String jsonContent = mapper.writeValueAsString(ativo);

        //Arrange
        RequestBuilder request = MockMvcRequestBuilders.post("/ativos")
                .content(jsonContent)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        //Act
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();

        //Assert
        String returnEntity = result.getResponse().getContentAsString();
        System.out.println(returnEntity);
    }

    @Test
    void getRead() throws Exception {

        String ticker = "VALE3";
        //Arrange
        RequestBuilder request = MockMvcRequestBuilders.get("/ativos/"+ticker);
        //Act
        MvcResult result = mvc.perform(request).andExpect(status().isOk()).andReturn();
        //Assert

    }

}