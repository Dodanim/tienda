package ws.tienda.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-03T22:47:31")
@StaticMetamodel(ProductoEntity.class)
public class ProductoEntity_ { 

    public static volatile SingularAttribute<ProductoEntity, String> descripcion;
    public static volatile SingularAttribute<ProductoEntity, BigDecimal> precio;
    public static volatile SingularAttribute<ProductoEntity, Integer> idProducto;
    public static volatile SingularAttribute<ProductoEntity, String> nombreProducto;

}