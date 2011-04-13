package clases;

import java.sql.*;

/**
 *
 * @author Mario Cares
 */
public class Pgsql {

    protected String Driver = "org.postgresql.Driver",
            Host = "jdbc:postgresql://localhost:5432/Sistema",
            UsernameBD = "AdminBD", Pass = "cu4tr04",
            Error;
    protected Connection conexion;

    public Pgsql() { }

    protected Boolean conexion(){
        try{
            Class.forName(this.Driver);
            this.conexion = DriverManager.getConnection(this.Host,
                    this.UsernameBD, this.Pass);
            return true;
        }catch(SQLException ex){
            this.Error = "SQL Exception en Pgsql.conexion: -> "+ex.toString();
            return false;
        }
        catch(Exception ex){
            this.Error = "Exception en Pgsql.conexion: -> "+ex.toString();
            return false;
        }
    }
    public Connection conectar(){
        this.conexion();
        return this.conexion;
    }
}