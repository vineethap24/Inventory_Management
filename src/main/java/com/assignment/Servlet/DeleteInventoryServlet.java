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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DeleteInventoryServlet", urlPatterns = "/delete")

public class DeleteInventoryServlet extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet initilized");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemName = request.getParameter("itemName");

        PrintWriter out = response.getWriter();

        InventoryServiceImpl service = new InventoryServiceImpl();
        List<InventoryDTO> dtoList = new ArrayList<InventoryDTO>();
        try {
            dtoList = service.deleteInventoryDetails(itemName);

            if (CollectionUtils.isNotEmpty(dtoList)) {
                out.write("Delete Successfull");
            }
            out.write("Delete Successfull");

        }
        catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }

}