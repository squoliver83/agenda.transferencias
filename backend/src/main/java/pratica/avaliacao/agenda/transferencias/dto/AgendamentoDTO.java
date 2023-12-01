package pratica.avaliacao.agenda.transferencias.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import pratica.avaliacao.agenda.transferencias.entities.Agendamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AgendamentoDTO {
    private Long id;
    @NotBlank(message = "É preciso informar uma conta de origem")
    @Size(min = 10, max = 10, message = "Conta precisa de 10 caracteres")
    private String contaOrigem;
    @NotBlank(message = "É preciso informar uma conta de destino")
    @Size(min = 10, max = 10, message = "Conta precisa de 10 caracteres")
    private String contaDestino;
    @Positive(message = "Valor deve ser positivo")
    @NotNull(message = "Valor não deve ser nulo")
    private BigDecimal valor;
    private BigDecimal taxa;
    @FutureOrPresent(message = "Data final precisa ser no presente ou futura")
    private LocalDate dataTransferencia;
    private LocalDate data;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Long id, String contaOrigem, String contaDestino, BigDecimal valor, BigDecimal taxa, LocalDate dataTransferencia) {
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.taxa = taxa;
        this.dataTransferencia = dataTransferencia;
        this.data = LocalDate.now();
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public LocalDate getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDate dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
