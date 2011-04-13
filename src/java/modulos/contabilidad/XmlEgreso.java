package modulos.contabilidad;

import clases.XML;
import java.util.ArrayList;

/**
 *
 * @author Mario Cares
 */
public class XmlEgreso extends XML {
    
    public XmlEgreso(String raiz){
        this.raiz = raiz;
    }

    public String makeEgreso(ArrayList<String> valores){
        return this.Egreso(valores);
    }

    private String Egreso(ArrayList<String> valores){
        this.cuerpo = "<valor monto=\""+valores.get(0)+"\" />";
        this.cuerpo += "<fecha dato=\""+valores.get(1)+"\" />";
        this.cuerpo += "<proveedor rut=\""+valores.get(2)+"\" nombre=\""+valores.get(3)+"\"/>";
        this.cuerpo += "<glosa>"+valores.get(4)+"</glosa>";
        String [] temp = valores.get(5).split("@");
        this.cuerpo += "<cuentas>";
        for (String algo : temp){
            String [] temp1 = algo.split("#");
            this.cuerpo += "<cuenta id=\""+temp1[0]+"\" monto=\""+temp1[1]+"\" />";
        }
        this.cuerpo += "</cuentas>";
//        this.respuesta = "<Valores_Egreso>"+this.cuerpo+"</Valores_Egreso>";
        this.respuesta = "<"+this.raiz+">"+this.cuerpo+"</"+this.raiz+">";
        return this.respuestaXML + this.respuesta;
    }
}
