/*
Un profesor particular está dando cursos para grupos de cinco alumnos
y necesita un programa para organizar la información de cada curso.
Para ello, crearemos una clase entidad llamada Curso, cuyos atributos
serán: nombreCurso, cantidadHorasPorDia, cantidadDiasPorSemana,
turno (mañana o tarde), precioPorHora y alumnos. Donde alumnos es un
arreglo de tipo String de dimensión 5 (cinco), donde se alojarán los
nombres de cada alumno. A continuación, se implementarán los
siguientes métodos:
a) Un constructor por defecto.
b) Un constructor con todos los atributos como parámetro.
c) Métodos getters y setters de cada atributo.
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
5
 */
package guia9ej6;

import Entidades.Curso;
import Servicios.CursoService;
import java.util.Scanner;

/**
 *
 * @author CASA
 */
public class Guia9Ej6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        CursoService cs = new CursoService();

        Curso[] c = new Curso[100];
        int opc = 0;
        do {
            System.out.println("MENU");
            System.out.println("-----");
            System.out.println("Opcion1: Crear Curso");
            System.out.println("Opcion2: Calcular la ganancia semanal");
            System.out.println("Opcion3: Calcular la ganancia total");
            System.out.println("Opcion4: Mostrar informacion del curso");
            System.out.println("Opcion5: Salir");
            System.out.println("-----");
            System.out.println("Ingrese una opcion:");
            opc = leer.nextInt();

            switch (opc) {
                case 1:
                    c[cs.buscarPrimerVacio(c)] = cs.crearCurso();
                    break;
                case 2:
                    cs.calcularGananciaSemanal(c[cs.buscarNombre(c)]);
                    break;
                    
                case 3:
                    for (int i = 0; i < cs.buscarPrimerVacio(c); i++){
                        cs.calcularGananciaSemanal(c[i]);
                    }
                    break;
                case 4 :
                    System.out.println(cs.toString());
                    break;
                case 5:
                     System.out.println("Muchas Gracias");
                     break;
                
                default:
                    System.out.println("Ingrese una opcion válida");
                    //throw new AssertionError();
            }

        } while (opc != 5);

    }

}
