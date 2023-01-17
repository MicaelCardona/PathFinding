/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptiones;

/**
 *
 * @author user
 */
public class ExceptionesNroVerticeInvalidos extends Exception {

    /**
     * Creates a new instance of <code>ExceptionesDeGrafos</code> without detail
     * message.
     */
    public ExceptionesNroVerticeInvalidos() {
        super("el numero de vertices es invalido");
    }

    /**
     * Constructs an instance of <code>ExceptionesDeGrafos</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionesNroVerticeInvalidos(String msg) {
        super(msg);
    }
}

