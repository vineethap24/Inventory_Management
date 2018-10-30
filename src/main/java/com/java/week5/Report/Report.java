package com.java.week5.Report;

import com.java.week5.Dao.*;
import com.java.week5.Dto.*;
import com.java.week5.Service.InventoryService;
import com.java.week5.Service.InventoryServiceImpl;

import java.util.ArrayList;
import java.util.List;

//Report Implementation
public class Report {

    InventoryServiceImpl Service = new InventoryServiceImpl();
    List<InventoryDTO> dtoList = new ArrayList<>();

    public void reporttest(){



        System.out.println("           " + "INVENTORY REPORT" + "          ");
        System.out.println("Item Name" + "    " + "Bought At" + "    " + "Sold At" + "   " + "AvailableQty" + "  " + "Value");
        System.out.println("---------" + "    " + "---------" + "    " + "-------" + "   " + "------------" + "  " + "-----");

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println(Service.getInventoryDetails() + dtoList.toString());

    }

}
