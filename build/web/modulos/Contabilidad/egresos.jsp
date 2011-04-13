<%-- 
    Document   : egresos
    Created on : 20-mar-2011, 20:50:30
    Author     : Mario Cares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movimientos Contables -> Egresos</title>
        <script type="text/javascript" src="../js/libreria.js"></script>
        <script type="text/javascript" src="../js/jquery-1.5.2.min.js"></script>
        <script type="text/javascript" src="js/funciones.js"></script>
        <link type="text/css" rel="stylesheet" href="../css/stilos.css" />
    </head>
    <body>
        <h1>Mantención Movimientos Contables - Egresos</h1>
        <form id="EnvioEgreso" name="EnvioEgreso" method="post" action="Egresos">
            <table width="675" border="0">
              <tr>
                <td colspan="3" bgcolor="#CCCCCC">Nº Comprobante <br /><input name="comprobante" type="text" id="comprobante"
                                                                              value="Nº Comprobante" size="18" />
                    <b id="nuevo_egreso"></b></td>
                <td width="126" bgcolor="#CCCCCC">Valor Egreso <br /><input name="valor" type="text" id="valor" value="Valor" size="10" /></td>
                <td width="290" bgcolor="#CCCCCC">Fecha Movimiento <br /><input name="fecha" type="text" id="fecha" value="Fecha" size="10" /></td>
              </tr>
              <tr>
                <td colspan="5" bgcolor="#CCCCCC">Proveedor <br /><input name="proveedor" type="text" id="proveedor" value="Proveedor" size="12" />
                  <input type="button" name="busca_proveedor" id="busca_proveedor" class="buscar" value=""/>
                <b id="proveedor_nom"></b> || <b id="estado_egreso">Estado Egreso</b></td>
              </tr>
              <tr>
                <td colspan="5" bgcolor="#CCCCCC"><label for="glosa">Glosa Comprobante</label><br />
                  <textarea name="glosa" id="glosa" cols="80" rows="5"></textarea></td>
              </tr>
              <tr>
                <td colspan="2" bgcolor="#CCCCCC"><input name="cuenta" type="text" id="cuenta" value="Cuenta Contable" size="18" /></td>
                <td width="62" bgcolor="#CCCCCC"><input name="debe" type="text" id="debe" value="Debe" size="10" /></td>
                <td colspan="2" bgcolor="#CCCCCC"><input name="haber" type="text" id="haber" value="Haber" size="10" /></td>
              </tr>
              <tr>
                <td colspan="5" bgcolor="#CCCCCC">
                    <div id="Div_cuentas_egresos" class="tabla"><table id="cuentas_egresos" border="1" ><thead>
                                 <tr><th>Cuenta</th><th>Debe</th><th>Haber</th></tr></thead></table></div>
                </td>
              </tr>
              <tr>
                <input type="hidden" name="JSON" id="CTA" />
                <td width="83" bgcolor="#CCCCCC"><input type="submit" name="contabilizar" id="contabilizar" value="Contabilizar" /></td>
                <td width="92" bgcolor="#CCCCCC"><input type="submit" name="desactualizar" id="desactualizar" value="Desactualizar" /></td>
                <td bgcolor="#CCCCCC"><input type="submit" name="agregar" id="agregar" value="Agregar" /></td>
                <td colspan="2" bgcolor="#CCCCCC"><input type="submit" name="eliminar" id="eliminar" value="Eliminar" /></td>
              </tr>
            </table>
        </form>
    </body>
</html>
