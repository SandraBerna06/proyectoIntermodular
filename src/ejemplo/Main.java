package ejemplo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList gestion = new ArrayList();
        int opcion;
        do {
            System.out.println("\nMenú de Gestión de Colegios:");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Actualizar");
            System.out.println("4. Consultar");
            System.out.println("5. Imprimir");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese código del colegio: ");
                    int cod = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nombre del colegio: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese código de ciudad: ");
                    int ciudad = scanner.nextInt();
                    colegio nuevoColegio = new colegio(cod, nombre, ciudad, new ArrayList<>());
                    colegio.addNewEjemplo(nuevoColegio);
                    break;
                case 2:
                    System.out.print("Ingrese código del colegio a eliminar: ");
                    int codEliminar = scanner.nextInt();
                    colegio.removeEjemplo(codEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese código del colegio a actualizar: ");
                    int codActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese nuevo código de ciudad: ");
                    int nuevaCiudad = scanner.nextInt();
                    colegio.updateEjemplo(codActualizar, nuevoNombre, nuevaCiudad);
                    break;
                case 4:
                    System.out.print("Ingrese código del colegio a consultar: ");
                    int codConsultar = scanner.nextInt();
                    colegio encontrado = colegio.findEjemploByClave(codConsultar);
                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Colegio no encontrado.");
                    }
                    break;
                case 5:
                    colegio.printEjemplo();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
        scanner.close();
    }
}
