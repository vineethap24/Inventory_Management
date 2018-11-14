package com.assignment.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assignment.dto.InventoryDTO;
import com.assignment.service.InventoryService;
import com.assignment.service.InventoryServiceImpl;
import org.apache.commons.collections4.CollectionUtils;

@WebServlet(name = "CreateInventoryServlet", urlPatterns = "/create")

public class CreateInventoryServlet extends HttpServlet{

    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet initilized");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String itemName = request.getParameter("itemName");
        Double costprice = Double.valueOf(request.getParameter("costprice"));
        Double sellprice = Double.valueOf(request.getParameter("sellprice"));
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();

        try{

            InventoryService service = new InventoryServiceImpl();
            List<InventoryDTO> dtoList = service.createInventoryDetails(itemName,costprice,sellprice);
            int counter = 0;
            out.write("deatils of " + itemName + " are getting updated in DB ");
                if (CollectionUtils.isNotEmpty(dtoList)) {
                    out.write("Insert Successfull");
                }
                //System.out.println("Inserted data successfully");


        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }


    }
