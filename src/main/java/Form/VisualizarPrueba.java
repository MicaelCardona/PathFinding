/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Form;

import CreacionLaberinto.Laberinto;
import Exceptiones.ExceptionAristaNoExiste;
import Exceptiones.ExceptionAristaYaExiste;
import Exceptiones.ExceptionesNroVerticeInvalidos;
import Utileria.Disjktra;

/**
 *
 * @author user
 */
public class VisualizarPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExceptionesNroVerticeInvalidos, ExceptionAristaYaExiste, ExceptionAristaNoExiste {
       int[][] laberinto0={ 
        {0,1,0,0,0,1,0,0,0,0,0,0,1,0,0},
        {0,1,0,0,0,1,0,0,1,0,0,0,1,0,1},
        {0,1,0,0,0,1,0,0,1,0,0,0,1,0,1},
        {0,1,0,0,0,1,0,0,1,0,0,0,1,0,1},
        {0,1,0,0,0,0,0,0,1,0,0,0,0,0,1},
        {0,1,1,1,1,1,0,1,1,0,1,1,1,1,1},
        {0,1,0,0,1,0,0,0,0,0,0,0,0,0,0},
        {0,1,1,1,0,1,1,1,1,0,1,1,1,1,1},
        {0,0,1,0,1,1,0,0,0,0,0,0,0,0,1},
        {0,1,0,1,0,0,0,0,1,0,0,0,0,0,1},
        {0,1,0,1,0,0,1,0,0,0,0,0,0,0,1},
        {0,1,0,1,0,0,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
         
        };
          int[][] Laberinto1={ 
        {0,1,1},
        {1,0,1},
        {1,1,0}, 
              
        };
          
       int[][] laberinto3={ 
        {0,1,1,0,0,0},
        {0,1,1,0,1,0},
        {0,1,1,0,0,1},
        {0,0,0,0,1,0},
        {0,0,0,1,1,0},
        {0,0,0,1,0,0},
         
        };
         
         Laberinto prueba= new Laberinto(laberinto0);
   
         Disjktra caminoMasCorto= new Disjktra(prueba.obtenerElGrafo());
         System.out.println(prueba.obtenerElGrafo().toString());
         System.out.println(prueba.mostrarMAtrizTerminada());
         
         System.out.println("Camino mas corto: "+caminoMasCorto.caminoDeMenorCosto(0, 14)); 
          System.out.println("Camino mas corto: "+caminoMasCorto.caminoErroneos()); 
         
    
    }
    
}
