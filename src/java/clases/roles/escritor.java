package clases.roles;
import clases.bd.egreso;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mario Cares
 */
public class escritor{

    public String setEgreso(HttpServletRequest request){
        return this.Guardar(request);
        String datos = "A escribir <br />"
                    + "Numero Comprobante: "+request.getParameter("comprobante")+"<br />"
                    + "Valor Egreso: "+request.getParameter("valor")
                    + "<br />Fecha Egreso: "+request.getParameter("fecha")
                    + "<br />Proveedor: "+request.getParameter("proveedor")
                    + "<br />Cuentas: "+request.getParameter("JSON");
        return datos;
    }

    private String Guardar(HttpServletRequest request){
        egreso e = new egreso();

        return "";
    }
}
