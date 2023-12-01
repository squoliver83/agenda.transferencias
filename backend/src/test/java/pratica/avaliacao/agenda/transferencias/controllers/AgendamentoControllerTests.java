package pratica.avaliacao.agenda.transferencias.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import pratica.avaliacao.agenda.transferencias.dto.AgendamentoDTO;
import pratica.avaliacao.agenda.transferencias.services.AgendamentoService;
import pratica.avaliacao.agenda.transferencias.tests.Factory;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AgendamentoController.class)
public class AgendamentoControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private AgendamentoService service;
    private AgendamentoDTO agendamentoDTO;

    private List<AgendamentoDTO> list;


    @BeforeEach
    void setUp() throws Exception {
        agendamentoDTO = Factory.createAgendamentoDTO();
        list = new ArrayList<>(List.of(agendamentoDTO));

        when(service.findAll()).thenReturn(list);

        when(service.insert(any())).thenReturn(agendamentoDTO);
    }

    @Test
    public void findAllShouldReturnList() throws Exception {
        ResultActions result =
                mockMvc.perform(get("/api/agendamentos")
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
    }

    @Test
    public void insertShouldReturnAgendamentoDtoCreated() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(
                Factory.createAgendamentoInsertDTO());
        ResultActions result =
                mockMvc.perform(post("/api/agendamentos")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isCreated());
    }

}
