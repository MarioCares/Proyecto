package clases;

import java.util.ArrayList;

/**
 *
 * @author Mario Cares
 */
public class XML {

    protected String respuestaXML, respuesta, cuerpo, raiz;

    public XML(){
        this.respuestaXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
        this.respuesta = "";
    }

//    protected String makeEgreso(ArrayList<String> valores){
//        return this.Egreso(valores);
//    }
//    protected String Egreso(ArrayList<String> valores){
//        cuerpo = "<valor monto=\""+valores.get(0)+"\" />";
//        cuerpo += "<fecha dato=\""+valores.get(1)+"\" />";
//        cuerpo += "<proveedor rut=\""+valores.get(2)+"\" nombre=\""+valores.get(3)+"\"/>";
//        cuerpo += "<glosa>"+valores.get(4)+"</glosa>";
//        String [] temp = valores.get(5).split("@");
//        cuerpo += "<cuentas>";
//        for (String algo : temp){
//            String [] temp1 = algo.split("#");
//            cuerpo += "<cuenta id=\""+temp1[0]+"\" monto=\""+temp1[1]+"\" />";
//        }
//        cuerpo += "</cuentas>";
//        this.respuesta = "<Valores_Egreso>"+cuerpo+"</Valores_Egreso>";
//        return this.respuestaXML + this.respuesta;
//    }

}
