/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Form;

import CreacionLaberinto.Laberinto;
import Exceptiones.ExceptionAristaNoExiste;
import Exceptiones.ExceptionAristaYaExiste;
import Exceptiones.ExceptionesNroVerticeInvalidos;
import Teclas.MostrarCaminoCorrecto;
import Teclas.Reiniciar;
import Utileria.Disjktra;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Stack;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class DemoForm extends JPanel {
    //Screen settings
    
       
        int[][] laberinto2={ 
        {0,1,0,0,0,0,0,1,0,0,0,0,0,1,0},
        {0,1,0,0,0,0,0,1,0,0,0,0,0,1,0},
        {0,0,0,0,0,0,0,1,0,0,0,0,0,1,0}, 
        {0,1,0,1,0,0,0,1,0,0,0,0,0,1,0},
        {0,1,0,1,0,0,0,1,0,0,0,0,1,1,0},
        {0,1,0,1,0,0,0,0,0,0,0,0,1,1,0},
        {0,1,0,1,1,1,1,0,0,0,0,0,1,1,0},
        {0,1,0,1,1,0,1,0,0,0,0,0,0,1,0},
        {0,1,0,1,1,1,1,0,0,0,0,0,0,1,0},
        {0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
        {0,1,0,1,0,0,0,1,0,0,0,0,0,1,0},
        {0,1,0,1,1,1,0,1,1,0,0,0,1,0,0},
        {0,1,0,1,1,0,1,0,1,0,0,0,1,1,0},
        {0,1,0,1,1,0,0,0,1,0,0,0,1,1,0},
        {0,0,0,0,1,0,0,0,1,0,0,0,0,1,0},
         
        };
        
         int[][] laberinto3={ 
        {0,1,0,0,0,1,0,0,0,0,0,0,1,0,0},
        {0,1,0,0,0,1,0,0,1,0,0,0,1,0,1},
        {0,1,0,0,0,1,0,0,1,0,0,0,1,0,1},
        {0,1,0,0,0,1,0,0,1,0,0,0,1,0,1},
        {0,1,0,0,0,0,0,0,1,0,0,0,0,0,1},
        {0,1,1,1,1,1,0,1,1,0,1,1,1,1,1},
        {0,1,0,0,1,0,0,0,0,0,0,0,0,0,1},
        {0,1,1,1,0,1,1,1,1,0,1,1,1,1,1},
        {0,0,1,0,1,1,0,0,0,0,0,0,0,0,1}, 
        {0,1,0,1,0,0,0,0,1,0,0,0,0,0,1},
        {0,1,0,1,0,0,1,0,0,0,0,0,0,0,1},
        {0,1,0,1,0,0,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
         
        };
    final int [][] laberintoPadre=laberinto2; //cambiar laberinto
    int posicionInicio=0;
    int posicionFin=224;
    int longitud= laberintoPadre.length;
    final int maxCol = longitud;
    final int maxRow = longitud;
    final int nodeSize = 100;
    final int screenWidht = nodeSize * maxCol;
    final int screenHeight = nodeSize * maxRow;
    final Disjktra caminoMasCorto;
    Stack<Integer> caminosCorrectos;
    final Laberinto lab;
 //   final List<Integer> caminosIncorrectos;
    

    
    //Nodo
     Nodo[][] nodo= new Nodo[maxCol][maxRow];
    public DemoForm() throws ExceptionesNroVerticeInvalidos, ExceptionAristaYaExiste, ExceptionAristaNoExiste{
        
        lab = new Laberinto(laberintoPadre);//crear los nodos y el lab
        caminoMasCorto= new Disjktra(lab.obtenerElGrafo());//crear dijktra
        caminosCorrectos=caminoMasCorto.caminoDeMenorCosto(posicionInicio,posicionFin);//elegir la posicion
        this.setPreferredSize(new Dimension(screenWidht, screenHeight));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(maxRow,maxCol));
        this.addKeyListener(new MostrarCaminoCorrecto(this)); //Apretar la tecla enter prologadamente para iniciar
        this.addKeyListener(new Reiniciar(this)); //Apretar R para reiniciar
   
       //cambia color
        this.setFocusable(true);
        //Lugar de los Nodos
        int col=0;
        int row=0;
        while(col<maxCol && row<maxRow){
            nodo[col][row]= new Nodo (col,row);
            this.add(nodo[col][row]);
            col++;
            if(col== maxCol){
                col=0;
                row++;
            }
        
        }
        paredes();
        
      
  
         
    }
          
    private void paredes() throws ExceptionesNroVerticeInvalidos, ExceptionAristaYaExiste, ExceptionAristaNoExiste {
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (lab.obtenerMatrizTerminada()[j][i] == 1) {
                    nodo[i][j].añadirParedes(); //añade las paredes al nodo
                }
            }
        }

    }
   
    public void pintarNodosCorrectos() throws ExceptionesNroVerticeInvalidos, ExceptionAristaYaExiste, ExceptionAristaNoExiste{
        
        int longtitud= lab.obtenerMatrizTerminada().length;
        for (int i = 0; i <longtitud ; i++) {
            for (int j = 0; j < longtitud; j++) {
                if (!caminosCorrectos.isEmpty()) {

                    if (lab.obtenerMatrizTerminada()[j][i] == caminosCorrectos.peek()) {
                        nodo[i][j].pintarCaminoCorrecto();
                        caminosCorrectos.pop();
                    }
                }
            }
        }
        
    }
    public void restart() throws ExceptionesNroVerticeInvalidos, ExceptionAristaYaExiste, ExceptionAristaNoExiste{
       int longtitud= lab.obtenerMatrizTerminada().length;
        for (int i = 0; i <longtitud ; i++) {
            for (int j = 0; j < longtitud; j++) {
             nodo[i][j].pintarFin();
            }
        }
        paredes();
        caminosCorrectos=caminoMasCorto.caminoDeMenorCosto(posicionInicio, posicionFin);
          
    }
    
    

    
}
