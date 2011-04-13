package modulos.contabilidad;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clases.roles.*;

/**
 *
 * @author Mario Cares
 */
public class Egresos extends HttpServlet {

    private HttpServletResponse respuesta;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        this.respuesta = response;
        PrintWriter out = this.respuesta.getWriter();
        if(request.getParameter("agregar")!=null){
            setCabecera("HTML");
            escritor e = new escritor();
            out.write(e.setEgreso(request));
        }else if (request.getParameter("accion").equals("leer")) {
            setCabecera("XML");
            lector l = new lector();
            if (request.getParameter("fin").equals("getEgreso")) {
                out.write(l.getEgreso(Integer.parseInt(request.getParameter("egr"))));
            }
        }else{

        }
    }

    private void setCabecera(String tipo){
        if (tipo.equals("XML")) {
            this.respuesta.setHeader("Content-Type", "text/xml");
            this.respuesta.setHeader("Cache-Control", "must-revalidate");
            this.respuesta.setHeader("Cache-Control", "no-cache");
        }else if (tipo.equals("HTML")){
            this.respuesta.setHeader("Content-Type", "text/html");
        }else if (tipo.equals("JSON")){
            this.respuesta.setContentType("application/json");
            this.respuesta.setCharacterEncoding("UTF-8");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
