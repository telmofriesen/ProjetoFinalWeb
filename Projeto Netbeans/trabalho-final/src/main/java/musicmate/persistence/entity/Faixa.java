/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicmate.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johntheo
 */
@Entity
@Table(name = "FAIXA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faixa.findAll", query = "SELECT f FROM Faixa f"),
    @NamedQuery(name = "Faixa.findByCodigo", query = "SELECT f FROM Faixa f WHERE f.codigo = :codigo"),
    @NamedQuery(name = "Faixa.findByNumero", query = "SELECT f FROM Faixa f WHERE f.numero = :numero"),
    @NamedQuery(name = "Faixa.findByTitulo", query = "SELECT f FROM Faixa f WHERE f.titulo = :titulo"),
    @NamedQuery(name = "Faixa.findByDuracao", query = "SELECT f FROM Faixa f WHERE f.duracao = :duracao")})
public class Faixa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "duracao")
    private Integer duracao;
    @JoinColumn(name = "codigo_album", referencedColumnName = "codigo")
    @ManyToOne
    private Album codigoAlbum;

    public Faixa() {
    }

    public Faixa(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Album getCodigoAlbum() {
        return codigoAlbum;
    }

    public void setCodigoAlbum(Album codigoAlbum) {
        this.codigoAlbum = codigoAlbum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faixa)) {
            return false;
        }
        Faixa other = (Faixa) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "musicmate.persistence.entity.Faixa[ codigo=" + codigo + " ]";
    }
    
}
