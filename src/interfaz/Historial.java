package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Historial extends JFrame {

	private JPanel contentPane;
	private JTable tableHistorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Historial frame = new Historial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Historial() {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 940, 530);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Roboto", Font.PLAIN, 12));
		contentPane.setRequestFocusEnabled(false);
		contentPane.setInheritsPopupMenu(true);
		contentPane.setIgnoreRepaint(true);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(722, 114, 163, 151);
		lblLogo.setIcon(new ImageIcon(Proveedores.class.getResource("/com/imagenes/logo.png")));
		contentPane.add(lblLogo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(662, -33, 262, 563);
		lblFondo.setIcon(new ImageIcon(Proveedores.class.getResource("/com/imagenes/city.png")));
		contentPane.add(lblFondo);
		
		Label label = new Label("Historial");
		label.setBounds(51, 0, 512, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Roboto Black", Font.BOLD, 15));
		contentPane.add(label);
		
		JButton btnRegresar = new JButton("Salir");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Inicio ini = new Inicio();
		        ini.setVisible(true);
				
			}
		});
		btnRegresar.setIcon(new ImageIcon(Proveedores.class.getResource("/com/imagenes/regreso.png")));
		btnRegresar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRegresar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegresar.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnRegresar.setBorder(null);
		btnRegresar.setBackground(Color.WHITE);
		btnRegresar.setBounds(20, 287, 89, 88);
		contentPane.add(btnRegresar);
		
		JScrollPane scrollPaneArticulos = new JScrollPane();
		scrollPaneArticulos.setWheelScrollingEnabled(false);
		scrollPaneArticulos.setViewportBorder(null);
		scrollPaneArticulos.setVerifyInputWhenFocusTarget(false);
		scrollPaneArticulos.setFocusable(false);
		scrollPaneArticulos.setFocusTraversalKeysEnabled(false);
		scrollPaneArticulos.setEnabled(false);
		scrollPaneArticulos.setBorder(null);
		scrollPaneArticulos.setBounds(20, 114, 623, 151);
		contentPane.add(scrollPaneArticulos);
		
		tableHistorial = new JTable();
		tableHistorial.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fecha", "Descripcion", "Usuario"
			}
		));
		tableHistorial.getColumnModel().getColumn(0).setPreferredWidth(104);
		tableHistorial.getColumnModel().getColumn(1).setPreferredWidth(109);
		tableHistorial.setToolTipText("");
		tableHistorial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableHistorial.setSelectionBackground(Color.WHITE);
		tableHistorial.setFont(new Font("Roboto", Font.PLAIN, 11));
		tableHistorial.setBorder(null);
		tableHistorial.setAutoscrolls(false);
		scrollPaneArticulos.setViewportView(tableHistorial);
		cargarTabla();
	}
	private void cargarTabla() {
		
		DefaultTableModel modeloTabla=(DefaultTableModel) tableHistorial.getModel();
		
		modeloTabla.setRowCount(0);
		
		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;
		
		int columnas;
		
		try {
			Connection cn = ConexionSQL.Obtenerconexion();
			ps = cn.prepareStatement("SELECT fecha,descripcion,usuario FROM HISTORIAL");
			
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			columnas = rsmd.getColumnCount();
			
			while(rs.next()) {
				
				Object[] fila = new Object[columnas];
				
				for(int indice=0; indice<columnas; indice++) {
					
					fila[indice] = rs.getObject(indice + 1);
					
				}
				
				modeloTabla.addRow(fila);
			}
			
		}catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, e.toString());
			
		}
	}
}
