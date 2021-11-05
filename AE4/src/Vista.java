
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;

public class Vista {

	private JFrame frmBiblioteca;
	private JTextArea textArea_Resultado, txtConsulta;
	private JButton btnExecutar, btnEditoriales, btnAutors1950;

	/*mètode: Vista()
	Descripció: Constructor de la classe Vista
	Paràmetres d'entrada: String consulta
	Paràmetres de salida: String texto*/
	public Vista() {
		initialize();
	}
	
	/*metodo: initialize()
	Descripción: instancia els elements y característiques de la vista
	Parámetros de entrada: no
	Parámetros de salida: no*/
	private void initialize() {
		frmBiblioteca = new JFrame();
		frmBiblioteca.setTitle("Biblioteca");
		frmBiblioteca.setBounds(100, 100, 799, 581);
		frmBiblioteca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBiblioteca.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_Original = new JScrollPane(); 
		scrollPane_Original.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_Original.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_Original.setBounds(22, 20, 743, 244);
		frmBiblioteca.getContentPane().add(scrollPane_Original);
		
		textArea_Resultado = new JTextArea();
		textArea_Resultado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textArea_Resultado.setEditable(false);
		textArea_Resultado.setLineWrap(true);
		textArea_Resultado.setRows(12);
		scrollPane_Original.setViewportView(textArea_Resultado);
		scrollPane_Original.getViewport().setView(textArea_Resultado);
		
		btnExecutar = new JButton("Executar");
		btnExecutar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExecutar.setBounds(676, 368, 89, 34);
		frmBiblioteca.getContentPane().add(btnExecutar);
		
		btnEditoriales = new JButton("Editorials amb almenys un llibre en XXI");
		btnEditoriales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditoriales.setBounds(44, 508, 264, 34);
		frmBiblioteca.getContentPane().add(btnEditoriales);
		
		btnAutors1950 = new JButton("Llibres dels autors nascuts abans de 1950");
		btnAutors1950.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAutors1950.setBounds(345, 508, 295, 34);
		frmBiblioteca.getContentPane().add(btnAutors1950);
		
		txtConsulta = new JTextArea();
		txtConsulta.setBounds(22, 287, 644, 210);
		frmBiblioteca.getContentPane().add(txtConsulta);
		
		this.frmBiblioteca.setVisible(true);
	}
	
	/*mètode: getBtnExecutar()
	Descripció: Retorna el botó executar
	Paràmetres d'entrada: no
	Paràmetres de salida: JButton btnExecutar*/
	public JButton getBtnExecutar() {
		return btnExecutar;
	}
	
	/*mètode: getTxtConsulta()
	Descripció: Retorna el JTextArea de consulta
	Paràmetres d'entrada: no
	Paràmetres de salida: JTextArea txtConsulta*/
	public JTextArea getTxtConsulta() {
		return txtConsulta;
	}
	
	/*mètode: getBtnEditoriales()
	Descripció: Retorna el botó que mostra la consulta d'editorials
	Paràmetres d'entrada: no
	Paràmetres de salida: JButton btnEditoriales*/
	public JButton getBtnEditoriales() {
		return btnEditoriales;
	}
	
	/*mètode: getBtnAutors1950()
	Descripció: Retorna el botó que mostra la consulta de llibres segons la dada de naixement dels autors
	Paràmetres d'entrada: no
	Paràmetres de salida: JButton btnAutors1950*/
	public JButton getBtnAutors1950() {
		return btnAutors1950;
	}
	
	/*mètode: getTextAreaResultado()
	Descripció: Retorna el JTextArea de resultat de les consultes
	Paràmetres d'entrada: no
	Paràmetres de salida: JTextArea textArea_Resultado*/
	public JTextArea getTextAreaResultado() {
		return textArea_Resultado;
	}
}
