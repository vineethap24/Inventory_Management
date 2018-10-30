
import com.java.week5.Dao.InventoryDAOImpl;
import com.java.week5.Dto.InventoryDTO;
import com.java.week5.Log4j.*;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
//import org.apache.Log4j.xml.Log4j;

public class InventoryTest {

    //private int id;
    private String itemName;
    private double costprice;
    private double sellprice;
    private int quantity;

    final static Logger logger = Logger.getLogger(Log4j.class);

    InventoryDAOImpl daoImpl;
    InventoryDTO dtoList;

    public static void beforeClass()
    {
        System.out.println("Before class");
    }
    @AfterClass
    public static void afterClass()
    {
        System.out.println("After class");
    }
    @Before

    public void setUp()
    {
        System.out.println("Inside @Before");
        //int ID;
        itemName = "BOOK01";
//        Double costprice;
//        Double sellprice;
//        int quantity;
        costprice = 10.50;
        sellprice = 13.00;
        quantity = 100;
    }

    @Test
    public void DaoTest()  {
        System.out.println("Inside addresstest");
         List<InventoryDTO> dto1;
        InventoryDAOImpl test =new InventoryDAOImpl();
       dto1 = test.getInventoryDetails();
        System.out.println(dto1);

        assertEquals("Book01", dto1.get(0).getItemName());
        assertEquals(10.50, dto1.get(0).getCostPrice(), 0);
        assertEquals(13, dto1.get(0).getSellPrice(), 0);
        assertEquals(100, dto1.get(0).getQuantity());



    }
    @Test
    public void nulltest()
    {
        System.out.println("Inside nulltest");

        InventoryDAOImpl test = new InventoryDAOImpl();
        List<InventoryDTO> dtoList = null;
        dtoList = test.getInventoryDetails();
        assertNull(dtoList.get(0));

    }



}
