package clases.bd;

import java.sql.*;
import clases.Pgsql;

/**
 *
 * @author Mario Cares
 */
public class egreso extends Pgsql{

    public String getValor(Integer egreso){
        return this.Valor(egreso);
    }
    private String Valor(Integer egreso){
        String cadena = "SELECT egresos.egr_valor "
                + "FROM public.egresos "
                + "WHERE egresos.egr_pk_egreso = "+egreso+";";
        if (this.conexion()) {
            try{
                Statement query = this.conexion.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = query.executeQuery(cadena);
                if (rs.next())
                    cadena = rs.getString(1);
                else
                    cadena = "N";
                rs.close(); this.conexion.close();
            }catch (SQLException ex){
                cadena = "SQLException en egreso.Valor -> "+ex.toString();
            }
        }else
            cadena = "Error al conectar a BD -> "+this.Error;
        return cadena;
    }

    public String getFecha(Integer egreso){
        return this.Fecha(egreso);
    }
    private String Fecha(Integer egreso){
        String cadena = "SELECT egresos.egr_fecha "
                + "FROM public.egresos "
                + "WHERE egresos.egr_pk_egreso = "+egreso+";";
        if (this.conexion()) {
            try{
                Statement query = this.conexion.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = query.executeQuery(cadena);
                if (rs.next())
                    cadena = rs.getString(1);
                else
                    cadena = "N";
                rs.close(); this.conexion.close();
            }catch (SQLException ex){
                cadena = "SQLException en egreso.Valor -> "+ex.toString();
            }
        }else
            cadena = "Error al conectar a BD -> "+this.Error;
        return cadena;
    }

    public String getGlosa(Integer egreso){
        return this.Glosa(egreso);
    }
    private String Glosa(Integer egreso){
        String cadena = "SELECT egresos.egr_glosa "
                + "FROM public.egresos "
                + "WHERE egresos.egr_pk_egreso = "+egreso+";";
        if (this.conexion()) {
            try{
                Statement query = this.conexion.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = query.executeQuery(cadena);
                if (rs.next())
                    cadena = rs.getString(1);
                else
                    cadena = "N";
                rs.close(); this.conexion.close();
            }catch (SQLException ex){
                cadena = "SQLException en egreso.Valor -> "+ex.toString();
            }
        }else
            cadena = "Error al conectar a BD -> "+this.Error;
        return cadena;
    }

    public String getProveedorRUT(Integer egreso){
        return this.ProveedorRUT(egreso);
    }
    private String ProveedorRUT(Integer egreso){
        String cadena = "SELECT proveedores.pro_pk_rut FROM public.egreso_proveedor, public.proveedores"
                + " WHERE egreso_proveedor.\"EP_fk_proveedor\" = proveedores.pro_pk_rut AND egreso_proveedor.\"EP_fk_egreso\" = "+egreso+";";
        if (this.conexion()) {
            try{
                Statement query = this.conexion.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = query.executeQuery(cadena);
                if (rs.next())
                    cadena = rs.getString(1);
                else
                    cadena = "N";
                rs.close(); this.conexion.close();
            }catch (SQLException ex){
                cadena = "SQLException en egreso.Valor -> "+ex.toString();
            }
        }else
            cadena = "Error al conectar a BD -> "+this.Error;
        return cadena;
    }

    public String getProveedorNom(Integer egreso){
        return this.ProveedorNom(egreso);
    }
    private String ProveedorNom(Integer egreso){
        String cadena = "SELECT proveedores.pro_nombre FROM public.egreso_proveedor, public.proveedores"
                + " WHERE egreso_proveedor.\"EP_fk_proveedor\" = proveedores.pro_pk_rut AND egreso_proveedor.\"EP_fk_egreso\" = "+egreso+";";
        if (this.conexion()) {
            try{
                Statement query = this.conexion.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = query.executeQuery(cadena);
                if (rs.next())
                    cadena = rs.getString(1);
                else
                    cadena = "N";
                rs.close(); this.conexion.close();
            }catch (SQLException ex){
                cadena = "SQLException en egreso.Valor -> "+ex.toString();
            }
        }else
            cadena = "Error al conectar a BD -> "+this.Error;
        return cadena;
    }

    public String getCuentas(Integer egreso){
        return CuentasId(egreso);
    }
    private String CuentasId(Integer egreso){
        String cadena = "SELECT movimiento_cuentas.\"MC_fk_cuenta\", movimiento_cuentas.\"MC_monto\" "
                + "FROM public.movimiento_cuentas WHERE movimiento_cuentas.\"MC_fk_egreso\" = "+egreso+";";
        if (this.conexion()) {
            try{
                Statement query = this.conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = query.executeQuery(cadena);
                rs.afterLast(); boolean seguir = rs.previous();
                cadena = "";
                while(seguir){
                    cadena += rs.getString(1)+"#"+rs.getString(2)+"@";
                    seguir = rs.previous();
                }
                rs.close(); this.conexion.close();
            }catch(SQLException ex){
                cadena = "SQLException en egreso.Cuentas -> "+ex.toString();
            }
        }
        return cadena;
    }

    public String setEgreso(){
        return "";
    }
}
