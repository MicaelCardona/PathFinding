/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CreacionLaberinto;

import Exceptiones.ExceptionAristaNoExiste;
import Exceptiones.ExceptionAristaYaExiste;
import Exceptiones.ExceptionesNroVerticeInvalidos;
import GrafoPesados.DigrafoPesado;
import GrafoPesados.GrafoPesado;

/**
 *
 * @author user
 */
public class Laberinto {
    private final GrafoPesado grafo;
    private final int [][] matrizLaberinto;
    private int [][] matrizTerminada;

    
public Laberinto(int paredesLaberinto [][]) throws ExceptionesNroVerticeInvalidos, ExceptionAristaYaExiste, ExceptionAristaNoExiste  {
    int longitud=paredesLaberinto.length;
    matrizTerminada= new int[longitud][longitud];
    matrizLaberinto=paredesLaberinto;
    grafo= new GrafoPesado((longitud*longitud));
    matrizAyuda();
    conectarAristas();
    eliminarConVerticesConUnos();
    obtenerMatrizTerminada();
}

public int [][] matrizAyuda(){
   
    int longitud=matrizLaberinto.length;
    int colocarValores=0;
     int [][] matriz= new int[longitud][longitud];
    for (int i=0; i<longitud; i++){
          for (int j=0; j<longitud; j++){
        matriz[i][j]=colocarValores++;
    }
    }
    matrizTerminada=matriz;
    return matriz;
   
}
    private void conectarAristas() throws ExceptionAristaYaExiste {
        int longitud = matrizLaberinto.length;
        int colocarValores=0;
        for (int i = 0; i < longitud; i++) {
            for (int j = 0; j < longitud; j++) {
                if(j!=longitud-1){
                  grafo.insertarArista(colocarValores, colocarValores+1, 1);
                
                }
                if(i!=longitud-1){
                    if(j==longitud-1){
                        grafo.insertarArista(colocarValores, colocarValores+longitud, 1);
                    }else{
               grafo.insertarArista(colocarValores, colocarValores+longitud, 1);
               grafo.insertarArista(colocarValores, (colocarValores+longitud)+1, 4);
                }
                }
            colocarValores++;  
            }
        }
    }
 private void eliminarConVerticesConUnos() throws ExceptionAristaYaExiste, ExceptionAristaNoExiste{
     int longitud=matrizLaberinto.length;
     int  colocarValores=0;
     int [][] matrizAyuda=matrizAyuda();
     int [][] matriz= new int[longitud][longitud];
    for (int i=0; i<longitud; i++){
          for (int j=0; j<longitud; j++){
         if(matrizLaberinto[i][j]==1){
                    quitarAristas(j, longitud, colocarValores, i);
             
         }else{
            
            if(i!=longitud-1){
                 if(matrizLaberinto[i+1][j]==1){//si se encuentra con un uno abajo entonces eliminar
            if(j==longitud-1){ //si j es igual a la ultima posicion de la fila en la matriz entonces elimina el de abajo
                grafo.elimnarArista(colocarValores, colocarValores+longitud);
            }else{
                grafo.elimnarArista(colocarValores, colocarValores+longitud);
            }
        }
         }
             if  (j!=longitud-1){
             if(matrizLaberinto[i][j+1]==1 ){
                  grafo.elimnarArista(colocarValores, colocarValores+1);
             }
          
             }
         }
         
         
         colocarValores++;
    }
    }
  
 }

    private void quitarAristas(int j, int longitud, int colocarValores, int i) throws ExceptionAristaNoExiste {
        if(j!=longitud-1){
            grafo.elimnarArista(colocarValores, colocarValores+1);
            
        }
        if(i!=longitud-1){
            if(j==longitud-1){
                grafo.elimnarArista(colocarValores, colocarValores+longitud);
            }else{
                grafo.elimnarArista(colocarValores, colocarValores+longitud);
                grafo.elimnarArista(colocarValores, (colocarValores+longitud)+1);
            }
        }
    }
 public GrafoPesado mostrarGrafo(){
     return this.grafo;
 }
 public int[][] obtenerMatrizTerminada(){
    int longitud= matrizLaberinto.length;
     for(int i=0; i<longitud; i++){
         for(int j=0; j<longitud; j++){
         if(matrizLaberinto[i][j]==1){
             matrizTerminada[i][j]=1;
         }
     }
     }
     return matrizTerminada;
 }
 public GrafoPesado obtenerElGrafo(){
     return grafo;
 }
 
    public String mostrarMAtrizTerminada(){
           String s="MATRIZ DE CAMINOS";
           int longitud=matrizTerminada.length;
       
        
       for(int i=0;i<longitud;i++){
           s=s+"\n";
           for(int j=0;j<longitud;j++){
              
                  s=s+matrizTerminada[i][j]+"|";
               
                 
          } 
    }
        return s;
        
    }
    


    
}
