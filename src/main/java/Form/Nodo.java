/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Form;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author user
 */
public class Nodo extends JButton implements ActionListener {
    Nodo parent;
    int row;
    int col;
    
    public Nodo(int aCol, int aRow){
    this.row=aRow;
    this.col=aCol;   
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        addActionListener(this);
        this.enable(false);
    }
    public void añadirParedes(){
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       setBackground(Color.ORANGE);
    }
    public void pintarCaminoCorrecto(){
        setBackground(Color.GREEN);
        setForeground(Color.BLACK);
    }
    public void pintarCaminoIncorrecto(){
        setBackground(Color.RED);
        setForeground(Color.BLACK);
    }
      public void pintarInicio(){
        setBackground(Color.BLUE);
        setForeground(Color.BLACK);
    }
        public void pintarFin(){
         setBackground(Color.WHITE);
        setForeground(Color.BLACK);
    }
    
    
}
