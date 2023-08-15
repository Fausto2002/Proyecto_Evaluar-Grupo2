/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author hp
 */
public class Vuelo {
    private int idVuelo;
    private String nombreAerolinea;
    private String origen;
    private String destino;
    private String escala;
    private String disponibilidad;

  /**
   *
   * @return
   */
  public int getIdVuelo() {
        return idVuelo;
    }

  /**
   *
   * @param idVuelo
   */
  public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

  /**
   *
   * @return
   */
  public String getNombreAerolinea() {
        return nombreAerolinea;
    }

  /**
   *
   * @param nombreAerolinea
   */
  public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

  /**
   *
   * @return
   */
  public String getOrigen() {
        return origen;
    }

  /**
   *
   * @param origen
   */
  public void setOrigen(String origen) {
        this.origen = origen;
    }

  /**
   *
   * @return
   */
  public String getDestino() {
        return destino;
    }

  /**
   *
   * @param destino
   */
  public void setDestino(String destino) {
        this.destino = destino;
    }

  /**
   *
   * @return
   */
  public String getEscala() {
        return escala;
    }

  /**
   *
   * @param escala
   */
  public void setEscala(String escala) {
        this.escala = escala;
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
    
}
