import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Controlador {
	private Vista vista;
	private Modelo modelo;
	
	public Controlador(Vista vsta, Modelo mdlo) throws IOException, InterruptedException {
		vista = vsta;
		modelo = mdlo;
		initEventHandlers();
		vista.getTextAreaOriginal().setText(modelo.getText(modelo.getArch()));
	}
	
	public void initEventHandlers() {
		vista.getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "La palabra se repite: " + modelo.getRepetidos(vista.getTextFieldBuscar().getText()) + " veces", "BUSCAR", JOptionPane.INFORMATION_MESSAGE);
				vista.getTextFieldBuscar().setText("");
			}
		});
		vista.getBtnReemplazar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.reemplazar(vista.getTextFieldBuscar().getText(), vista.getTextFieldReemplazar().getText());
				try {
					vista.getTextAreaModificado().setText(modelo.getText(modelo.getModArch()));
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
				vista.getTextFieldBuscar().setText("");
				vista.getTextFieldReemplazar().setText("");
			}
		});
	}
}
