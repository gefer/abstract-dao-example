package br.com.abstractdata.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Transient;

@Entity
@NamedNativeQueries({
    @NamedNativeQuery(
            name = "findByBrand",
            resultClass = Product.class,
            query = "select id, name, description, price, brand from products p where p.brand = :brand"
    )
})
public class Product implements Serializable {

    @Transient
    public static final String QUERY_FIND_BY_BRAND = "findByBrand";

    @Transient
    public static final String TABLE_NAME = "products";

    @Transient
    public static final String PARAMETER_BRAND = "brand";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 300)
    private String description;

    @Column()
    private double price;

    @Column(length = 70)
    private String brand;
}
