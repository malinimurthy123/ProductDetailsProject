package com.example.ProductDetails;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String qry;
    Connection dbCon;
    Statement theStatement;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ProductID = request.getParameter("ProductID");
        try {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            boolean status = false;
            try {
                //  Define the URL to connect -test
                String urlToConnect = "jdbc:mysql://localhost:3306/test";
                //  Define the username for db to connect
                String dbUserName = "root";
                //   Define the password
                String dbUserPassword = "";
                //  Define the driver for the database
                String mySqlDriver = "com.mysql.cj.jdbc.Driver";
                //   Load the Driver
                Class.forName(mySqlDriver);
                //	Try to establish the connection
                dbCon = DriverManager.getConnection(urlToConnect, dbUserName, dbUserPassword);

                //  Get a reference to the Statement
                theStatement = dbCon.createStatement();
                System.out.println("Successfully connected to the database...");
                // Step 2:Create a statement using connection object

                PreparedStatement rst = dbCon.prepareStatement("select ProductID, ProductName, Size, Colour from product where ProductID = ?");
                rst.setString(1, ProductID);
                ResultSet rs = rst.executeQuery();

                out.println("<html><head>");
                out.println("<BR></BR>");
                out.println("<title>Product Results Page</title>");
                out.println("</head><body>");

                if (rs.next()) {
                    out.println("<table border='2' width='50%'>");
                    out.println("<BR></BR>");
                    out.println("<tr><H3>Product Details Dashboard</H3></tr>");
                    out.println("<BR></BR>");
                    out.println("<tr>");
                    out.println("<th>ProductID</th> <th>ProductName</th> <th>Size</th> <th>Colour</th> </tr>");

                    String ProductID1 = rs.getString(1);
                    String ProductName = rs.getString(2);
                    int Size = rs.getInt(3);
                    String Colour = rs.getString(4);

                    out.println("<tr style='text-align:center'>");
                    out.println("<td>" + ProductID1 +
                            "</td> <td>" + ProductName +
                            "</td> <td>" + Size +
                            "</td> <td>" + Colour +
                            "</td>");
                    out.println("</tr>");
                    out.println("</table>");

                } else {
                    response.getWriter().append("ID was not found, please try again.");
                    out.println("<br>");
                }

                out.println("<BR></BR>");
                out.println("<a href='index.jsp'>Go Back</a>");
                out.println("</body></html>");

                rst.close();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    dbCon.close();
                    System.out.println("Connection is closed.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


