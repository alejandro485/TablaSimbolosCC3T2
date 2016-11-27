package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logica.*;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class EntradaDatos extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtValorinicial;
	private JTable tbTokens;
	private JComboBox<String> cbxTipo;
	private TablaSimbolos ts;
	private VistaToken vt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntradaDatos frame = new EntradaDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EntradaDatos() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(110, 12, 114, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		cbxTipo = new JComboBox<String>();
		cbxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"int", "float", "char", "string", "boolean"}));
		cbxTipo.setBounds(110, 42, 114, 24);
		contentPane.add(cbxTipo);
		
		txtValorinicial = new JTextField();
		txtValorinicial.setBackground(Color.WHITE);
		txtValorinicial.setToolTipText("");
		txtValorinicial.setBounds(110, 78, 114, 19);
		contentPane.add(txtValorinicial);
		txtValorinicial.setColumns(10);
		
		tbTokens = new JTable();
		tbTokens.setBackground(SystemColor.text);
		tbTokens.setBounds(236, 14, 484, 217);
		contentPane.add(tbTokens);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(22, 14, 70, 15);
		contentPane.add(lblNombre);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(22, 47, 70, 15);
		contentPane.add(lblTipo);
		
		JLabel lblInicializado = new JLabel("Inicializado");
		lblInicializado.setBounds(22, 80, 89, 15);
		contentPane.add(lblInicializado);
		
		JButton btnAgregar = new JButton("Agregar token");
		btnAgregar.setBounds(22, 109, 202, 25);
		btnAgregar.setActionCommand("a");
		btnAgregar.addActionListener(this);
		contentPane.add(btnAgregar);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setBounds(22, 146, 202, 25);
		btnVisualizar.setActionCommand("v");
		btnVisualizar.addActionListener(this);
		contentPane.add(btnVisualizar);
		
		JButton btnResetearLista = new JButton("Resetear Lista");
		btnResetearLista.setBounds(22, 183, 202, 25);
		btnResetearLista.setActionCommand("r");
		btnResetearLista.addActionListener(this);
		contentPane.add(btnResetearLista);
		
		ts=new TablaSimbolos();
		vt=new VistaToken();
	}
	
	private void pintarTabla(){
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("nombre");
		model.addColumn("tipo");
		model.addColumn("valor");
		model.addColumn("tamano");
		model.addColumn("Direccion");
		model.addRow(new Object[]{"Nombre","Tipo" ,"Valor" ,"Bytes" ,"Direccion"});
		for (Map.Entry<String, Estructura> entry : ts.lista.entrySet()) {
			model.addRow(new Object[]{entry.getKey(), entry.getValue().tipo, entry.getValue().valorInicial, entry.getValue().getTamano(), entry.getValue().hashCode()});
		}
		tbTokens.setModel(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="a"){
			ts.agregarToken(txtNombre.getText(), cbxTipo.getSelectedItem().toString() , txtValorinicial.getText());
			pintarTabla();
			txtNombre.setText("");
			txtValorinicial.setText("");
		}
		if(e.getActionCommand()=="v"){
			if(ts.buscarToken(txtNombre.getText())){
				vt.setEstructura(ts.lista.get(txtNombre.getText()), txtNombre.getText());
			}
			else{
				JOptionPane.showMessageDialog(this, "No esta listado dicho token");
			}
		}
		if(e.getActionCommand()=="r"){
			ts.resetearLista();
			pintarTabla();
			txtNombre.setText("");
			txtValorinicial.setText("");
		}
	}
}
