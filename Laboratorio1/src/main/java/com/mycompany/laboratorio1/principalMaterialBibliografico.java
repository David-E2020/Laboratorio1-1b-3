package com.mycompany.laboratorio1;

import java.util.Scanner;

/**
 *
 * @author david
 */
public class principalMaterialBibliografico {

    public static void main(String[] args) {
        int opc = 0;
        boolean continuar = true;
        OperacionesMaterialBibliografico obj = new OperacionesMaterialBibliografico();
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Crear archivo");
            System.out.println("2. Registrar libro/s");
            System.out.println("3. Registrar proyecto/s de grado");
            System.out.println("4. Guardar los registros");
            System.out.println("5. Mostrar Datos");
            System.out.println("6. Buscar libro por titulo");
            //System.out.println("6. Bloquear Tarjeta");
            //System.out.println("7. Depositar Dinero");
            //System.out.println("8. Retiro de Dinero");
            System.out.println("7. salir");
            System.out.println("Digite una opcion");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    String res = "S";
                    while (res.equalsIgnoreCase("S")) {
                        obj.crearLibro();
                        System.out.println("Desea seguir registrando libros? S/N");
                        res = leer.next();
                    }
                    break;
                case 3:
                    String res2 = "S";
                    while (res2.equalsIgnoreCase("S")) {
                        obj.crearProyectoGrado();
                        System.out.println("Desea seguir registrando libros? S/N");
                        res2 = leer.next();
                    }
                    break;
                case 4:
                    obj.guardarObjetos();
                    break;
                case 5:
                    obj.leerMaterialBibliografico();
                    obj.mostrarLibros();
                    obj.mostrarProyectoGrado();
                    break;
                case 6:
                    System.out.println("Digite el titulo del libro: ");
                    leer.nextLine();
                    String titulo=leer.nextLine();
                    obj.buscarLibros(titulo);
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
}
