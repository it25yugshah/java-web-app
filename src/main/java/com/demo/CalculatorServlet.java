package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Web Calculator</title>");

        out.println("<style>");
        out.println("body { font-family: Arial; text-align: center; margin-top: 80px; }");
        out.println(".calculator { width: 350px; margin: auto; padding: 30px; ");
        out.println("background: white; box-shadow: 0 0 10px gray; border-radius: 10px; }");
        out.println("input, select, button { padding: 10px; margin: 8px; font-size: 16px; }");
        out.println("button { background: black; color: white; border: none; cursor: pointer; }");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='calculator'>");
        out.println("<h1>Web Calculator</h1>");

        out.println("<form method='post' action='calculator'>");

        out.println("<input type='number' step='any' name='num1' ");
        out.println("placeholder='First number' required>");

        out.println("<br>");

        out.println("<select name='operation'>");
        out.println("<option value='add'>+</option>");
        out.println("<option value='subtract'>-</option>");
        out.println("<option value='multiply'>*</option>");
        out.println("<option value='divide'>/</option>");
        out.println("</select>");

        out.println("<br>");

        out.println("<input type='number' step='any' name='num2' ");
        out.println("placeholder='Second number' required>");

        out.println("<br>");

        out.println("<button type='submit'>Calculate</button>");

        out.println("</form>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));

        String operation = request.getParameter("operation");

        double result;

        switch (operation) {

            case "add":
                result = num1 + num2;
                break;

            case "subtract":
                result = num1 - num2;
                break;

            case "multiply":
                result = num1 * num2;
                break;

            case "divide":

                if (num2 == 0) {
                    out.println("<h1>Cannot divide by zero!</h1>");
                    return;
                }

                result = num1 / num2;
                break;

            default:
                out.println("<h1>Invalid operation!</h1>");
                return;
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Calculator Result</title>");
        out.println("</head>");

        out.println("<body style='text-align:center; margin-top:100px;'>");

        out.println("<h1>Calculator Result</h1>");

        out.println("<h2>");
        out.println(num1 + " " + operation + " " + num2 + " = " + result);
        out.println("</h2>");

        out.println("<a href='calculator'>Back to Calculator</a>");

        out.println("</body>");
        out.println("</html>");
    }
}