package com.java.week5.Client;

import com.java.week5.Dao.InventoryDAOImpl;
import com.java.week5.Dto.InventoryDTO;
import com.java.week5.Service.InventoryServiceImpl;

import java.lang.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

//Client class
public class Client {
    List<InventoryDTO> dtoList;
//Scanner Implementation

    double details=0;
    double value=0;
    double profit = 0;

    public void scan() {

        Scanner scan;
        scan = new Scanner(System.in);
        System.out.println("choose from the following/n 1.delete 2.updateBuy 3.UpdateSell 4.create 5.report");
        String type = scan.next();

        InventoryDAOImpl daoImpl =new InventoryDAOImpl();

//Switch case Implementation
        switch(type) {

            case "create" :
                System.out.println("item Name");
                String itemName= scan.next();
                System.out.println("enter Costprice");
                double costprice = scan.nextDouble();
                System.out.println("enter Sellingprice");

                double sellprice = scan.nextDouble();
                System.out.println(dtoList = daoImpl.create(itemName,costprice,sellprice));
                break;
            case "delete" :
                System.out.println("item Name");
                itemName= scan.next();
                System.out.println("deleted " + itemName);
                System.out.println(dtoList=daoImpl.deleteInventoryDetails(itemName));
                break;
            case "updateBuy" :
                System.out.println("item Name");
                itemName= scan.next();
                System.out.println("enter quantity");
                int quantity = scan.nextInt();

                System.out.println(dtoList = daoImpl.updateBuy(itemName,quantity));
                break;
            case "updateSell" :
                System.out.println("item Name");
                itemName= scan.next();
                System.out.println("enter quantity");
                quantity = scan.nextInt();
                System.out.println("You passed");
                break;

            case "report" :
                System.out.println("display details in db as report");
                //System.out.println(dtoList = daoImpl.getInventoryDetails());
                dtoList = daoImpl.getInventoryDetails();
                double details=0;
                double value=0;
                double profit = 0;

                System.out.println("           " + "INVENTORY REPORT" + "          ");
                System.out.println("Item Name" + "    " + "Bought At" + "    " + "Sold At" + "   " + "AvailableQty" + "  " + "Value");
                System.out.println("---------" + "    " + "---------" + "    " + "-------" + "   " + "------------" + "  " + "-----");

                System.out.println("-----------------------------------------------------------------------------------------------------");
                for(InventoryDTO dto:dtoList){
                    details = details + (dto.getCostPrice()*dto.getQuantity());
                    value = value + (dto.getSellPrice()*dto.getQuantity());
                    System.out.println(dto.getItemName() + "        " + dto.getCostPrice() + "         " + dto.getSellPrice() + "          " + dto.getQuantity() + "          " + ((dto.getCostPrice()) * (dto.getQuantity())));
//System.out.println("Profit is                    " + daoImpl.getProfit());
                    profit = (dto.getSellPrice()-dto.getCostPrice())*dto.getQuantity();
                    System.out.println("profit for this item is " + profit);
                }
                break;
            default :
                System.out.println("operation failed");
        }
        //System.out.println("Profit is                    " + profit);
        System.out.println("Your operation is " + type);

    }

    //Main Method
    public static void main(String args[]){
        Client client = new Client();
        client.scan();
        InventoryServiceImpl Service = new InventoryServiceImpl();
        List<InventoryDTO> dtoList = new ArrayList<>();

//        System.out.println("           " + "INVENTORY REPORT" + "          ");
//        System.out.println("Item Name" + "    " + "Bought At" + "    " + "Sold At" + "   " + "AvailableQty" + "  " + "Value");
//        System.out.println("---------" + "    " + "---------" + "    " + "-------" + "   " + "------------" + "  " + "-----");
//
//        System.out.println("-----------------------------------------------------------------------------------------------------");
////        System.out.println(Service.getInventoryDetails() + dtoList.toString());
//
 }
}
