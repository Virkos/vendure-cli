package ch.projectSE;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductList {

    private List<Product> items;
    private int totalItems;

    public ProductList() {}

    public ProductList(List<Product> items, int totalItems) {
        this.items = items;
        this.totalItems = totalItems;
    }
    public List<Product> getItems() {
        return items;
    }
    public void setItems(List<Product> items) {
        this.items = items;
    }
    public int getTotalItems() {
        return totalItems;
    }
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}
