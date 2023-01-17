/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptiones;

/**
 *
 * @author user
 */
public class ExceptionAristaYaExiste extends Exception {

    /**
     * Creates a new instance of <code>ExceptionAristaYaExiste</code> without
     * detail message.
     */
    public ExceptionAristaYaExiste() {
        super("La arista ya existe en el grafo");
    }

    /**
     * Constructs an instance of <code>ExceptionAristaYaExiste</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionAristaYaExiste(String msg) {
        super(msg);
    }
}
