package pratica.avaliacao.agenda.transferencias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pratica.avaliacao.agenda.transferencias.entities.Agendamento;
import pratica.avaliacao.agenda.transferencias.services.AgendamentoService;

import java.util.List;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @GetMapping
    public ResponseEntity<List<Agendamento>> findAll() {
        List<Agendamento> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


}
