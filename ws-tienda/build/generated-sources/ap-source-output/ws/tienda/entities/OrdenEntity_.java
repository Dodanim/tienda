package ws.tienda.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-03T22:47:31")
@StaticMetamodel(OrdenEntity.class)
public class OrdenEntity_ { 

    public static volatile SingularAttribute<OrdenEntity, Date> fecha;
    public static volatile SingularAttribute<OrdenEntity, Integer> idCliente;
    public static volatile SingularAttribute<OrdenEntity, Integer> idProducto;
    public static volatile SingularAttribute<OrdenEntity, Integer> cantidad;
    public static volatile SingularAttribute<OrdenEntity, Integer> idOrden;

}