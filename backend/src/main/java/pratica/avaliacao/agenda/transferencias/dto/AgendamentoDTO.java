package pratica.avaliacao.agenda.transferencias.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import pratica.avaliacao.agenda.transferencias.entities.Agendamento;

import java.time.Instant;

public class AgendamentoDTO {
    private Long id;
    @NotBlank(message = "É preciso informar uma conta de origem")
    private String contaOrigem;
    @NotBlank(message = "É preciso informar uma conta de destino")
    private String contaDestino;
    @Positive(message = "Valor deve ser positivo")
    private Double valor;
    private Double taxa;
    @FutureOrPresent(message = "Data final precisa ser no presente ou futura")
    private Instant dataTransferencia;
    private Instant data;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Long id, String contaOrigem, String contaDestino, Double valor, Double taxa, Instant dataTransferencia) {
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.taxa = taxa;
        this.dataTransferencia = dataTransferencia;
        this.data = Instant.now();
    }

    public AgendamentoDTO(Agendamento entity) {
        id = entity.getId();
        contaOrigem = entity.getContaOrigem();
        contaDestino = entity.getContaDestino();
        valor = entity.getValor();
        taxa = entity.getTaxa();
        dataTransferencia = entity.getDataTransferencia();
        data = entity.getData();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Instant getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Instant dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }
}
