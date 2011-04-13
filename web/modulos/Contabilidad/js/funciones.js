/*VARIABLES GLOBALES*/
var cuenta = new Array();
var debe = new Array();
var haber = new Array();
var tbl;
/*VARIABLES GLOBALES*/

function limpiar(){
    this.value="";
}

function getEgr(){
    oxml = ObjAJAX();
        oxml.open('GET', 'Egresos?accion=leer&fin=getEgreso&egr='+this.value, true);
    oxml.onreadystatechange = function(){
        if(oxml.readyState == 4){
            try{
                var xml = oxml.responseXML;
                var monto = xml.getElementsByTagName("valor").item(0).getAttribute("monto");
                var cant = xml.getElementsByTagName('cuenta').length;
                if (monto=="N"){
                    document.getElementById("nuevo_egreso").innerHTML="Nuevo Egreso";
                    document.getElementById("valor").value = "";
                    document.getElementById("fecha").value = "";
                    document.getElementById("proveedor").value = "";
                    document.getElementById("proveedor_nom").innerHTML = "";
                    document.getElementById("glosa").innerHTML = "";
                    document.getElementById('contabilizar').disabled=true;document.getElementById('agregar').disabled=false;
                    document.getElementById('eliminar').disabled=true;document.getElementById('desactualizar').disabled=true;
                    document.getElementById('valor').disabled=false;document.getElementById('fecha').disabled=false;
                    document.getElementById('proveedor').disabled=false;document.getElementById('glosa').disabled=false;
                    document.getElementById('cuenta').disabled=false;document.getElementById('debe').disabled=false;
                    document.getElementById('haber').disabled=false;document.getElementById('cuentas_egresos').innerHTML = "";
                    document.getElementById('cuentas_egresos').innerHTML = "<table id=\"cuentas_egresos\" border=\"1\" ><thead>"+
                                 "<tr><th>Cuenta</th><th>Debe</th><th>Haber</th></tr></thead></table>";
                }else{
                    document.getElementById("nuevo_egreso").innerHTML="";
                    document.getElementById("valor").value = monto;document.getElementById("valor").disabled=true;
                    document.getElementById("fecha").value = xml.getElementsByTagName("fecha").item(0).getAttribute("dato");document.getElementById("fecha").disabled=true;
                    document.getElementById("proveedor").value = xml.getElementsByTagName("proveedor").item(0).getAttribute("rut");document.getElementById("proveedor").disabled=true;
                    document.getElementById("proveedor_nom").innerHTML = xml.getElementsByTagName("proveedor").item(0).getAttribute("nombre");document.getElementById("proveedor_nom").disabled=true;
                    document.getElementById("glosa").innerHTML = xml.getElementsByTagName("glosa")[0].firstChild.data;document.getElementById("glosa").disabled=true;
                    var respuesta ="<table id=\"cuentas\" class=\"tablesorter\" border=\"1\" >\n\
                        <thead><tr><th>Cuenta Contable</th><th>Debe</th><th>Haber</th></thead><tbody></tbody>";
                    var semiResp;
                    for (i = 0; i < cant; i++) {
                        var resp = "<tr>";
                        resp += "<td>"+ xml.getElementsByTagName("cuenta").item(i).getAttribute("id") + "</td>";
                        var montoCuenta = xml.getElementsByTagName("cuenta").item(i).getAttribute("monto");
                        if (montoCuenta<0){
                            montoCuenta = montoCuenta*-1;
                            resp += "<td>"+montoCuenta+"</td>"
                            resp += "<td> - </td></tr>";
                        }else{
                            resp += "<td> - </td>";
                            resp += "<td>"+montoCuenta+"</td></tr>";
                        }
                        if (i==0)
                            semiResp = resp;
                        else
                            semiResp = semiResp + resp;
                    }
                    document.getElementById('cuentas_egresos').innerHTML = respuesta + semiResp + "</tboby></table>";
                    document.getElementById('contabilizar').disabled=true;document.getElementById('agregar').disabled=true;document.getElementById('eliminar').disabled=true;
                    document.getElementById('cuenta').disabled=true;document.getElementById('debe').disabled=true;document.getElementById('haber').disabled=true;
                }
            }catch(e){
                alert(e.name+" - "+e.toString());
            }
        }
    }
    oxml.send(null);
}

function addMovimiento(){
    cuenta.push(document.getElementById("cuenta").value);
    debe.push(document.getElementById("debe").value);
    haber.push(document.getElementById("haber").value);
    try{
        var x=document.getElementById('cuentas_egresos').insertRow(1);
        var u=x.insertCell(0);
        var y=x.insertCell(1);
        var z=x.insertCell(2);
        u.innerHTML=document.getElementById("cuenta").value;
        y.innerHTML=document.getElementById("debe").value;
        z.innerHTML=document.getElementById("haber").value;
        document.getElementById("cuenta").focus();
    }catch(e){
        alert(e.name+" - "+e.toString())
    }
}

function lista(){
    genCTA(cuenta,debe,haber);
}

function genCTA(c, d, h){
    var CTA = "";
    try{
        for (i = 0; i < c.length; i++) {
            CTA += c[i]+'@'+d[i]+'@'+h[i]+'#';
    }}catch(e){e.toString()}
    CTA = CTA.substring(0, CTA.length-1);
    try{document.getElementById("CTA").value=CTA;}catch(e){alert(e.toString());}
}

function validar(){
    if (!isNaN(document.getElementById('valor').value) && document.getElementById('valor').value>0){
        if (document.getElementById('fecha').value.length == 8){
            fecha = document.getElementById('fecha');
            fecha.value = fecha.value.substring(0,2)+"/"+fecha.value.substring(2,4)+"/"+fecha.value.substring(4,8);
        }else{document.getElementById('fecha').value="";document.getElementById('fecha').focus();}
    }else{document.getElementById('valor').value="";document.getElementById('valor').focus();}
}
window.onload = function() {
	document.getElementById ('comprobante').addEventListener("click", limpiar, false);
        document.getElementById ('comprobante').addEventListener("blur", getEgr, false);
        document.getElementById ('valor').addEventListener("focus", limpiar, false);
        document.getElementById ('fecha').addEventListener("focus", limpiar, false);
        document.getElementById ('proveedor').addEventListener("focus", limpiar, false);
        document.getElementById ('cuenta').addEventListener("focus", limpiar, false);
        document.getElementById ('debe').addEventListener("focus", limpiar, false);
        document.getElementById ('haber').addEventListener("focus", limpiar, false);
        document.getElementById ('haber').addEventListener("blur", addMovimiento, false);
        document.getElementById ('agregar').addEventListener("click", lista, false);
        document.getElementById ('glosa').addEventListener("blur", validar, false);
}