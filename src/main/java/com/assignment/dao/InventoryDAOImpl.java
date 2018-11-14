package com.assignment.dao;

import com.assignment.dto.InventoryDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAOImpl implements InventoryDAO {

    static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/inventorydetails?allowPublicKeyRetrieval=true&useSSL=false";

    static final String USER = "root";
    static final String PASSWORD = "vineetha";

    Connection conn = null;
    Statement stmt = null;
    List<InventoryDTO> dtoList = new ArrayList<InventoryDTO>();
    private static double profit;

    public List<InventoryDTO> getInventoryDetails() {

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_Driver);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT itemname,sellprice,costprice,quantity FROM inventorydetails.inventorydetails";
            ResultSet rs = stmt.executeQuery(sql);


            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                Double costprice = rs.getDouble("costprice");
                Double sellprice = rs.getDouble("sellprice");
                int quantity = rs.getInt("quantity");
                String itemName = rs.getString("itemname");
                InventoryDTO dto = new InventoryDTO(itemName, costprice, sellprice, quantity);
                profit = (dto.getSellPrice() - dto.getCostPrice()) * dto.getQuantity();
                dtoList.add(dto);

                }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        //  System.out.println("Goodbye!");
        return dtoList;
    }//end main

    public List<InventoryDTO> createInventoryDetails(String itemName, double costprice, double sellprice) {

        try {


            //STEP 2: Register JDBC driver
            Class.forName(JDBC_Driver);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql;
            String getname;
            getname = "SELECT itemname FROM inventorydetails.inventorydetails WHERE itemName = '" + itemName + "';";
            ;
            ResultSet rs = stmt.executeQuery(getname);
            if (rs.isBeforeFirst()) {
                dtoList = null;
            } else {
                sql = "INSERT INTO inventorydetails.inventorydetails (Itemname,costprice,sellprice)\n" +
                        "VALUES ('" + itemName + "','" + costprice + "','" + sellprice + "')";
                System.out.println(sql);
                stmt.executeUpdate(sql);

                stmt.close();
                conn.close();
            }
        }catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        //System.out.println("Goodbye!");
        //return dtoList;

        return dtoList;
    }

    public List<InventoryDTO> deleteInventoryDetails(String itemName) {

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_Driver);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;

            String getname;
            getname = "SELECT itemname FROM inventorydetails.inventorydetails WHERE itemName = '" + itemName + "';";
            ;
            ResultSet rs = stmt.executeQuery(getname);
            if (!rs.isBeforeFirst()) {
                dtoList = null;
            } else {
                sql = "Delete from inventorydetails.inventorydetails \n" +
                        "WHERE itemName = '" + itemName + "';";

                System.out.println(sql);
                stmt.executeUpdate(sql);

                stmt.close();
                conn.close();
            }
        }catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return dtoList;
    }

    public List<InventoryDTO> updateBuy(String itemName, int quantity) {

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_Driver);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE inventorydetails.inventorydetails \n" +
                    "SET quantity = " + quantity + " WHERE itemName = '" + itemName + "';";

            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return null;
    }

    public List<InventoryDTO> updateSell(String itemName, int updatequantity) {
        double details = 0;
        double value = 0;
        double profit = 0;
        List<InventoryDTO> dtoList = new ArrayList<>();
        for (InventoryDTO dto : dtoList) {

//            if(dtoList.get(i).getItemName().equalsIgnoreCase(itemName)){
//                profit = ((dtoList.get(i).getSellPrice()-dtoList.get(i).getCostPrice())
//                        * quantity) + (getProfit());


            details = details + (dto.getCostPrice() * dto.getQuantity());
            value = value + (dto.getSellPrice() * dto.getQuantity());
            profit = (dto.getSellPrice() - dto.getCostPrice()) * dto.getQuantity();
            System.out.println(profit);
        }


        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_Driver);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql;
            sql = "UPDATE inventorydetails.inventorydetails \n" +
                    "SET quantity = quantity-'" + updatequantity + "' WHERE itemName = '" + itemName + "';";
            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return dtoList;
    }

    public static double getProfit() {
        List<InventoryDTO> dtoList = new ArrayList<>();

        return profit;
    }
}