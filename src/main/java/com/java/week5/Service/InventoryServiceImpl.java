package com.java.week5.Service;

import com.java.week5.Dao.InventoryDAO;
import com.java.week5.Dao.InventoryDAOImpl;
import com.java.week5.Dto.InventoryDTO;
import com.java.week5.Log4j.Log4j;
import org.apache.log4j.Logger;

import java.util.List;

public class InventoryServiceImpl implements InventoryService {

    InventoryDAO dao;
    final static Logger logger = Logger.getLogger(Log4j.class);

    public List<InventoryDTO> getInventoryDetails() {
        logger.debug("inside InventoryDetail method and as parameter");
        InventoryDAOImpl daoImpl = new InventoryDAOImpl();
        logger.debug("Will get details of inventory details");
        List<InventoryDTO> dto= null;
        dto = dao.getInventoryDetails();
        return dto;

    }

    public List<InventoryDTO> create(String itemName,double costprice,double sellprice) {
        InventoryDAOImpl dao = new InventoryDAOImpl();
        logger.debug("getting details to create");
        dao.create(itemName, costprice,sellprice);
        List<InventoryDTO> dto= null;
        dto = dao.create(itemName, costprice,sellprice);
        return dto;
    }
    public List<InventoryDTO> updateBuy(String itemName,int quantity) {
        logger.debug("Updating details of inventory management");
        InventoryDAOImpl dao = new InventoryDAOImpl();
        logger.debug("Update Buy method which updates inventory details");
        dao.updateBuy(itemName,quantity);
        List<InventoryDTO> dto= null;
        dto = dao.updateBuy(itemName,quantity);
        return dto;
    }
    public List<InventoryDTO> updateSell(String itemName,int quantity) throws Exception {
        logger.debug("UpdateSell in table");
        InventoryDAOImpl dao = new InventoryDAOImpl();
        logger.debug("calling dao and we are getting itemName details");
        dao.updateBuy(itemName,quantity);
        List<InventoryDTO> dto1= null;
        dao.updateSell(itemName,quantity);
        return dto1;
    }

    public List<InventoryDTO> deleteInventoryDetails(String itemName) {
        logger.debug("Delete method in inevntory details");
        InventoryDAOImpl dao = new InventoryDAOImpl();
        dao.deleteInventoryDetails(itemName);
        List<InventoryDTO> dto1= null;
        dto1 = deleteInventoryDetails(itemName);
        return dto1;
    }

}
