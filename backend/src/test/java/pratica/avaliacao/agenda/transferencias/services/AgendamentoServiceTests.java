package pratica.avaliacao.agenda.transferencias.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pratica.avaliacao.agenda.transferencias.dto.AgendamentoDTO;
import pratica.avaliacao.agenda.transferencias.entities.Agendamento;
import pratica.avaliacao.agenda.transferencias.repositories.AgendamentoRepository;
import pratica.avaliacao.agenda.transferencias.tests.Factory;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AgendamentoServiceTests {

    @InjectMocks
    private AgendamentoService service;

    @Mock
    private AgendamentoRepository repository;

    private Agendamento agendamento;

    @BeforeEach
    void setUp() throws Exception {
        agendamento = Factory.createAgendamento();
        List<Agendamento> list = new ArrayList<>(List.of(agendamento));

        when(repository.findAll()).thenReturn(list);
    }

    @Test
    public void findAllShouldReturnList() {
        List<AgendamentoDTO> list = service.findAll();
        Assertions.assertNotNull(list);
        verify(repository, times(1)).findAll();
    }

}
