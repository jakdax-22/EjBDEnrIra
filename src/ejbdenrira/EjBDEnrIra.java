/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejbdenrira;

import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author enriq
 */
public class EjBDEnrIra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        //Apartado a
        Scanner teclado = new Scanner (System.in);
        Datos_Alumnos administra = new Datos_Alumnos ();
        //administra.crearTablas();
        Alumnos enrique = new Alumnos ("Enrique",21,745);
        Alumnos fernando = new Alumnos ("Fernando",18,0);
        Alumnos edgar = new Alumnos ("Edgar",18,645);
        Alumnos angel = new Alumnos ("Angel",22,456);
        Alumnos cre = new Alumnos ("Cre",16,999);
        Alumnos abuelo = new Alumnos ("Abuelo",86,222);
        
        /*administra.grabarDatos(enrique);
        administra.grabarDatos(fernando);
        administra.grabarDatos(edgar);
        administra.grabarDatos(angel);
        administra.grabarDatos(cre);
        administra.grabarDatos (abuelo);*/
        //Apartado b
        administra.ConsultaEdad(21);
        //Apartado c
        administra.ModificarTasa(10);
        //Apartado d
        System.out.println("Dime la edad de la que vamos a partir para empezar a borrar");
        int edad = teclado.nextInt();
        teclado.nextLine ();
        administra.BorrarDatos(edad);
        //Apartado e
        administra.ListaAlumnos();
    }
    
}
