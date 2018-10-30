package com.java.week5.Dao;

import com.java.week5.Dto.InventoryDTO;
import java.util.List;


// This is a interface class
/*This has few methods
Implemented at InventoryDAOImpl
 */
public interface InventoryDAO {

    public List<InventoryDTO> getInventoryDetails();

   // public void create(int ID,String itemName,double costprice,double sellprice,int quantity);
    public List<InventoryDTO> create(String itemName,double costprice,double sellprice);
    public List<InventoryDTO> deleteInventoryDetails(String itemName);
    public List<InventoryDTO> updateBuy(String itemName, int quantity);
    public List<InventoryDTO> updateSell(String itemName, int quantity) throws Exception;


}
