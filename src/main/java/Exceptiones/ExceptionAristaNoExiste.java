/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptiones;

/**
 *
 * @author user
 */
public class ExceptionAristaNoExiste extends Exception {

    /**
     * Creates a new instance of <code>ExceptionAristaNoExiste</code> without
     * detail message.
     */
    public ExceptionAristaNoExiste() {
        super("Arista no Existe , No hay adyacencia para eliminar");
    }

    /**
     * Constructs an instance of <code>ExceptionAristaNoExiste</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionAristaNoExiste(String msg) {
        super(msg);
    }
}
