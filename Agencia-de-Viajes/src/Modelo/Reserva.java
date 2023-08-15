package Modelo;

import java.util.Date;

/**
 *
 * @author Pc
 */
public class Reserva {

    private int idReserva;
    private Date fechaInicio;
    private Date fechaFin;
    private String hotel;
    private int habitaciones;
    private int personas;
    private String cliente;
    private String cedula;
    private double precioTotal;
    private String estado;

  

    //Setters and getters

  /**
   *
   * @return
   */
    public int getIdReserva() {
        return idReserva;
    }

  /**
   *
   * @param idReserva
   */
  public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

  /**
   *
   * @return
   */
  public Date getFechaInicio() {
        return fechaInicio;
    }

  /**
   *
   * @param fechaInicio
   */
  public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

  /**
   *
   * @return
   */
  public Date getFechaFin() {
        return fechaFin;
    }

  /**
   *
   * @param fechaFin
   */
  public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

  /**
   *
   * @return
   */
  public String getHotel() {
        return hotel;
    }

  /**
   *
   * @param hotel
   */
  public void setHotel(String hotel) {
        this.hotel = hotel;
    }

  /**
   *
   * @return
   */
  public String getCliente() {
        return cliente;
    }

  /**
   *
   * @param cliente
   */
  public void setCliente(String cliente) {
        this.cliente = cliente;
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
  public int getHabitaciones() {
        return habitaciones;
    }

  /**
   *
   * @param habitaciones
   */
  public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

  /**
   *
   * @return
   */
  public int getPersonas() {
        return personas;
    }

  /**
   *
   * @param personas
   */
  public void setPersonas(int personas) {
        this.personas = personas;
    }

  /**
   *
   * @return
   */
  public double getPrecioTotal() {
        return precioTotal;
    }

  /**
   *
   * @param precioTotal
   */
  public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

  /**
   *
   * @return
   */
  public String getEstado() {
        return estado;
    }

  /**
   *
   * @param estado
   */
  public void setEstado(String estado) {
        this.estado = estado;
    }
}
