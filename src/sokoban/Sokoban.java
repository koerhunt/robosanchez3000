/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.util.Scanner;

/**
 *
 * @author koerhunt
 */
public class Sokoban {
    
    //[renglon][columna]    
    static char MAPA[][] = {
        { '#', '#', '#', '#', '#', '#', '#'},
        { '#', ' ', ' ', ' ', '#', '#', '#'},
        { '#', ' ', 'x', ' ', ' ', ' ', '#'},
        { '#', '#', 'x', '#', '#', ' ', '#'},
        { '#', 'o', ' ', ' ', ' ', ' ', '#'},
        { '#', 'o', ' ', 'v', '#', '#', '#'},
        { '#', '#', '#', '#', '#', '#', '#'}
    };

    public static void main(String[] args) {
        
        
        //inicializar estado
        Estado inicial = new Estado(MAPA,(byte)3,(byte)5);
            
        
        
        Scanner sn = new Scanner(System.in);
        inicial.ImprimirMundo();
        while(true){
            String r = sn.next();
            switch(r){
                case "w":
                    System.out.println("mover arriba");
                    inicial.moverPersonajeArriba();
                    break;
                case "d":
                    System.out.println("mover derecha");
                    inicial.moverPersonajeDerecha();
                    break;
                case "s":
                    System.out.println("mover abajo");
                    inicial.moverPersonajeAbajo();
                    break;
                case "a":
                    System.out.println("mover izquierda");
                    inicial.moverPersonajeIzquierda();
                    break;
            }
            inicial.ImprimirMundo();
        }


        
    }
   
}