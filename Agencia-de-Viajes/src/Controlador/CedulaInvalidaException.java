package Controlador;

/**
 *
 * @author staly
 */
public class CedulaInvalidaException extends Exception {
  /**
   * muestra mensaje si este no es valido
   */
  public CedulaInvalidaException() {
        super("La cédula ingresada no es válida. Por favor, revise los datos ingresados.");
    }
}

