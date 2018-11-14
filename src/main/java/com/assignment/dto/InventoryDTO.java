package com.assignment.dto;

import java.util.Objects;

public class InventoryDTO {

    //Declaring Variables;
    //private int id;
    private String itemName;
    private double costPrice;
    private double sellPrice;
    private int quantity;

//Getters and setters implementation
    public String getItemName(){

        return itemName;
    }

    public void setItemName(String itemName) {

        this.itemName = itemName;
    }

    public double getCostPrice() {

        return costPrice;
    }

    public void setCostPrice(double costPrice) {

        this.costPrice = costPrice;
    }

    public double getSellPrice() {

        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {

        this.sellPrice = sellPrice;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    //Constructor with argments
    public InventoryDTO(String itemName, double costPrice, double sellPrice, int quantity){

        //this.id=id;
        this.itemName = itemName;
        this.costPrice=costPrice;
        this.sellPrice=sellPrice;
        this.quantity=quantity;
    }
    //tostring method
    public String toString() {
        return "InventoryDTO{" +
                //"id'" + id + '\'' +
                "itemName='" + itemName + '\'' +
                ", costPrice=" + costPrice +
                ", sellPrice=" + sellPrice +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryDTO that = (InventoryDTO) o;
        return (Double.compare(that.costPrice, costPrice) == 0) &&
                (Double.compare(that.sellPrice, sellPrice) == 0) &&
                (quantity == that.quantity) &&
                Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemName, costPrice, sellPrice, quantity);
    }


}
