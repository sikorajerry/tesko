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

    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCzIkeaDTO(String serialNumber, String productName, double price) {
        this.serialNumber = serialNumber;
        this.productName = productName;
        this.price = price;
    }


}
