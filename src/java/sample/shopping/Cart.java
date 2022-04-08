
package sample.shopping;

import java.util.HashMap;
import java.util.Map;
import sample.vegetable.vegetableDTO;

public class Cart {
    private Map<String, vegetableDTO> cart;
    
    private Cart(Map<String, vegetableDTO> cart) {
        this.cart = cart;
    }

    public Cart() {
    }
    
    public Map<String, vegetableDTO> getCart() {
        return cart;
    }
    
    public void setCart(Map<String, vegetableDTO> cart) {
        this.cart = cart;
    }
    
    public void add (vegetableDTO vegetable) {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(vegetable.getProductID())) {
            int currentAmount = this.cart.get(vegetable.getProductID()).getAmount();
        }
        cart.put(vegetable.getProductID(), vegetable);
    }
    
    public void delete(String id){
        if(this.cart == null) return;
        if(this.cart.containsKey(id)){
            this.cart.remove(id);
        } 
    }
    
    public void update(vegetableDTO vegetable) {
        if (this.cart == null) return;
        if (this.cart.containsKey(vegetable.getProductID())) {
            this.cart.replace(vegetable.getProductID(), vegetable);
        }
    }
}
