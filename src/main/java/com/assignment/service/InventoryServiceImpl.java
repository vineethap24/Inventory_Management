package com.assignment.service;

import com.assignment.Log4j.Log4j;
import com.assignment.dao.InventoryDAO;
import com.assignment.dao.InventoryDAOImpl;
import com.assignment.dto.InventoryDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.assignment.Log4j.Log4j;


public class InventoryServiceImpl implements InventoryService {

    InventoryDAOImpl dao = new InventoryDAOImpl();
    final static Logger logger = (Logger) Logger.getLogger(String.valueOf(Log4j.class));
    List<InventoryDTO> dtoList= new ArrayList<InventoryDTO>();

    public List<InventoryDTO> getInventoryDetails() {
        logger.info("inside InventoryDetail method and as parameter");
        logger.info("Will get details of inventory details");
        dtoList = dao.getInventoryDetails();
        if(dtoList==null){
            return null;
        }
        return dtoList;

    }

    public List<InventoryDTO> createInventoryDetails(String itemName,double costprice,double sellprice) {

        //logger.trace("getting details to create");
        dtoList = dao.createInventoryDetails(itemName, costprice,sellprice);
        if(dtoList==null){
            return null;
        }
        return dtoList;

    }
    public List<InventoryDTO> updateBuy(String itemName, int quantity) {
        //logger.debug("Updating details of inventory management");
        // logger.debug("Update Buy method which updates inventory details");
        dao.updateBuy(itemName,quantity);
        dtoList = dao.updateBuy(itemName,quantity);
        return dtoList;
    }
    public List<InventoryDTO> updateSell(String itemName,int quantity) {
        //logger.debug("UpdateSell in table");
        InventoryDAOImpl dao = new InventoryDAOImpl();
        //logger.debug("calling dao and we are getting itemName details");
        dao.updateSell(itemName,quantity);

        dtoList= dao.updateSell(itemName,quantity);
        return dtoList;
    }

    public List<InventoryDTO> deleteInventoryDetails(String itemName) {
       // logger.debug("Delete method in inevntory details");
        InventoryDAOImpl dao = new InventoryDAOImpl();
        dao.deleteInventoryDetails(itemName);
        List<InventoryDTO> dtoList=new ArrayList<InventoryDTO>();
        dtoList = deleteInventoryDetails(itemName);
        return dtoList;
    }

}
