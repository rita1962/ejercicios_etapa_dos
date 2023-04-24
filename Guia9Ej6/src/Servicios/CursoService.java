/*
d) Método cargarAlumnos(): este método le permitirá al usuario ingresar
los alumnos que asisten a las clases. Nosotros nos encargaremos de
almacenar esta información en un arreglo e iterar con un bucle,
solicitando en cada repetición que se ingrese el nombre de cada
alumno.
e) Método crearCurso(): el método crear curso, le pide los valores de
los atributos al usuario y después se le asignan a sus respectivos
atributos para llenar el objeto Curso. En este método invocamos al
método cargarAlumnos() para asignarle valor al atributo alumnos
f) Método calcularGananciaSemanal(): este método se encarga de
calcular la ganancia en una semana por curso. Para ello, se deben
multiplicar la cantidad de horas por día, el precio por hora, la
cantidad de alumnos y la cantidad de días a la semana que se repite
el encuentro.
 */
package Servicios;

import Entidades.Curso;
import java.util.Scanner;

/**
 *
 * @author CASA
 */
public class CursoService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public String[] cargarAlumnos() {
        String[] alumnos = new String[5];
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("Ingrese el nombre del alumno " + (i + 1));
            alumnos[i] = leer.next();
        }
        return alumnos;
    }

    public Curso crearCurso() {
        System.out.println("Ingrese nombre del Curso");
        String nombreCurso = leer.next();
        System.out.println("Ingrese Cantidad de Dias Por Semana");
        int cantDiasPorSem = leer.nextInt();
        System.out.println("Ingrese Cantidad Horas Por Dia");
        int cantHorasPorDia = leer.nextInt();
        System.out.println("Ingrese el Turno (Mañana/Tarde)");
        String turno = leer.next();
        System.out.println("Ingrese el precio por hora");
        double precio = leer.nextDouble();

        String alumnos[] = cargarAlumnos();

        return new Curso(nombreCurso, cantDiasPorSem, cantHorasPorDia, turno, precio, alumnos);
    }

    public void calcularGananciaSemanal(Curso c) {
        double ganancia = ((c.getPrecioPorHora() * c.getCantidadHorasPorDia()) * c.getCantidadDiasPorSemana()) * 5;
        System.out.println("Ganancia a la semana del curso: " + c.getNombreCurso()+"es $ " + ganancia);
    }
    
    public int buscarNombre(Curso c[]){
        System.out.println("Ingrese el nombre del curso:");
        String nombre =leer.next();
        for (int i = 0; i < buscarPrimerVacio(c); i++) {
            if (c[i].getNombreCurso().equalsIgnoreCase(nombre)){
                return i;
            }
        }
        return 101;
    }

    public int buscarPrimerVacio(Curso[] p) {

        int i = 0;
        while (p[i] != (null)) {
            i++;
            if (i == 99) {
                break;
            }
        }

        return i;

    }

}
