/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.tienda.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author KiDo
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "ClienteEntity.findAll", query = "SELECT c FROM ClienteEntity c")
    , @NamedQuery(name = "ClienteEntity.findByIdCliente", query = "SELECT c FROM ClienteEntity c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "ClienteEntity.findByNombreCliente", query = "SELECT c FROM ClienteEntity c WHERE c.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "ClienteEntity.findByApellidoCliente", query = "SELECT c FROM ClienteEntity c WHERE c.apellidoCliente = :apellidoCliente")})
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellido_cliente")
    private String apellidoCliente;

    public ClienteEntity() {
    }

    public ClienteEntity(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public ClienteEntity(Integer idCliente, String nombreCliente, String apellidoCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteEntity)) {
            return false;
        }
        ClienteEntity other = (ClienteEntity) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.tienda.entities.ClienteEntity[ idCliente=" + idCliente + " ]";
    }
    
}
