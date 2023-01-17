/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Teclas;

import Exceptiones.ExceptionAristaNoExiste;
import Exceptiones.ExceptionAristaYaExiste;
import Exceptiones.ExceptionesNroVerticeInvalidos;
import Form.DemoForm;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Reiniciar  implements KeyListener {
   DemoForm demoForm;
    public Reiniciar(DemoForm unDemoForm){
        this.demoForm= unDemoForm;
       
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
     int tecla=e.getKeyCode();
     if(tecla==KeyEvent.VK_R){
         try {
             demoForm.restart();
         } catch (ExceptionesNroVerticeInvalidos ex) {
             Logger.getLogger(Reiniciar.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ExceptionAristaYaExiste ex) {
             Logger.getLogger(Reiniciar.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ExceptionAristaNoExiste ex) {
             Logger.getLogger(Reiniciar.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

   
 
}
