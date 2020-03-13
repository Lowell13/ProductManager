package fr.imie.productmanager.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries( {
        @NamedQuery(name = "listCategory", query = "SELECT c FROM Category AS c"),
        @NamedQuery(name = "categoryByName", query = "SELECT c FROM Category AS c WHERE c.name = :categoryName"),
        @NamedQuery(name = "categoryById", query = "SELECT c FROM Category AS c WHERE c.id = :categoryId"),
})
@Table(name = "category")
@XmlRootElement(name = "categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public Category() {
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

    @XmlElement(name = "product-list")
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }
}
