/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbdenrira;
import java.util.*;
/**
 *
 * @author enriq
 */
public class Alumnos {
    private String nombre;
    private int edad;
    private int tasa_matricula;

    public Alumnos(String nombre, int edad, int tasa_matricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.tasa_matricula = tasa_matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTasa_matricula() {
        return tasa_matricula;
    }

    public void setTasa_matricula(int tasa_matricula) {
        this.tasa_matricula = tasa_matricula;
    }

    @Override
    public String toString() {
        return "Alumnos{" + "nombre=" + nombre + ", edad=" + edad + ", tasa_matricula=" + tasa_matricula + '}';
    }
    
}
