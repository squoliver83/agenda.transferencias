package pratica.avaliacao.agenda.transferencias.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double saldo;

    public Conta() {}

    public Conta(Long id, Double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        if (!id.equals(conta.id)) return false;
        return Objects.equals(saldo, conta.saldo);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (saldo != null ? saldo.hashCode() : 0);
        return result;
    }
}
