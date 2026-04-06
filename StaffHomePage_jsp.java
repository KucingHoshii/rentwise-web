package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class StaffHomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>RentWise | Staff Home</title>\n");
      out.write("    <style>\n");
      out.write("        :root {\n");
      out.write("            --primary-color: #ff6a00;\n");
      out.write("            --background-color: #EEF7FF;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        html {\n");
      out.write("            background-color: var(--background-color);\n");
      out.write("            font-family: 'Poppins', sans-serif;\n");
      out.write("            font-weight: 500;\n");
      out.write("            scroll-behavior: smooth;\n");
      out.write("            overflow-x: hidden;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /*Top Navigation*/\n");
      out.write("        nav {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-between;\n");
      out.write("            align-items: center;\n");
      out.write("            padding: 5px 20px;\n");
      out.write("            background-color: #fff; /* Updated */\n");
      out.write("            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Added */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .nav-logo {\n");
      out.write("            width: 70px;\n");
      out.write("            height: 70px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .nav-bar {\n");
      out.write("            display: flex;\n");
      out.write("            list-style: none;\n");
      out.write("            gap: 2.3em;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            z-index: 10;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .nav-bar li a {\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-size: 19px;\n");
      out.write("            color: black;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .nav-bar li a:hover {\n");
      out.write("            color: var(--primary-color);\n");
      out.write("            transition: all ease 0.3s;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Content */\n");
      out.write("        .container {\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column; /* Updated */\n");
      out.write("            align-items: center; /* Updated */\n");
      out.write("            padding: 2em; /* Updated */\n");
      out.write("            gap: 2em; /* Updated */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .heading {\n");
      out.write("            font-size: 2.5em; /* Updated */\n");
      out.write("            text-align: center; /* Updated */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .content {\n");
      out.write("            text-align: center; /* Updated */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .content p {\n");
      out.write("            font-size: 1.2em; /* Updated */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .staff-actions {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center; /* Updated */\n");
      out.write("            gap: 1em; /* Updated */\n");
      out.write("            flex-wrap: wrap; /* Added */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .staff-action {\n");
      out.write("            background-color: #fff;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n");
      out.write("            text-align: center;\n");
      out.write("            transition: transform 0.3s ease; /* Added */\n");
      out.write("            width: 250px; /* Added */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .staff-action:hover {\n");
      out.write("            transform: translateY(-5px); /* Added */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .staff-action img {\n");
      out.write("            width: 100px;\n");
      out.write("            height: 100px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .staff-action h3 {\n");
      out.write("            font-size: 1.2em;\n");
      out.write("            margin-bottom: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .staff-actions a {\n");
      out.write("            display: inline-block;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            background-color: var(--primary-color);\n");
      out.write("            color: white;\n");
      out.write("            text-decoration: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            text-align: center;\n");
      out.write("            font-weight: 500;\n");
      out.write("            transition: background-color 0.3s ease; /* Added */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .staff-actions a:hover {\n");
      out.write("            background-color: #ff8c42; /* Adjusted */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /*Footer*/\n");
      out.write("        footer {\n");
      out.write("            width: 100%;\n");
      out.write("            background-color: #FF5F00;\n");
      out.write("            text-align: center;\n");
      out.write("            color: white; /* Updated */\n");
      out.write("            padding: 1em; /* Updated */\n");
      out.write("            position: fixed; /* Updated */\n");
      out.write("            bottom: 0; /* Updated */\n");
      out.write("            left: 0; /* Updated */\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <!-- Nav Bar -->\n");
      out.write("    <nav>\n");
      out.write("        <img class=\"nav-logo\" src=\"asset\\sedan.png\" alt=\"\">\n");
      out.write("        <ul class=\"nav-bar\">\n");
      out.write("            <li><a href=\"StaffHomePage.jsp\">Home</a></li> <!-- Updated -->\n");
      out.write("            <li><a href=\"#\">Orders</a></li> <!-- Updated -->\n");
      out.write("            <li><a href=\"#\">Customers</a></li> <!-- Updated -->\n");
      out.write("            <li><a href=\"#\">Inventory</a></li> <!-- Updated -->\n");
      out.write("            <li><a href=\"#\">Reports</a></li> <!-- Updated -->\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"nav-button\">\n");
      out.write("            <a href=\"signup.html\" class=\"button1\">Profile</a> <!-- Updated -->\n");
      out.write("            <a href=\"signin.html\" class=\"button\">Logout</a> <!-- Updated -->\n");
      out.write("        </div>        \n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <!-- Content -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <p class=\"heading\"><b>Welcome to Staff Portal</b></p> <!-- Updated -->\n");
      out.write("            <p>Manage orders, customers, inventory, and generate reports.</p> <!-- Updated -->\n");
      out.write("            <div class=\"staff-actions\"> <!-- Updated -->\n");
      out.write("                <div class=\"staff-action\">\n");
      out.write("                    <img src=\"asset/payment.jpg\" alt=\"Orders\">\n");
      out.write("                    <h3>Manage Payment</h3>\n");
      out.write("                    <a href=\"#\">Manage Payment</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"staff-action\">\n");
      out.write("                    <img src=\"asset/car.png\" alt=\"Customers\">\n");
      out.write("                    <h3>Manage Car</h3>\n");
      out.write("                    <a href=\"displaycar.jsp\">Manage Car</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"staff-action\">\n");
      out.write("                    <img src=\"asset/inventory.png\" alt=\"Inventory\">\n");
      out.write("                    <h3>Update Inventory</h3>\n");
      out.write("                    <a href=\"#\">Update Inventory</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"staff-action\">\n");
      out.write("                    <img src=\"asset/report.png\" alt=\"Reports\">\n");
      out.write("                    <h3>Generate Reports</h3>\n");
      out.write("                    <a href=\"#\">Generate Reports</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Footer -->\n");
      out.write("    <footer>\n");
      out.write("        <p>&copy; 2024 RentWise. All rights reserved.</p>\n");
      out.write("    </footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
