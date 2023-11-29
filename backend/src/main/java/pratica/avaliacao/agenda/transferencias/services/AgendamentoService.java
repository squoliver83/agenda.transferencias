package pratica.avaliacao.agenda.transferencias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pratica.avaliacao.agenda.transferencias.dto.AgendamentoDTO;
import pratica.avaliacao.agenda.transferencias.entities.Agendamento;
import pratica.avaliacao.agenda.transferencias.repositories.AgendamentoRepository;
import pratica.avaliacao.agenda.transferencias.services.exceptions.InvalidDateException;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    @Transactional(readOnly = true)
    public List<AgendamentoDTO> findAll() {
        List<Agendamento> list = repository.findAll();
        return list.stream().map(agendamento -> new AgendamentoDTO(agendamento)).toList();
    }

    @Transactional
    public AgendamentoDTO insert(AgendamentoDTO dto) {
        Instant agora = Instant.now();
        if (validaData(agora, dto.getDataTransferencia())) {
            throw new InvalidDateException("Período maior que 50 dias");
        }
        Agendamento entity = new Agendamento();
        entity.setContaOrigem(dto.getContaOrigem());
        entity.setContaDestino(dto.getContaDestino());
        entity.setValor(dto.getValor());
        entity.setData(agora);
        entity.setDataTransferencia(dto.getDataTransferencia());

        Double taxa = calculaTaxa(entity.getValor(), entity.getData(), entity.getDataTransferencia());
        entity.setTaxa(taxa);

        repository.save(entity);
        return new AgendamentoDTO(entity);
    }

    private Double calculaTaxa(Double valor, Instant dataInicial, Instant dataTransferencia) {
        int dias = (int) ChronoUnit.DAYS.between(dataInicial, dataTransferencia);
        double taxa = 0.0;
        if (dias == 0) {
            taxa = valor * 0.025 + 3.00;
        } else if (dias >= 1 && dias <= 10) {
            taxa = 12.00;
        } else if (dias >= 11 && dias <= 20) {
            taxa = valor * 0.082;
        } else if (dias >= 21 && dias <= 30) {
            taxa = valor * 0.069;
        } else if (dias >= 31 && dias <= 40) {
            taxa = valor * 0.047;
        } else {
            taxa = valor * 0.017;
        }
        if (taxa != 0.0) {
            return taxa;
        }
        throw new ArithmeticException("Tax can't be zero");
    }

    private boolean validaData(Instant dataAtual, Instant dataTransferencia) {
        return ChronoUnit.DAYS.between(dataAtual, dataTransferencia) > 50;
    }
}
