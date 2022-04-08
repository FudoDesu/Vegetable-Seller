
package sample.vegetable;

public class vegetableDTO {
    private String productID;
    private String productName;
    private String category;
    private int productPrice;
    private int amount;  
    private int quantity;            
    private String description;

    public vegetableDTO() {
    }

    public vegetableDTO(String productID, String productName, String category, int productPrice, int quantity, String description) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.description = description;
    }
     
    public vegetableDTO(String productID, String productName, String category, int productPrice, int quantity, int amount, String description) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.amount = amount;
        this.description = description;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
