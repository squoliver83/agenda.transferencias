package pratica.avaliacao.agenda.transferencias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pratica.avaliacao.agenda.transferencias.dto.AgendamentoDTO;
import pratica.avaliacao.agenda.transferencias.entities.Agendamento;
import pratica.avaliacao.agenda.transferencias.repositories.AgendamentoRepository;
import pratica.avaliacao.agenda.transferencias.services.exceptions.InvalidDateException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    @Transactional(readOnly = true)
    public List<AgendamentoDTO> findAll() {
        List<Agendamento> list = repository.findAll();
        return list.stream().map(AgendamentoDTO::new).toList();
    }

    @Transactional
    public AgendamentoDTO insert(AgendamentoDTO dto) {
        LocalDate agora = LocalDate.now();
        if (validaData(agora, dto.getDataTransferencia())) {
            throw new InvalidDateException("Período maior que 50 dias");
        }
        Agendamento entity = new Agendamento();
        entity.setContaOrigem(dto.getContaOrigem());
        entity.setContaDestino(dto.getContaDestino());
        entity.setValor(dto.getValor());
        entity.setData(agora);
        entity.setDataTransferencia(dto.getDataTransferencia());

        BigDecimal taxa = calculaTaxa(entity.getValor(), entity.getData(), entity.getDataTransferencia());
        entity.setTaxa(taxa);

        repository.save(entity);
        return new AgendamentoDTO(entity);
    }

    private BigDecimal calculaTaxa(BigDecimal valor, LocalDate dataInicial, LocalDate dataTransferencia) {
        int dias = (int) ChronoUnit.DAYS.between(dataInicial, dataTransferencia);
        System.out.println(dias);
        BigDecimal taxa = BigDecimal.ZERO;

        if (dias == 0) {
            taxa = (valor.multiply(BigDecimal.valueOf(0.025)).add(BigDecimal.valueOf(3.0))).setScale(2, RoundingMode.HALF_UP);
        } else if (dias >= 1 && dias <= 10) {
            taxa = BigDecimal.valueOf(12.00);
        } else if (dias >= 11 && dias <= 20) {
            taxa = (valor.multiply(BigDecimal.valueOf(0.082))).setScale(2, RoundingMode.HALF_UP);
        } else if (dias >= 21 && dias <= 30) {
            taxa = (valor.multiply(BigDecimal.valueOf(0.069))).setScale(2, RoundingMode.HALF_UP);
        } else if (dias >= 31 && dias <= 40) {
            taxa = (valor.multiply(BigDecimal.valueOf(0.047))).setScale(2, RoundingMode.HALF_UP);
        } else {
            taxa = (valor.multiply(BigDecimal.valueOf(0.017))).setScale(2, RoundingMode.HALF_UP);
        }

        if (!taxa.equals(BigDecimal.ZERO)) {
            return taxa;
        } else {
            throw new ArithmeticException("Taxa não pode ser nula");
        }
    }

    private boolean validaData(LocalDate dataAtual, LocalDate dataTransferencia) {
        try {
            if (dataTransferencia.isBefore(LocalDate.now())) {
                throw new InvalidDateException("Data de transferência não pode ser anterior ao dia de hoje");
            }
            return ChronoUnit.DAYS.between(dataAtual, dataTransferencia) > 50;
        } catch (RuntimeException e) {
            throw new InvalidDateException("Data de transferência inválida ou nula");
        }
    }
}
