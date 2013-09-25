/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author telmo
 */
@Entity
@Table(name="revendedor")
@NamedQueries({
    @NamedQuery(name = "Revendedor.findAll", query = "SELECT r FROM Revendedor r")})
public class Revendedor implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnpj")
    private Long cnpj;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "razaoSocial")
    private String razaoSocial;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "endereco")
    private String endereco;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cidade")
    private String cidade;
    
    @JoinColumn(name = "estado", referencedColumnName = "codigo")
    @NotNull
    @ManyToOne(optional = false)
    private Estado estado;
    
    @JoinColumn(name = "regiaoDeAtuacao", referencedColumnName = "codigo")
    @NotNull
    @ManyToOne(optional = false)
    private Regiao regiaoDeAtuacao;
    
    @JoinColumn(name = "estadoDeAtuacao", referencedColumnName = "codigo")
    @NotNull
    @ManyToOne(optional = false)
    private Estado estadoDeAtuacao;

    public Revendedor(){
        estado = new Estado();
        regiaoDeAtuacao = new Regiao();
        estadoDeAtuacao = new Estado();
    }
    
    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razao_social) {
        this.razaoSocial = razao_social;
    }
    
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nome_fantasia) {
        this.nomeFantasia = nome_fantasia;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public Regiao getRegiaoDeAtuacao() {
        return regiaoDeAtuacao;
    }

    public void setRegiaoDeAtuacao(Regiao regiaoDeAtuacao) {
        this.regiaoDeAtuacao = regiaoDeAtuacao;
    }
    
    public Estado getEstadoDeAtuacao() {
        return estadoDeAtuacao;
    }

    public void setEstadoDeAtuacao(Estado estadoDeAtuacao) {
        this.estadoDeAtuacao = estadoDeAtuacao;
    }
}
