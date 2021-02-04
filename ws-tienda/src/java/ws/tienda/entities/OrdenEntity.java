/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.tienda.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author KiDo
 */
@Entity
@Table(name = "orden")
@NamedQueries({
    @NamedQuery(name = "OrdenEntity.findAll", query = "SELECT o FROM OrdenEntity o")
    , @NamedQuery(name = "OrdenEntity.findByIdOrden", query = "SELECT o FROM OrdenEntity o WHERE o.idOrden = :idOrden")
    , @NamedQuery(name = "OrdenEntity.findByIdCliente", query = "SELECT o FROM OrdenEntity o WHERE o.idCliente = :idCliente")
    , @NamedQuery(name = "OrdenEntity.findByIdProducto", query = "SELECT o FROM OrdenEntity o WHERE o.idProducto = :idProducto")
    , @NamedQuery(name = "OrdenEntity.findByCantidad", query = "SELECT o FROM OrdenEntity o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "OrdenEntity.findByFecha", query = "SELECT o FROM OrdenEntity o WHERE o.fecha = :fecha")})
public class OrdenEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden")
    private Integer idOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public OrdenEntity() {
    }

    public OrdenEntity(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public OrdenEntity(Integer idOrden, int idCliente, int idProducto, int cantidad, Date fecha) {
        this.idOrden = idOrden;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenEntity)) {
            return false;
        }
        OrdenEntity other = (OrdenEntity) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.tienda.entities.OrdenEntity[ idOrden=" + idOrden + " ]";
    }
    
}
