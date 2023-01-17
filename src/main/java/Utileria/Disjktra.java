/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utileria;

import Exceptiones.ExceptionAristaNoExiste;
import GrafoPesados.GrafoPesado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author user
 */
public class Disjktra {

    private final double[] costo;
    private final GrafoPesado grafoPesado;
    private final RecorridoUtils controlMarcados;
    private final int[] predecesor;
    private static final double INFINITO = Double.MAX_VALUE;
    private final Stack<Integer> colaDeAnteriores;
    private final List<Integer> caminosQueToma;

    public Disjktra(GrafoPesado unGrafo) throws ExceptionAristaNoExiste {
        this.grafoPesado = unGrafo;
        controlMarcados = new RecorridoUtils(this.grafoPesado.cantidadDeVertices());
        costo = new double[this.grafoPesado.cantidadDeVertices()];
        predecesor = new int[this.grafoPesado.cantidadDeVertices()];
        colaDeAnteriores= new Stack();
        caminosQueToma= new ArrayList<>();
        for (int i = 0; i < grafoPesado.cantidadDeVertices(); i++) {
            costo[i] = INFINITO;
            predecesor[i] = -1;
        }
      
      
}    
    
    public Stack<Integer> caminoDeMenorCosto(int verticeInicio, int verticeFin) throws ExceptionAristaNoExiste{
        costo[verticeInicio]=0;
        int verticeActual=verticeInicio;
        int contador=0;
        while(costo[verticeFin]==INFINITO && verticeActual!=-1){
            Iterable<Integer> listaDeAdyacentes=this.grafoPesado.adyacentesDelVertice(verticeActual);
            for(Integer AdyacenteInterino:listaDeAdyacentes){
                if(!controlMarcados.estaVerticeMarcado(AdyacenteInterino)){
                    double peso=this.grafoPesado.peso(verticeActual, AdyacenteInterino);
                    if(costo[verticeActual]+peso<costo[AdyacenteInterino]){
                        costo[AdyacenteInterino]=costo[verticeActual]+peso;
                       predecesor[AdyacenteInterino]=verticeActual;
                       caminosQueToma.add(AdyacenteInterino);
                    }
                }
            }
            
             controlMarcados.marcarVertice(verticeActual);
             verticeActual=buscarVerticeConMenorCosto();
        }
       
        colaDeAnteriores.push(verticeFin);
        int elemento=predecesor[verticeFin];
        while(elemento!=-1){
            colaDeAnteriores.push(elemento);
            elemento=predecesor[elemento];
        }
      
        return colaDeAnteriores;
     
    }
     
    public Stack<Integer> predecesores(){
        return colaDeAnteriores;
    }
    private int buscarVerticeConMenorCosto() {
      double valor=INFINITO;
      int menorCosto=-1;
        for(int i=0; i<this.grafoPesado.cantidadDeVertices(); i++){
            if(!controlMarcados.estaVerticeMarcado(i)&& valor>costo[i]){
                valor=costo[i];
                menorCosto=i;
            }
        }
        return menorCosto;

    }
     public List<Integer> caminoErroneos(){
      
        Collections.sort(caminosQueToma);
        return caminosQueToma;
    }
    

    
}
