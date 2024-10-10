package com.servletproject;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet {
    private static int visitorCount = 0;
    // Method to process both GET and POST requests
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        visitorCount++;
        // Set the content type of the response
        response.setContentType("text/html;charset=UTF-8");

        // Get the PrintWriter to write response
        PrintWriter out = response.getWriter();
        
        // Writing HTML output
        out.println("<html>");
        out.println("<head>"); 
        out.println("<style>");
        out.println("@keyframes blink { 50% { opacity: 0; } }");
        out.println(".blink { animation: blink 1s step-start infinite; color: red; font-family: monospace; }");
        out.println(".user { color: blue; font-weight: 300; font-size: 20px; font-family: Arial; }");
        out.println(".address { color: green; font-weight: 500; font-size: 12px; font-family: Helvetica; }");
        out.println(".languages { color: DeepPink; font-weight: 800; font-size: 18px; font-family: sans-serif; }");
        out.println(".citizenship { color: purple; font-weight: bold; font-size: 14px; font-family: Verdana; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello all from servlet</h1>");
        out.println("<h1 class='blink'>You are visitor number: " + visitorCount + "</h1>");
        out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");

        String user = request.getParameter("user");
        String address = request.getParameter("address");
        String languages = request.getParameter("languages");
        String citizenship = request.getParameter("citizenship");
        out.println("<h2 class='user'>Name : " + user + "</h2>");
        out.println("<h2 class='address'>Address :  " + address + "</h2>");
        out.println("<h2 class='languages'>Languages known : " + languages + "</h2>");
        out.println("<h2 class='citizenship'>Citizenship : " + citizenship + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }

    // Override the doGet method
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    // Override the doPost method
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }
}
