package com.assignment.dao;

import com.assignment.dto.InventoryDTO;

import java.util.List;

public interface InventoryDAO {

    public List<InventoryDTO> getInventoryDetails();
    public List<InventoryDTO> createInventoryDetails(String itemName, double costprice, double sellprice);
    public List<InventoryDTO> deleteInventoryDetails(String itemName);
    public List<InventoryDTO> updateBuy(String itemName, int quantity);
    public List<InventoryDTO> updateSell(String itemName, int quantity);
}
