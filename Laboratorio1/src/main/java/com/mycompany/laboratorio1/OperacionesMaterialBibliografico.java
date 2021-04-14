/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class OperacionesMaterialBibliografico {
    List<Libro> listaLibros;
    List<ProyectoGrado> listaProyectoGrado;
    Scanner leer = new Scanner(System.in);

    public OperacionesMaterialBibliografico() {
        listaLibros = new ArrayList<>();
        listaProyectoGrado = new ArrayList<>();

    }

    //creamos libro
    public void crearLibro() {
        Libro libro = new Libro();
        System.out.println("Digite el titulo: ");
        libro.setTitulo(leer.nextLine());
        System.out.println("Digite el autor: ");
        libro.setAutor(leer.nextLine());
        System.out.println("Digite la edicion: ");
        libro.setEdicion(leer.nextInt());
        leer.nextLine();
        System.out.println("Digite el area de estudio: ");
        libro.setArea(leer.nextLine());
        System.out.println("REGISTRADO...");
        //registramos el libro en la lista de libros de la biblioteca
        listaLibros.add(libro);

    }

    public void crearProyectoGrado() {
        ProyectoGrado proyectoGrado = new ProyectoGrado();
        System.out.println("Digite el titulo: ");
        proyectoGrado.setTitulo(leer.nextLine());
        System.out.println("Digite el autor: ");
        proyectoGrado.setAutor(leer.nextLine());
        System.out.println("Digite el tutor: ");
        proyectoGrado.setTutor(leer.nextLine());
        System.out.println("Digite el revisor: ");
        proyectoGrado.setRevisor(leer.nextLine());
        System.out.println("REGISTRADO...");
        //registramos el proyecto de grado en la lista de proyectos de grado de la biblioteca
        listaProyectoGrado.add(proyectoGrado);
    }

    public void mostrarLibros() {
        if (listaLibros != null) {
            System.out.println("***Lista de libros***");
            System.out.println("---------------------------------------");
            for (Libro libroAux : listaLibros) {
                libroAux.mostrar();
                System.out.println("---------------------------------------");
            }
            System.out.println("");
        } else {
            System.out.println("***No tiene libros registrados***");
        }
    }
    
    public void mostrarProyectoGrado() {
        if (listaProyectoGrado != null) {
            System.out.println("***Lista de proyectos de grado***");
            System.out.println("---------------------------------------");
            for (ProyectoGrado proyectoGradoAux:listaProyectoGrado) {
                proyectoGradoAux.mostrar();
                System.out.println("---------------------------------------");
            }
            System.out.println("");
        } else {
            System.out.println("***No tiene proyectos de grado registrados***");
        }
    }
    
    public void buscarLibros(String nombre) {
        int sw=0;
        if (listaLibros != null) {
            System.out.println("---------------------------------------");
            for (Libro libroAux : listaLibros) {
                if(nombre.equalsIgnoreCase(libroAux.getTitulo())){
                    System.out.println("*** Libro encontrado ***");
                    System.out.println("");
                    libroAux.mostrar();
                    System.out.println("---------------------------------------");
                    sw=1;
                }
            }
            if (sw==0) {
                System.out.println("*** Libro no encontrado. ***");
            }
            System.out.println("");
        } else {
            System.out.println("***No tiene libros registrados***");
        }
    }
    
    public void eliminarLibros(String nombre) {
        int sw=0;
        if (listaLibros != null) {
            System.out.println("---------------------------------------");
            for (Libro libroAux : listaLibros) {
                if(nombre.equalsIgnoreCase(libroAux.getTitulo())){
                    System.out.println("*** Libro encontrado ***");
                    System.out.println("");
                    libroAux.mostrar();
                    listaLibros.remove(libroAux);
                    System.out.println("Libro eliminado");
                    System.out.println("---------------------------------------");
                    sw=1;
                }
            }
            if (sw==0) {
                System.out.println("*** Libro no encontrado. ***");
            }
            System.out.println("");
        } else {
            System.out.println("***No tiene libros registrados***");
        }
    }
    
    public void eliminarProyecto(String nombre) {
        int sw=0;
        if (listaProyectoGrado != null) {
            System.out.println("---------------------------------------");
            for (ProyectoGrado libroAux : listaProyectoGrado) {
                if(nombre.equalsIgnoreCase(libroAux.getTitulo())){
                    System.out.println("*** Libro encontrado ***");
                    System.out.println("");
                    libroAux.mostrar();
                    listaProyectoGrado.remove(libroAux);
                    System.out.println("Proyecto eliminado");
                    System.out.println("---------------------------------------");
                    guardarObjetos();
                    sw=1;
                }
            }
            if (sw==0) {
                System.out.println("*** Libro no encontrado. ***");
            }
            System.out.println("");
        } else {
            System.out.println("***No tiene libros registrados***");
        }
    }
    
    
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\Laboratorio1-A-1b-3\\archivoLibro.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (Exception e) {
        }
    }
    //guardando la listacliente dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta="D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\Laboratorio1-A-1b-3\\archivoLibro.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaLibros);
            oos.writeObject(listaProyectoGrado);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesMaterialBibliografico.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionesMaterialBibliografico.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerMaterialBibliografico(){
        String ruta="D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\Laboratorio1-A-1b-3\\archivoLibro.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaLibros=(List<Libro>)ois.readObject();
                listaProyectoGrado=(List<ProyectoGrado>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesMaterialBibliografico.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesMaterialBibliografico.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesMaterialBibliografico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
