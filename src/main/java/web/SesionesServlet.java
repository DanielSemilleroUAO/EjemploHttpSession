/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author adseglocdom
 */
@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = req.getSession();
        String titulo = null;

        // Pedir el atributo contador visitas
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");

        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }

        sesion.setAttribute("contadorVisitas", contadorVisitas);

        PrintWriter out = resp.getWriter();

        out.print("<h1>" + titulo + "</h1>");
        out.print("<br />");

        out.print("no. accesos al recurso: " + contadorVisitas);
        out.print("<br />");
        out.print("Id de la sesion: " + sesion.getId());
        out.close();
    }

}
