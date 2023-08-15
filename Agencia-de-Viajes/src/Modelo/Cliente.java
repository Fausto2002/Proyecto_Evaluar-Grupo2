package Modelo;

/**
 *
 * @author Pc
 */
public class Cliente {
    
//Clase Cliente
    private int idCliente;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String email;

    
//Getters and Setters

  /**
   *
   * @return
   */
    public int getIdCliente() {
        return idCliente;
    }

  /**
   *
   * @param idCliente
   */
  public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

  /**
   *
   * @return
   */
  public String getCedula() {
        return cedula;
    }

  /**
   *
   * @param cedula
   */
  public void setCedula(String cedula) {
        this.cedula = cedula;
    }

  /**
   *
   * @return
   */
  public String getNombres() {
        return nombres;
    }

  /**
   *
   * @param nombres
   */
  public void setNombres(String nombres) {
        this.nombres = nombres;
    }

  /**
   *
   * @return
   */
  public String getApellidos() {
        return apellidos;
    }

  /**
   *
   * @param apellidos
   */
  public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

  /**
   *
   * @return
   */
  public String getTelefono() {
        return telefono;
    }

  /**
   *
   * @param telefono
   */
  public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

  /**
   *
   * @return
   */
  public String getDireccion() {
        return direccion;
    }

  /**
   *
   * @param direccion
   */
  public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

  /**
   *
   * @return
   */
  public String getEmail() {
        return email;
    }

  /**
   *
   * @param email
   */
  public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
