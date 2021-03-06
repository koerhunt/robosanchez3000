/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

/**
 *
 * @author koerhunt
 */
public class Estado {
    
    public char[][] MAPA;
    
    byte pcol = 0;
    byte prow = 0;
    
    // -1 = muro
    //  0 = espacio disponible
    //  1 = personaje
    //  2 = caja
    //  3 = en una meta
    //  4 = meta con una caja
    //  5 = personaje en la meta
    final char MURO = '#';
    final char HUECO = ' ';
    final char JUGADOR = 'v';
    final char CAJA = 'x';
    final char META = 'o';
    final char CAJA_EN_META = 'X';
    final char JUGADOR_EN_META = 'O';
    
    Estado(char[][] mundo, byte col, byte row){
        MAPA = new char[mundo.length][mundo[0].length];
        
        //clonamos informacion
        for(byte i = 0; i<mundo.length;i++){
            for(byte j = 0; j<mundo[0].length;j++){
                MAPA[i][j] = mundo[i][j];
            }
        }
        
        //asignamos personaje
        this.pcol = col;
        this.prow = row;
         
         
         
    }
    
    void ImprimirMundo(){
     for(byte i = 0; i<MAPA.length;i++){
            for(byte j = 0; j<MAPA[0].length;j++){
                System.out.print(" "+MAPA[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    void EncontrarPersonaje(){
        //Investigar donde esta el personaje
        for(byte i = 0; i<MAPA.length;i++){
            for(byte j = 0; j<MAPA[0].length;j++){
                if(MAPA[i][j]=='v'||MAPA[i][j]=='O'){
                    pcol = j;
                    prow = i;
                }
            }
        }}
    
    //Mover personaje a la derecha
    void llenarHuecoPersonaje(){
        if(MAPA[prow][pcol]==JUGADOR_EN_META){
            //si el jugador estaba sobre una meta, hay que dejar la meta
            //vacia en la posicion del jugador
            MAPA[prow][pcol]=META;
        }else{
            //si el jugador estaba en un espacio vacio
            //hay que dejar ese espacio vacio.
            MAPA[prow][pcol]=HUECO;
        }
    }
    void moverPersonajeDerecha(){
        
        //Analizar la casilla del personaje a la derecha
        switch(MAPA[prow][pcol+1]){
            //hay muro
            case MURO:
                return;
            //hay hueco
            case HUECO:
                //mover personaje
                MAPA[prow][pcol+1]=JUGADOR;
                llenarHuecoPersonaje();
                pcol++;
                break;
            //hay una meta
            case META:
                //mover personaje
                MAPA[prow][pcol+1]=JUGADOR_EN_META;
                llenarHuecoPersonaje();
                pcol++;
                break;
            //hay caja
            case CAJA:
                
                switch(MAPA[prow][pcol+2]){
                    case MURO:
                        return;
                    case HUECO:
                        //empujar caja
                        MAPA[prow][pcol+2] = CAJA;
                        MAPA[prow][pcol+1] = JUGADOR;
                        llenarHuecoPersonaje();
                        pcol++;
                        break;
                    case CAJA:
                        return;
                    case META:
                        //TODO: aqui te quedaste elias
                        //este si hayque programarla
                        MAPA[prow][pcol+2] = CAJA_EN_META;
                        MAPA[prow][pcol+1] = JUGADOR;
                        llenarHuecoPersonaje();
                        pcol++;
                        break;
                    case CAJA_EN_META:
                        return;
                }
                
                break;
            //una meta con caja
            case CAJA_EN_META:
                switch(MAPA[prow][pcol+2]){
                    case MURO:
                        return;
                    case HUECO:
                        //empujar caja
                        MAPA[prow][pcol+2] = CAJA;
                        MAPA[prow][pcol+1] = JUGADOR_EN_META;
                        llenarHuecoPersonaje();
                        pcol++;
                        break;
                    case CAJA:
                        return;
                    case META:
                        //TODO: aqui te quedaste elias
                        //este si hayque programarla
                        MAPA[prow][pcol+2] = CAJA_EN_META;
                        MAPA[prow][pcol+1] = JUGADOR_EN_META;
                        llenarHuecoPersonaje();
                        pcol++;
                        break;
                    case CAJA_EN_META:
                        return;
                }
                break;       
        }        
     }
    void moverPersonajeIzquierda(){
        
        //Analizar la casilla del personaje a la derecha
        switch(MAPA[prow][pcol-1]){
            //hay muro
            case MURO:
                return;
            //hay hueco
            case HUECO:
                //mover personaje
                MAPA[prow][pcol-1]=JUGADOR;
                llenarHuecoPersonaje();
                pcol--;
                break;
            //hay una meta
            case META:
                //mover personaje
                MAPA[prow][pcol-1]=JUGADOR_EN_META;
                llenarHuecoPersonaje();
                pcol--;
                break;
            //hay caja
            case CAJA:
                
                switch(MAPA[prow][pcol-2]){
                    case MURO:
                        return;
                    case HUECO:
                        //empujar caja
                        MAPA[prow][pcol-2] = CAJA;
                        MAPA[prow][pcol-1] = JUGADOR;
                        llenarHuecoPersonaje();
                        pcol--;
                        break;
                    case CAJA:
                        return;
                    case META:
                        //TODO: aqui te quedaste elias
                        //este si hayque programarla
                        MAPA[prow][pcol-2] = CAJA_EN_META;
                        MAPA[prow][pcol-1] = JUGADOR;
                        llenarHuecoPersonaje();
                        pcol--;
                        break;
                    case CAJA_EN_META:
                        return;
                }
                
                break;
            //una meta con caja
            case CAJA_EN_META:
                switch(MAPA[prow][pcol-2]){
                    case MURO:
                        return;
                    case HUECO:
                        //empujar caja
                        MAPA[prow][pcol-2] = CAJA;
                        MAPA[prow][pcol-1] = JUGADOR_EN_META;
                        llenarHuecoPersonaje();
                        pcol--;
                        break;
                    case CAJA:
                        return;
                    case META:
                        //TODO: aqui te quedaste elias
                        //este si hayque programarla
                        MAPA[prow][pcol-2] = CAJA_EN_META;
                        MAPA[prow][pcol-1] = JUGADOR_EN_META;
                        llenarHuecoPersonaje();
                        pcol--;
                        break;
                    case CAJA_EN_META:
                        return;
                }
                break;
                
                
        }
        
        
        
     }
    void moverPersonajeArriba(){
        
        //Analizar la casilla del personaje a la derecha
        switch(MAPA[prow-1][pcol]){
            //hay muro
            case MURO:
                return;
            //hay hueco
            case HUECO:
                //mover personaje
                MAPA[prow-1][pcol]=JUGADOR;
                llenarHuecoPersonaje();
                prow--;
                break;
            //hay una meta
            case META:
                //mover personaje
                MAPA[prow-1][pcol]=JUGADOR_EN_META;
                llenarHuecoPersonaje();
                prow--;
                break;
            //hay caja
            case CAJA:
                
                switch(MAPA[prow-2][pcol]){
                    case MURO:
                        return;
                    case HUECO:
                        //empujar caja
                        MAPA[prow-2][pcol] = CAJA;
                        MAPA[prow-1][pcol] = JUGADOR;
                        llenarHuecoPersonaje();
                        prow--;
                        break;
                    case CAJA:
                        return;
                    case META:
                        //TODO: aqui te quedaste elias
                        //este si hayque programarla
                        MAPA[prow-2][pcol] = CAJA_EN_META;
                        MAPA[prow-1][pcol] = JUGADOR;
                        llenarHuecoPersonaje();
                        prow--;
                        break;
                    case CAJA_EN_META:
                        return;
                }
                
                break;
            //una meta con caja
            case CAJA_EN_META:
                switch(MAPA[prow-2][pcol]){
                    case MURO:
                        return;
                    case HUECO:
                        //empujar caja
                        MAPA[prow-2][pcol] = CAJA;
                        MAPA[prow-1][pcol] = JUGADOR_EN_META;
                        llenarHuecoPersonaje();
                        prow--;
                        break;
                    case CAJA:
                        return;
                    case META:
                        //TODO: aqui te quedaste elias
                        //este si hayque programarla
                        MAPA[prow-2][pcol] = CAJA_EN_META;
                        MAPA[prow-1][pcol] = JUGADOR_EN_META;
                        llenarHuecoPersonaje();
                        prow--;
                        break;
                    case CAJA_EN_META:
                        return;
                }
                break;
                
                
        }
        
        
        
     }
    void moverPersonajeAbajo(){
        
        //Analizar la casilla del personaje a la derecha
        switch(MAPA[prow+1][pcol]){
            //hay muro
            case MURO:
                return;
            //hay hueco
            case HUECO:
                //mover personaje
                MAPA[prow+1][pcol]=JUGADOR;
                llenarHuecoPersonaje();
                prow++;
                break;
            //hay una meta
            case META:
                //mover personaje
                MAPA[prow+1][pcol]=JUGADOR_EN_META;
                llenarHuecoPersonaje();
                prow++;
                break;
            //hay caja
            case CAJA:
                
                switch(MAPA[prow+2][pcol]){
                    case MURO:
                        return;
                    case HUECO:
                        //empujar caja
                        MAPA[prow+2][pcol] = CAJA;
                        MAPA[prow+1][pcol] = JUGADOR;
                        llenarHuecoPersonaje();
                        prow++;
                        break;
                    case CAJA:
                        return;
                    case META:
                        //TODO: aqui te quedaste elias
                        //este si hayque programarla
                        MAPA[prow+2][pcol] = CAJA_EN_META;
                        MAPA[prow+1][pcol] = JUGADOR;
                        llenarHuecoPersonaje();
                        prow++;
                        break;
                    case CAJA_EN_META:
                        return;
                }
                
                break;
            //una meta con caja
            case CAJA_EN_META:
                switch(MAPA[prow+2][pcol]){
                    case MURO:
                        return;
                    case HUECO:
                        //empujar caja
                        MAPA[prow+2][pcol] = CAJA;
                        MAPA[prow+1][pcol] = JUGADOR_EN_META;
                        llenarHuecoPersonaje();
                        prow++;
                        break;
                    case CAJA:
                        return;
                    case META:
                        //TODO: aqui te quedaste elias
                        //este si hayque programarla
                        MAPA[prow+2][pcol] = CAJA_EN_META;
                        MAPA[prow+1][pcol] = JUGADOR_EN_META;
                        llenarHuecoPersonaje();
                        prow++;
                        break;
                    case CAJA_EN_META:
                        return;
                }
                break;
                
                
        }
        
        
        
     }
    
}
