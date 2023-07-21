package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ingreso extends JFrame {

	private JPanel contentPane;
	private JTextField textIdIngreso;
	private JTextField textTipoComprobante;
	private JTextField textNumeroComprobante;
	private JTextField textFecha;
	private JTextField textTotal;
	private JTextField textIdUsuario;
	private JTextField textProveedor;
	private JTable tableIngreso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingreso frame = new Ingreso();
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
	public Ingreso() {

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

		Label label = new Label("Ingreso");
		label.setBounds(51, 0, 512, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Roboto Black", Font.BOLD, 15));
		contentPane.add(label);

		JLabel lblIdIngreso = new JLabel("Id Ingreso");
		lblIdIngreso.setBounds(51, 27, 117, 14);
		lblIdIngreso.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblIdIngreso);

		textIdIngreso = new JTextField();
		textIdIngreso.setFont(new Font("Roboto", Font.PLAIN, 12));
		textIdIngreso.setColumns(10);
		textIdIngreso.setBorder(null);
		textIdIngreso.setBounds(162, 28, 138, 14);
		contentPane.add(textIdIngreso);

		JSeparator separator = new JSeparator();
		separator.setBounds(162, 42, 138, 2);
		contentPane.add(separator);

		JLabel lblTipoComprobante = new JLabel("Tipo Comprobante");
		lblTipoComprobante.setBounds(51, 53, 117, 14);
		lblTipoComprobante.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblTipoComprobante);

		textTipoComprobante = new JTextField();
		textTipoComprobante.setFont(new Font("Roboto", Font.PLAIN, 12));
		textTipoComprobante.setColumns(10);
		textTipoComprobante.setBorder(null);
		textTipoComprobante.setBounds(162, 52, 138, 14);
		contentPane.add(textTipoComprobante);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(162, 66, 138, 2);
		contentPane.add(separator_1);

		JLabel lblNumeroComprobante;
		lblNumeroComprobante = new JLabel("Numero Compro");
		lblNumeroComprobante.setBounds(51, 78, 117, 14);
		lblNumeroComprobante.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblNumeroComprobante);

		textNumeroComprobante = new JTextField();
		textNumeroComprobante.setFont(new Font("Roboto", Font.PLAIN, 12));
		textNumeroComprobante.setColumns(10);
		textNumeroComprobante.setBorder(null);
		textNumeroComprobante.setBounds(162, 77, 138, 13);
		contentPane.add(textNumeroComprobante);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(162, 90, 138, 2);
		contentPane.add(separator_1_1);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(51, 101, 117, 14);
		lblFecha.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblFecha);

		textFecha = new JTextField();
		textFecha.setFont(new Font("Roboto", Font.PLAIN, 12));
		textFecha.setColumns(10);
		textFecha.setBorder(null);
		textFecha.setBounds(162, 103, 138, 12);
		contentPane.add(textFecha);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(162, 115, 138, 2);
		contentPane.add(separator_1_1_1);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(51, 126, 117, 14);
		lblTotal.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblTotal);

		textTotal = new JTextField();
		textTotal.setFont(new Font("Roboto", Font.PLAIN, 12));
		textTotal.setColumns(10);
		textTotal.setBorder(null);
		textTotal.setBounds(162, 127, 138, 12);
		contentPane.add(textTotal);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(162, 139, 138, 2);
		contentPane.add(separator_1_1_1_1);

		JLabel lblIdUsuario = new JLabel("Id Usuario");
		lblIdUsuario.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		lblIdUsuario.setBounds(51, 149, 85, 14);
		contentPane.add(lblIdUsuario);

		textIdUsuario = new JTextField();
		textIdUsuario.setFont(new Font("Roboto", Font.PLAIN, 12));
		textIdUsuario.setColumns(10);
		textIdUsuario.setBorder(null);
		textIdUsuario.setBounds(162, 150, 138, 12);
		contentPane.add(textIdUsuario);

		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setBounds(162, 162, 138, 2);
		contentPane.add(separator_1_1_1_1_1);

		JLabel lblIdProveedor = new JLabel("Id Proveedor");
		lblIdProveedor.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		lblIdProveedor.setBounds(51, 174, 117, 14);
		contentPane.add(lblIdProveedor);

		textProveedor = new JTextField();
		textProveedor.setFont(new Font("Roboto", Font.PLAIN, 12));
		textProveedor.setColumns(10);
		textProveedor.setBorder(null);
		textProveedor.setBounds(162, 173, 138, 12);
		contentPane.add(textProveedor);

		JSeparator separator_1_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1_1.setBounds(162, 186, 138, 2);
		contentPane.add(separator_1_1_1_1_1_1);

		// Botones

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			/**
			 * actionPerformed-Insertar():
			 * 
			 * Este metodo lo que realiza es la ensercion de los campos establecidos a la
			 * base de datos para el almacenamiento.
			 * 
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {

				int IdIngreso = Integer.parseInt(textIdIngreso.getText());
				String TipoComprobante = textTipoComprobante.getText();
				String NumeroComprobante = textNumeroComprobante.getText();
				String Fecha = textFecha.getText();
				int Total = Integer.parseInt(textTotal.getText());
				int IdUsuario = Integer.parseInt(textIdUsuario.getText());
				int Proveedor = Integer.parseInt(textProveedor.getText());

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement(
							"INSERT into ingreso(id_ingreso,tipoComprobante,numeroComprobante,fecha,total,id_usuario,id_proveedor) VALUES (?,?,?,?,?,?,?)");

					ps.setInt(1, IdIngreso);
					ps.setString(2, TipoComprobante);
					ps.setString(3, NumeroComprobante);
					ps.setString(4, Fecha);
					ps.setInt(5, Total);
					ps.setInt(6, IdUsuario);
					ps.setInt(7, Proveedor);

					ps.executeUpdate();

					JOptionPane.showMessageDialog(null, "Registro insertado");

					limpiar();

					cargarTabla();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, e1.toString());
				}

			}
		});
		btnInsertar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnInsertar.setBackground(Color.WHITE);
		btnInsertar.setBorder(null);
		btnInsertar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInsertar.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnInsertar.setIcon(new ImageIcon(Proveedores.class.getResource("/com/imagenes/insertar.png")));
		btnInsertar.setBounds(362, 24, 89, 88);
		contentPane.add(btnInsertar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			/**
			 * actionPerformed-Actualizar():
			 * 
			 * Este metodo lo que realiza es la actualizacion de los campos establecidos a
			 * la base de datos para el cambio correspondiente.
			 * 
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {

				int IdIngreso = Integer.parseInt(textIdIngreso.getText());
				String TipoComprobante = textTipoComprobante.getText();
				String NumeroComprobante = textNumeroComprobante.getText();
				String Fecha = textFecha.getText();
				int Total = Integer.parseInt(textTotal.getText());
				int IdUsuario = Integer.parseInt(textIdUsuario.getText());
				int Proveedor = Integer.parseInt(textProveedor.getText());

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement(
							"UPDATE ingreso SET tipoComprobante=?,numeroComprobante=?,fecha=?,total=?,id_usuario=?,id_proveedor=? WHERE id_ingreso=?");

					ps.setString(1, TipoComprobante);
					ps.setString(2, NumeroComprobante);
					ps.setString(3, Fecha);
					ps.setInt(4, Total);
					ps.setInt(5, IdUsuario);
					ps.setInt(6, Proveedor);
					ps.setInt(7, IdIngreso);

					ps.executeUpdate();

					JOptionPane.showMessageDialog(null, "Registro modificado");

					limpiar();

					cargarTabla();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, e1.toString());
				}

			}
		});
		btnActualizar.setIcon(new ImageIcon(Proveedores.class.getResource("/com/imagenes/actualizar-pagina.png")));
		btnActualizar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnActualizar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnActualizar.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnActualizar.setBorder(null);
		btnActualizar.setBackground(Color.WHITE);
		btnActualizar.setBounds(461, 24, 89, 88);
		contentPane.add(btnActualizar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			/**
			 * actionPerformed-Eliminar():
			 * 
			 * Este metodo lo que realiza es la eliminacion solo con la insercion de la
			 * llave primaria y elimina en la base de datos todos los campos
			 * correspondientes a la llave primaria ingresa
			 * 
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {

				int IdIngreso = Integer.parseInt(textIdIngreso.getText());

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement("DELETE FROM ingreso WHERE id_ingreso=?");

					ps.setInt(1, IdIngreso);

					ps.executeUpdate();

					JOptionPane.showMessageDialog(null, "Registro ELIMINADO");

					limpiar();

					cargarTabla();

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, e1.toString());
				}

			}
		});
		btnEliminar.setIcon(new ImageIcon(Proveedores.class.getResource("/com/imagenes/boton-eliminar.png")));
		btnEliminar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminar.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(563, 24, 89, 88);
		contentPane.add(btnEliminar);

		JButton btnRegresar = new JButton("Salir");
		btnRegresar.addActionListener(new ActionListener() {
			/**
			 * actionPerformed-Regresar():
			 * 
			 * Este metodo lo que realiza es poder regresar a la pantalla de inicio.
			 * 
			 * @param e
			 */
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
		btnRegresar.setBounds(372, 114, 89, 88);
		contentPane.add(btnRegresar);

		// Tabla

		JScrollPane scrollPaneIngreso = new JScrollPane();
		scrollPaneIngreso.setWheelScrollingEnabled(false);
		scrollPaneIngreso.setViewportBorder(null);
		scrollPaneIngreso.setVerifyInputWhenFocusTarget(false);
		scrollPaneIngreso.setFocusable(false);
		scrollPaneIngreso.setFocusTraversalKeysEnabled(false);
		scrollPaneIngreso.setEnabled(false);
		scrollPaneIngreso.setBorder(null);
		scrollPaneIngreso.setBounds(29, 236, 623, 151);
		contentPane.add(scrollPaneIngreso);

		tableIngreso = new JTable();
		tableIngreso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {

					int fila = tableIngreso.getSelectedRow();
					int id = Integer.parseInt(tableIngreso.getValueAt(fila, 0).toString());

					PreparedStatement ps;
					ResultSet rs;

					Connection cn = ConexionSQL.Obtenerconexion();
					ps = cn.prepareStatement(
							"SELECT tipoComprobante,numeroComprobante,fecha,total,id_usuario,id_proveedor FROM ingreso WHERE id_ingreso=?");

					ps.setInt(1, id);
					rs = ps.executeQuery();

					while (rs.next()) {

						textIdIngreso.setText(String.valueOf(id));
						textTipoComprobante.setText(rs.getString("tipoComprobante"));
						textNumeroComprobante.setText(rs.getString("numeroComprobante"));
						textFecha.setText(rs.getString("fecha"));
						textTotal.setText(rs.getString("total"));
						textIdUsuario.setText(rs.getString("id_usuario"));
						textProveedor.setText(rs.getString("id_proveedor"));

					}

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, e1.toString());

				}

			}
		});
		tableIngreso.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id Ingreso", "Tipo Comprobante",
				"Numero compro", "Fecha", "Total", "Id Usuario", "Id Proveedor" }));
		tableIngreso.setToolTipText("");
		tableIngreso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableIngreso.setSelectionBackground(Color.WHITE);
		tableIngreso.setFont(new Font("Roboto", Font.PLAIN, 11));
		tableIngreso.setBorder(null);
		tableIngreso.setAutoscrolls(false);
		scrollPaneIngreso.setViewportView(tableIngreso);

		cargarTabla();

	}

	/**
	 * limpiar():
	 * 
	 * Este  motodo lo que realiza es dejar las casillas limpias para la nueva inserccion.
	 */
	private void limpiar() {

		textIdIngreso.setText("");
		textTipoComprobante.setText("");
		textNumeroComprobante.setText("");
		textFecha.setText("");
		textTotal.setText("");
		textIdUsuario.setText("");
		textProveedor.setText("");

	}

	/**
	 * cargarTabla():
	 * 
	 * Este  motodo lo que realiza es cargar la tabla con el contenido que hay en la base de datos.
	 */
	private void cargarTabla() {

		DefaultTableModel modeloTabla = (DefaultTableModel) tableIngreso.getModel();

		modeloTabla.setRowCount(0);

		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;

		int columnas;

		try {
			Connection cn = ConexionSQL.Obtenerconexion();
			ps = cn.prepareStatement(
					"SELECT id_ingreso,tipoComprobante,numeroComprobante,fecha,total,id_usuario,id_proveedor FROM ingreso");

			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			columnas = rsmd.getColumnCount();

			while (rs.next()) {

				Object[] fila = new Object[columnas];

				for (int indice = 0; indice < columnas; indice++) {

					fila[indice] = rs.getObject(indice + 1);

				}

				modeloTabla.addRow(fila);
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.toString());

		}
	}

}
