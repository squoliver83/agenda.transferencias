package pratica.avaliacao.agenda.transferencias.tests;

import pratica.avaliacao.agenda.transferencias.dto.AgendamentoDTO;
import pratica.avaliacao.agenda.transferencias.entities.Agendamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Factory {

    public static Agendamento createAgendamento() {
        LocalDate dataTransferencia = LocalDate.now().plusDays(1);

        return new Agendamento(1L, "ABCDEFGHIJ", "KLMNOPQRST",
                BigDecimal.valueOf(100.0), BigDecimal.valueOf(12.0), dataTransferencia);
    }

    public static AgendamentoDTO createAgendamentoDTO() {
        Agendamento agendamento = createAgendamento();
        return new AgendamentoDTO(agendamento);
    }

    public static AgendamentoDTO createAgendamentoInsertDTO() {
        return new AgendamentoDTO(null,"ABCDEFGHIJ","KLMNOPQRST",
                BigDecimal.valueOf(100.0), null, LocalDate.now().plusDays(1));
    }
}
