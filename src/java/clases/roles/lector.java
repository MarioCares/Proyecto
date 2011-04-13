package clases.roles;

import clases.bd.egreso;
import modulos.contabilidad.XmlEgreso;
import java.util.ArrayList;

/**
 *
 * @author Mario Cares
 */
public class lector {

    private ArrayList<String> valores = new ArrayList<String>();
    private egreso e;
    private XmlEgreso xml;

    public String getEgreso(Integer egreso){
        return this.Egreso(egreso);
    }

    private String Egreso(Integer egreso){
        e = new egreso(); xml = new XmlEgreso("Valores_Egreso");
        String monto = e.getValor(egreso);
        if (monto.equals("N"))
            return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                    + "<Valores_Egreso><valor monto=\"N\" /></Valores_Egreso>";
        else{
            valores.add(monto);
            valores.add(e.getFecha(egreso));
            valores.add(e.getProveedorRUT(egreso));
            valores.add(e.getProveedorNom(egreso));
            valores.add(e.getGlosa(egreso));
            valores.add(e.getCuentas(egreso));
            return xml.makeEgreso(valores);
        }
    }
}
