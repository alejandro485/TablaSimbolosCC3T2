package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Estructura;

import javax.swing.JLabel;
import javax.swing.JButton;

public class VistaToken extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblNombre;
	private JLabel lblTipo;
	private JLabel lblValorinicial;
	private JLabel lblTamano;

	public VistaToken() {
		setLocationRelativeTo(null);
		setBounds(100, 100, 256, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(false);
		
		lblNombre = new JLabel("nombre");
		lblNombre.setBounds(12, 0, 240, 15);
		contentPane.add(lblNombre);
		
		lblTipo = new JLabel("tipo");
		lblTipo.setBounds(12, 27, 240, 15);
		contentPane.add(lblTipo);
		
		lblValorinicial = new JLabel("Valor inicial");
		lblValorinicial.setBounds(12, 54, 240, 15);
		contentPane.add(lblValorinicial);
		
		lblTamano = new JLabel("tamano");
		lblTamano.setBounds(12, 81, 240, 15);
		contentPane.add(lblTamano);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(61, 114, 117, 25);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
	}
	
	public void setEstructura(Estructura _es, String _nm){
		lblNombre.setText("Nombre: "+_nm);
		lblTipo.setText("Tipo: "+_es.tipo);
		lblValorinicial.setText("Valor inicial: "+_es.valorInicial);
		lblTamano.setText("Longitud: "+_es.getTamano());
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
