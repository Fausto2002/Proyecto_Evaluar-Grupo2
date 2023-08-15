
package Modelo;

/**
 *
 * @author hp
 */
public class Hotel {
    
    //Clase Hotel 
    //Variables
    private int idHotel;
     private String nombre;
     private String ubicacion;
     private String telefono;
     private String disponibilidad;
     private String servicios;
     
     //getters and setters

  /**
   *
   * @return
   */

    public int getIdHotel() {
        return idHotel;
    }

  /**
   *
   * @param idHotel
   */
  public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

  /**
   *
   * @return
   */
  public String getNombre() {
        return nombre;
    }

  /**
   *
   * @param nombre
   */
  public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  /**
   *
   * @return
   */
  public String getUbicacion() {
        return ubicacion;
    }

  /**
   *
   * @param ubicacion
   */
  public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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
  public String getDisponibilidad() {
        return disponibilidad;
    }

  /**
   *
   * @param disponibilidad
   */
  public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

  /**
   *
   * @return
   */
  public String getServicios() {
        return servicios;
    }

  /**
   *
   * @param servicios
   */
  public void setServicios(String servicios) {
        this.servicios = servicios;
    }
     
}
