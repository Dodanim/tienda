/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.tienda.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "ProductoEntity.findAll", query = "SELECT p FROM ProductoEntity p")
    , @NamedQuery(name = "ProductoEntity.findByIdProducto", query = "SELECT p FROM ProductoEntity p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "ProductoEntity.findByNombreProducto", query = "SELECT p FROM ProductoEntity p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "ProductoEntity.findByDescripcion", query = "SELECT p FROM ProductoEntity p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "ProductoEntity.findByPrecio", query = "SELECT p FROM ProductoEntity p WHERE p.precio = :precio")})
public class ProductoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    private BigDecimal precio;

    public ProductoEntity() {
    }

    public ProductoEntity(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public ProductoEntity(Integer idProducto, String nombreProducto, String descripcion, BigDecimal precio) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoEntity)) {
            return false;
        }
        ProductoEntity other = (ProductoEntity) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.tienda.entities.ProductoEntity[ idProducto=" + idProducto + " ]";
    }
    
}
