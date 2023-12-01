package pratica.avaliacao.agenda.transferencias.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pratica.avaliacao.agenda.transferencias.entities.Agendamento;
import pratica.avaliacao.agenda.transferencias.tests.Factory;

@DataJpaTest
public class AgendamentoRepositoryTests {

    @Autowired
    private AgendamentoRepository repository;

    private Long countTotalAgendamentos;

    @BeforeEach
    void setUp() throws Exception {
        countTotalAgendamentos = 2L;
    }

    @Test
    public void saveShouldPersistWithAutoIncrementWhenIdIsNull() {
        Agendamento agendamento = Factory.createAgendamento();
        agendamento.setId(null);

        agendamento = repository.save(agendamento);

        Assertions.assertNotNull(agendamento.getId());
        Assertions.assertEquals(countTotalAgendamentos + 1, agendamento.getId());
    }
}
