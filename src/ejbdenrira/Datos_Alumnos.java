/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbdenrira;


import java.sql.*;

/**
 *
 * @author enriq
 */
public class Datos_Alumnos {
    
    public Connection conectar () throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection(
            "jdbc:oracle:thin:@192.168.0.240:1521:xe", "daw8", "12345"
        );
        return conn;
    }
    public void crearTablas () throws SQLException {
        Connection conn = conectar ();
        Statement stm = conn.createStatement();
        if (stm.execute("CREATE TABLE DATOS (NOMBRE VARCHAR2(40) PRIMARY KEY, EDAD NUMBER (2), TASA_MATRICULA NUMBER (4))"))
            System.out.println("Tabla creada correctamente");
    }
    public void grabarDatos (Alumnos alumno) throws SQLException {
        Connection conn = conectar ();
        String nombre = alumno.getNombre();
        int edad = alumno.getEdad();
        int matricula = alumno.getTasa_matricula();
        String insert = "INSERT INTO DATOS VALUES ('"+nombre+"',"+edad+","+matricula+")";
        Statement stm = conn.createStatement();
        if ((stm.executeUpdate(insert)) == 1){
            System.out.println ("Inserción correcta");
        }
    }
    public void BorrarDatos (int edad) throws SQLException {
        Connection conn = conectar ();
        Statement stm = conn.createStatement();
        String delete = "DELETE DATOS WHERE EDAD > "+edad;
        int nfilas = stm.executeUpdate(delete);
        System.out.println (nfilas+" filas borradas");
    }
    public void ModificarDatos (String nombre, int tasa) throws SQLException {
        Connection conn = conectar ();
        Statement stm = conn.createStatement();
        String update = "UPDATE DATOS SET TASA_MATRICULA = "+tasa+" WHERE NOMBRE = "+nombre;
        if ((stm.executeUpdate(update)) == 1){
            System.out.println("Actualización realizada con éxito");
        }    
    }
    public void ModificarTasa (int porcentaje) throws SQLException {
        Connection conn = conectar ();
        Statement stm = conn.createStatement();
        String update = "UPDATE DATOS SET TASA_MATRICULA = TASA_MATRICULA +("+porcentaje+"* TASA_MATRICULA / 100) WHERE EDAD > 31 ";
        if ((stm.executeUpdate(update)) >= 1){
            System.out.println("Actualización realizada con éxito");
        }    
    }
    public void ListaAlumnos () throws SQLException {
        Connection conn = conectar ();
        Statement stm = conn.createStatement();
        String select = "SELECT * FROM DATOS";
        ResultSet rset=stm.executeQuery(select);
        while (rset.next()) {
            System.out.println(rset.getString(1)+" "+rset.getInt(2)+" "+rset.getInt(3));
        }
        stm.close();        
    }
    public void ConsultaEdad (int edad) throws SQLException {
        Connection conn = conectar ();
        Statement stm = conn.createStatement();
        ResultSet rset = stm.executeQuery("SELECT * FROM DATOS WHERE EDAD < "+edad);
        while (rset.next())
            System.out.println(rset.getString(1)+" "+rset.getInt(2)+" "+rset.getInt(3));
        stm.close();
    }
}
