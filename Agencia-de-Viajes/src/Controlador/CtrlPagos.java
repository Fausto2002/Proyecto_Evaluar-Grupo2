package Controlador;

import static Modelo.Conexion.getConnection;
import Vista.Pagar;
import Vista.frmPagos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Pc
 */
public class CtrlPagos implements ActionListener {
    //Variables
    private final frmPagos frmp;
    private final Pagar p;

  /**
   *
   * @param frmp
   * @param p
   */
  public CtrlPagos(frmPagos frmp, Pagar p) {
        this.frmp = frmp;
        this.p = p;
        this.p.btnPagar.addActionListener(this);
    }
    
  /**
   * Listar las reservas a pagar
   * se ha movido la asignación del modelo de la tabla fuera del bucle while para evitar su sobrescritura repetida. 
   * Esto mejora la eficiencia y claridad del código.
   */
    public void Listar() {
        frmp.tblReservas.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel md = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        frmp.tblReservas.setRowHeight(20);
        JButton BOTONPagar = new JButton("Pagar");
        BOTONPagar.setName("p");

        try (Connection con = getConnection();
             CallableStatement stmt = con.prepareCall("{call listar_reservas_pre_aprobadas(?)}")) {

            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rs = (ResultSet) stmt.getObject(1);

            md.setColumnIdentifiers(new Object[]{"IdReserva", "Cliente", "Cedula", "Hotel", "Habitaciones", "Personas", "Fecha Inicio", "Fecha Fin", "Precio Total", "Estado", "Boton"});

            while (rs.next()) {
                md.addRow(new Object[]{rs.getInt("IdReserva"), rs.getString("Cliente"), rs.getString("Cedula"), rs.getString("Hotel"),
                    rs.getInt("Habitaciones"), rs.getInt("Personas"), rs.getDate("FechaInicio"), rs.getDate("FechaFin"), rs.getDouble("PrecioTotal"), rs.getString("Estado"), BOTONPagar});
            }

            frmp.tblReservas.setModel(md);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
  /**
   *
   * @param e
   */
  @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
