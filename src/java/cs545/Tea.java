/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs545;

/**
 *
 * @author BMX
 */
public class Tea {
    private String name = "";
    private String description = "";
    private String imagePath = "";
    private String type = "";
    private double price = 0;
    private double totalPrice = 0;
    private boolean select = false;
    private int qty = 0;
    
    public Tea() {
        
    }
    
    public Tea(String name, String description, String imagePath, String type, double price) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return this.qty * this.price;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.qty = select ? 1 : 0;
        this.select = select ;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
}
