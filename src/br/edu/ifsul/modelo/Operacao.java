/*
 * @Author: Julio Sergio Quadros dos Santos.
 * @Email: julioquadros@hotmail.com
 * @2017 - Todos os Direitos Reservados
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "operacao")
public class Operacao implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_id", sequenceName = "seq_id_operacao", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A data da operação deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_operacao", nullable = false)
    private Calendar dataOperacao;
    @NotNull(message = "A taxa de juro mensal deve ser informada")
    @Column(name = "juro_mensal", nullable = false)
    private Double juroMensal;
    //@NotNull(message = "O Cliente não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_operacao_cliente_id"))        
    private Cliente cliente;
    @OneToMany(mappedBy = "operacao", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Cheque> cheques = new ArrayList<>();

    public Operacao() {
    }
    
    public void adicionarCheque(Cheque obj){
        obj.setOperacao(this);
        this.cheques.add(obj);
    }
    
    public void removerCheque(int index){
        this.cheques.remove(index);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Calendar dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public Double getJuroMensal() {
        return juroMensal;
    }

    public void setJuroMensal(Double juroMensal) {
        this.juroMensal = juroMensal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cheque> getCheques() {
        return cheques;
    }

    public void setCheques(List<Cheque> cheques) {
        this.cheques = cheques;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Operacao other = (Operacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Operacao{" + "id=" + id + ", dataOperacao=" + dataOperacao + ", juroMensal=" + juroMensal + ", cliente=" + cliente + '}';
    }
    
    
    
}
