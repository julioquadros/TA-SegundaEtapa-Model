/*
 * @Author: Julio Sergio Quadros dos Santos.
 * @Email: julioquadros@hotmail.com
 * @2017 - Todos os Direitos Reservados
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "cheque")
public class Cheque implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_id", sequenceName = "seq_id_cheque", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O Código do Banco não pode ser nulo")
    @Length(max = 10, message = "O Código do Banco não pode ser nulo")
    @NotBlank(message = "O Código do Banco não pode ser nulo")
    @Column(name = "banco", length = 10, nullable = false)
    private String banco;
    @NotNull(message = "O Código da Agência não pode ser nulo")
    @Length(max = 15, message = "O Código da Agência não pode ser nulo")
    @NotBlank(message = "O Código da Agência não pode ser nulo")
    @Column(name = "agencia", length = 15, nullable = false)
    private String agencia;
    @NotNull(message = "O Número da Conta não pode ser nulo")
    @Length(max = 20, message = "O Número da Conta não pode ser nulo")
    @NotBlank(message = "O Número da Conta não pode ser nulo")
    @Column(name = "num_conta", length = 20, nullable = false)
    private String numConta;
    @NotNull(message = "O Número do Cheque não pode ser nulo")
    @Length(max = 20, message = "O Número do Cheque não pode ser nulo")
    @NotBlank(message = "O Número do Cheque não pode ser nulo")
    @Column(name = "num_cheque", length = 20, nullable = false)
    private String numCheque;
    @NotNull(message = "A data de depósito deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_deposito", nullable = false)
    private Calendar dataDeposito;
    @NotNull(message = "O valor do cheque não pode ser nulo")
    @Min(value = 0, message = "O valor do cheque não pode ser negativo")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(12,2)")    
    private Double valor;
    @NotNull(message = "O CPF ou CNPJ do emitente não pode ser nulo")
    @Length(max = 14, message = "O CPF ou CNPJ do emitente não pode ter mais de {max} caracteres")
    @NotBlank(message = "O CPF ou CNPJ do emitente não pode ser em branco")
    @Column(name = "cpf_cnpj_emitente", length = 14, nullable = false) 
    private String emitenteCpfCnpj;
    @NotNull(message = "O cheque deve pertencer a uma operação!")
    @ManyToOne
    @JoinColumn(name = "operacao", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_cheque_operacao_id"))        
    private Operacao operacao;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataDeposito() {
        return dataDeposito;
    }

    public void setDataDeposito(Calendar dataDeposito) {
        this.dataDeposito = dataDeposito;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getEmitenteCpfCnpj() {
        return emitenteCpfCnpj;
    }

    public void setEmitenteCpfCnpj(String emitenteCpfCnpj) {
        this.emitenteCpfCnpj = emitenteCpfCnpj;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getNumCheque() {
        return numCheque;
    }

    public void setNumCheque(String numCheque) {
        this.numCheque = numCheque;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cheque other = (Cheque) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cheque{" + "dataDeposito=" + dataDeposito + ", valor=" + valor + ", emitenteCpfCnpj=" + emitenteCpfCnpj + '}';
    }
    
    
        
}
