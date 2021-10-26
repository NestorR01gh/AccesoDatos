
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

	private JFrame frame;
	private JTextField txtId;
	private JButton btnMostrar, btnBorrar;
	private JTextArea textArea_Libros;
	private JTextArea textArea_MostrarLibro;
	private JTextField txtId2;
	private JTextField txtTitol;
	private JTextField txtAutor;
	private JTextField txtEditorial;
	private JTextField txtNumPags;
	private JButton btnCrear, btnActualitzar;
	private JTextField txtAnyPubl;
	private JLabel lblAnyPubl, lbl_Id, lblTitol, lblAutor, lblEditorial, lblNumPags;

	
	public Vista() {
		initialize();
	}
	
	/*metodo: initialize()
	Descripción: instancia los elementos y características de la vista
	Parámetros de entrada: no
	Parámetros de salida: no*/
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 799, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_Original = new JScrollPane(); 
		scrollPane_Original.setBounds(22, 20, 743, 222);
		frame.getContentPane().add(scrollPane_Original);
		
		textArea_Libros = new JTextArea();
		textArea_Libros.setEditable(false);
		textArea_Libros.setLineWrap(true);
		textArea_Libros.setRows(12);
		scrollPane_Original.setColumnHeaderView(textArea_Libros);
		scrollPane_Original.getViewport().setView(textArea_Libros);
		
		txtId = new JTextField();
		txtId.setText("id (1, 2...)");
		txtId.setBounds(55, 271, 132, 27);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMostrar.setBounds(197, 253, 78, 27);
		frame.getContentPane().add(btnMostrar);
		
		JScrollPane scrollPane_Modificado = new JScrollPane();
		scrollPane_Modificado.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_Modificado.setBounds(55, 325, 220, 196);
		frame.getContentPane().add(scrollPane_Modificado);
		
		textArea_MostrarLibro = new JTextArea();
		textArea_MostrarLibro.setEditable(false);
		textArea_MostrarLibro.setLineWrap(true);
		textArea_MostrarLibro.setRows(8);
		scrollPane_Modificado.setViewportView(textArea_MostrarLibro);
		scrollPane_Modificado.getViewport().setView(textArea_MostrarLibro);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(197, 287, 78, 27);
		frame.getContentPane().add(btnBorrar);
		
		btnActualitzar = new JButton("Actualitzar");
		btnActualitzar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnActualitzar.setBounds(473, 487, 99, 34);
		frame.getContentPane().add(btnActualitzar);
		
		txtId2 = new JTextField();
		txtId2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtId2.setBounds(457, 269, 249, 23);
		frame.getContentPane().add(txtId2);
		txtId2.setColumns(10);
		
		txtTitol = new JTextField();
		txtTitol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTitol.setColumns(10);
		txtTitol.setBounds(457, 303, 249, 23);
		frame.getContentPane().add(txtTitol);
		
		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAutor.setColumns(10);
		txtAutor.setBounds(457, 337, 249, 23);
		frame.getContentPane().add(txtAutor);
		
		txtEditorial = new JTextField();
		txtEditorial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEditorial.setColumns(10);
		txtEditorial.setBounds(457, 403, 249, 23);
		frame.getContentPane().add(txtEditorial);
		
		txtNumPags = new JTextField();
		txtNumPags.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumPags.setColumns(10);
		txtNumPags.setBounds(457, 437, 249, 23);
		frame.getContentPane().add(txtNumPags);
		
		btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCrear.setBounds(604, 487, 89, 34);
		frame.getContentPane().add(btnCrear);
		
		lbl_Id = new JLabel("Id: ");
		lbl_Id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_Id.setBounds(428, 275, 19, 14);
		frame.getContentPane().add(lbl_Id);
		
		lblTitol = new JLabel("T\u00EDtol:  ");
		lblTitol.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitol.setBounds(415, 312, 36, 14);
		frame.getContentPane().add(lblTitol);
		
		lblAutor = new JLabel("Autor:  ");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAutor.setBounds(408, 341, 43, 14);
		frame.getContentPane().add(lblAutor);
		
		lblEditorial = new JLabel("Editorial:  ");
		lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEditorial.setBounds(396, 407, 55, 14);
		frame.getContentPane().add(lblEditorial);
		
		lblNumPags = new JLabel("Nombre pags:");
		lblNumPags.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumPags.setBounds(369, 441, 78, 14);
		frame.getContentPane().add(lblNumPags);
		
		txtAnyPubl = new JTextField();
		txtAnyPubl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAnyPubl.setColumns(10);
		txtAnyPubl.setBounds(457, 371, 249, 23);
		frame.getContentPane().add(txtAnyPubl);
		
		lblAnyPubl = new JLabel("Any publicaci\u00F3:  ");
		lblAnyPubl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAnyPubl.setBounds(358, 375, 89, 14);
		frame.getContentPane().add(lblAnyPubl);
		
		this.frame.setVisible(true);
	}
	
	public JButton getBtnMostrar() {
		return btnMostrar;
	}


	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	
	public JButton getBtnCrear() {
		return btnCrear;
	}
	
	public JButton getBtnActualitzar() {
		return btnActualitzar;
	}
	
	public JTextField getTextFieldId() {
		return txtId;
	}

	public JTextArea getTextAreaLibros() {
		return textArea_Libros;
	}

	public JTextArea getTextAreaMostrarLibro() {
		return textArea_MostrarLibro;
	}
	
	public JTextField getTxtId2() {
		return txtId2;
	}
	
	public JTextField getTxtTitol() {
		return txtTitol;
	}
	
	public JTextField getTxtAutor() {
		return txtAutor;
	}
	
	public JTextField getTxtAnyPubl() {
		return txtAnyPubl;
	}
	
	public JTextField getTxtEditorial() {
		return txtEditorial;
	}
	
	public JTextField getTxtNumPags() {
		return txtNumPags;
	}
}
