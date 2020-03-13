package fr.imie.productmanager.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "productById", query = "SELECT p FROM Product AS p WHERE p.id = :productId"),
        @NamedQuery(name = "productByCategory", query = "SELECT p FROM Product AS p WHERE p.category.id = :categoryId"),
        @NamedQuery(name = "productLtPrice", query = "SELECT p FROM Product AS p WHERE p.price < :price"),
        @NamedQuery(name = "listProduct", query = "SELECT p FROM Product AS p"),
})
@Table(name = "product")
@XmlRootElement(name = "products")
public class Product implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private float price;
    @ManyToOne @JoinColumn(name = "category_fk")
    private Category category;

    public Product() {
    }

    public Product(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @XmlElement(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "price")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @XmlElement(name = "category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
