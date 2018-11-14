package com.assignment.Servlet;

import com.assignment.dto.InventoryDTO;
import com.assignment.service.InventoryServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "ReportInventoryServlet", urlPatterns = "/report")

public class ReportInventoryServlet  extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet initialized");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String itemName = request.getParameter("itemName");
        PrintWriter out = response.getWriter();


        try {
            InventoryServiceImpl service = new InventoryServiceImpl();
            List<InventoryDTO> dtoList = service.getInventoryDetails();
            int counter = 0;
            //out.write("Inventory Management Report ");
            out.write("<html><body>");
            out.write("           " + "INVENTORY REPORT" + "          ");
            out.write("<br>Item Name    " + "    " + "Bought At   " + "    " + "Sold At  " + "   " + "AvailableQty  " + "  " + "Value  ");
            out.write("<br>------------" + "    " + "-------------" + "    " + "------------" + "   " + "---------------" + "  " + "---------");

            out.write("<br>----------------------------------------------------------------------------------------------------------");


            double details = 0;
            double value = 0;
            double profit = 0;
            double total_profit = 0;

            for (
                    InventoryDTO dto : dtoList) {
                details = details + (dto.getCostPrice() * dto.getQuantity());
                value = value + (dto.getSellPrice() * dto.getQuantity());
                out.write("<br>" + dto.getItemName() + "              " + dto.getCostPrice() + "            " + dto.getSellPrice() + "            " + dto.getQuantity() + "             " + ((dto.getCostPrice()) * (dto.getQuantity())));
                profit = (dto.getSellPrice() - dto.getCostPrice()) * dto.getQuantity();
                out.write("<br> profit for this item is " + profit);

            }
            if(!(service.getInventoryDetails().isEmpty())) {
                total_profit = profit + profit;

                out.write("<br> profit for this item is " + total_profit);
            }
            //out.write("<br>" + x + "        " + dto.getCostPrice() + "         " + dto.getSellPrice() + "          " + dto.getQuantity() + "          " + ((dto.getCostPrice()) * (dto.getQuantity())));)

        }
        catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }
}
