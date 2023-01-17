/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Form;

import Exceptiones.ExceptionAristaNoExiste;
import Exceptiones.ExceptionAristaYaExiste;
import Exceptiones.ExceptionesNroVerticeInvalidos;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class Form {

    /**
     * @param args the command line arguments
     * @throws Exceptiones.ExceptionesNroVerticeInvalidos
     */
    public static void main(String[] args) throws ExceptionesNroVerticeInvalidos, ExceptionAristaYaExiste, ExceptionAristaNoExiste {
        // TODO code application logic here
        JFrame window = new JFrame();
        window.setResizable(false);
        window.add(new DemoForm());
        window.pack();
        window.setLocationRelativeTo(null);//Se posiciona al centro de la pantalla
       
       
        
        window.setVisible(true);
        

    }

    public void actionPerformed(ActionEvent ev) {
        System.exit(0);
    }
 
}
