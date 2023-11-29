package pratica.avaliacao.agenda.transferencias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pratica.avaliacao.agenda.transferencias.entities.Agendamento;
import pratica.avaliacao.agenda.transferencias.repositories.AgendamentoRepository;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    @Transactional(readOnly = true)
    public List<Agendamento> findAll() {
        return repository.findAll();
    }


}
