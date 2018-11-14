package com.assignment.service;

import com.assignment.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {

    public List<InventoryDTO> getInventoryDetails();

    // public void create(int ID,String itemName,double costprice,double sellprice,int quantity);
    public List<InventoryDTO> createInventoryDetails(String itemName,double costprice,double sellprice);
    public List<InventoryDTO> deleteInventoryDetails(String itemName);
    public List<InventoryDTO> updateBuy(String itemName, int quantity);
    public List<InventoryDTO> updateSell(String itemName, int quantity);
   // public void report();

}
