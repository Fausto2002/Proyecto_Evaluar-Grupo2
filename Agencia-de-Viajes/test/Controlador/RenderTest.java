
package Controlador;

import javax.swing.JButton;
import javax.swing.JTable;
import org.junit.Test;

/**
 *
 * @author hp
 */
public class RenderTest {
    JTable table;
    Object value;
    boolean isSelected;
    boolean hasFocus;
    int row;
    int column;

  /**
   * vista
   */
  public RenderTest() {
    }

  /**
   * accion del boton
   */
  @Test
    public void testGetTableCellRendererComponent() {
         if (value instanceof JButton) {
            JButton btn= (JButton)value;
        }
    }
    
}
