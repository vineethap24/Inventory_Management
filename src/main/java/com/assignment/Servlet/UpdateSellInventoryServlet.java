package com.assignment.Servlet;


import com.assignment.dto.InventoryDTO;
import com.assignment.service.InventoryServiceImpl;
import org.apache.commons.collections4.CollectionUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UpdateSell", urlPatterns = "/updatesell")
public class UpdateSellInventoryServlet extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet initilized");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemName = request.getParameter("itemName");
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));

        PrintWriter out = response.getWriter();

        InventoryServiceImpl service = new InventoryServiceImpl();
        try {
            List<InventoryDTO> dtoList = service.updateSell(itemName, quantity);
            if (CollectionUtils.isNotEmpty(dtoList)) {
                out.write("update Successfull");
            }
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }
}