package com.java.week5.Service;

import com.java.week5.Dto.InventoryDTO;

import java.util.List;

//Inventory service interface
public interface InventoryService {

    public List<InventoryDTO> getInventoryDetails();

    // public void create(int ID,String itemName,double costprice,double sellprice,int quantity);
    public List<InventoryDTO> create(String itemName,double costprice,double sellprice);
    public List<InventoryDTO> deleteInventoryDetails(String itemName);
    public List<InventoryDTO> updateBuy(String itemName, int quantity);
    public List<InventoryDTO> updateSell(String itemName, int quantity) throws Exception;

}
