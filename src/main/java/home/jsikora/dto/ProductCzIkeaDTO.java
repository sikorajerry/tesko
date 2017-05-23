package home.jsikora.dto;



import javax.persistence.*;

/**
 * Created by sungsam on 23.5.17.
 */
@Entity
@Table(name = "productCz")
public class ProductCzIkeaDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String serialNumber;

    private String productName;

    private String price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductCzIkeaDTO(String serialNumber, String productName, String price) {
        this.serialNumber = serialNumber;
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductCzIkeaDTO{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
