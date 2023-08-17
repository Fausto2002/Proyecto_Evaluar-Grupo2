
package Modelo;

/**
 *
 * @author Pc
 */
public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String clave;

  /**
   *
   * @return
   */
  public int getIdUsuario() {
        return idUsuario;
    }

  /**
   *
   * @param idUsuario
   */
  public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

  /**
   *
   * @return
   */
  public String getUsuario() {
        return nombreUsuario;
    }

  /**
   *
   * @param usuario
   */
  public void setUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

  /**
   *
   * @return
   */
  public String getClave() {
        return clave;
    }

  /**
   *
   * @param clave
   */
  public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
