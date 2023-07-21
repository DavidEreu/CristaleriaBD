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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
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

public class DetalleIngreso extends JFrame {

	private JPanel contentPane;
	private JTextField textIdDetalleIngreso;
	private JTextField textCantidad;
	private JTextField textPrecio;
	private JTextField textIdIngreso;
	private JTextField textIdArticulo;
	private JTable tableDetalleIngreso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetalleIngreso frame = new DetalleIngreso();
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
	public DetalleIngreso() {

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

		Label label = new Label("Detalle Ingreso");
		label.setBounds(51, 0, 512, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Roboto Black", Font.BOLD, 15));
		contentPane.add(label);

		JLabel lblDetalleIdIngreso = new JLabel("Id Detalle Ingreso");
		lblDetalleIdIngreso.setBounds(51, 27, 117, 14);
		lblDetalleIdIngreso.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblDetalleIdIngreso);

		textIdDetalleIngreso = new JTextField();
		textIdDetalleIngreso.setFont(new Font("Roboto", Font.PLAIN, 12));
		textIdDetalleIngreso.setColumns(10);
		textIdDetalleIngreso.setBorder(null);
		textIdDetalleIngreso.setBounds(162, 28, 138, 14);
		contentPane.add(textIdDetalleIngreso);

		JSeparator separator = new JSeparator();
		separator.setBounds(162, 42, 138, 2);
		contentPane.add(separator);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(51, 53, 117, 14);
		lblCantidad.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblCantidad);

		textCantidad = new JTextField();
		textCantidad.setFont(new Font("Roboto", Font.PLAIN, 12));
		textCantidad.setColumns(10);
		textCantidad.setBorder(null);
		textCantidad.setBounds(162, 52, 138, 14);
		contentPane.add(textCantidad);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(162, 66, 138, 2);
		contentPane.add(separator_1);

		JLabel lblPrecio;
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(51, 78, 117, 14);
		lblPrecio.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblPrecio);

		textPrecio = new JTextField();
		textPrecio.setFont(new Font("Roboto", Font.PLAIN, 12));
		textPrecio.setColumns(10);
		textPrecio.setBorder(null);
		textPrecio.setBounds(162, 78, 138, 14);
		contentPane.add(textPrecio);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(162, 92, 138, 2);
		contentPane.add(separator_1_1);

		JLabel lblIdIngreso = new JLabel("Id Ingreso");
		lblIdIngreso.setBounds(51, 101, 117, 14);
		lblIdIngreso.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblIdIngreso);

		textIdIngreso = new JTextField();
		textIdIngreso.setFont(new Font("Roboto", Font.PLAIN, 12));
		textIdIngreso.setColumns(10);
		textIdIngreso.setBorder(null);
		textIdIngreso.setBounds(161, 101, 138, 14);
		contentPane.add(textIdIngreso);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(162, 115, 138, 2);
		contentPane.add(separator_1_1_1);

		JLabel lblIdArticulo = new JLabel("Id Articulo");
		lblIdArticulo.setBounds(51, 126, 117, 14);
		lblIdArticulo.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblIdArticulo);

		textIdArticulo = new JTextField();
		textIdArticulo.setFont(new Font("Roboto", Font.PLAIN, 12));
		textIdArticulo.setColumns(10);
		textIdArticulo.setBorder(null);
		textIdArticulo.setBounds(162, 126, 138, 14);
		contentPane.add(textIdArticulo);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(162, 140, 138, 2);
		contentPane.add(separator_1_1_1_1);

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

				int IdDetalleIngreso = Integer.parseInt(textIdDetalleIngreso.getText());
				int Cantidad = Integer.parseInt(textCantidad.getText());
				int Precio = Integer.parseInt(textPrecio.getText());
				int IdIngreso = Integer.parseInt(textIdIngreso.getText());
				int IdArticulo = Integer.parseInt(textIdArticulo.getText());

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement("INSERT into detalleIngreso"
							+ "(id_detalleIngreso,cantidad,precio,id_ingreso,id_articulo) VALUES (?,?,?,?,?)");

					ps.setInt(1, IdDetalleIngreso);
					ps.setInt(2, Cantidad);
					ps.setInt(3, Precio);
					ps.setInt(4, IdIngreso);
					ps.setInt(5, IdArticulo);

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

				int IdDetalleIngreso = Integer.parseInt(textIdDetalleIngreso.getText());
				int Cantidad = Integer.parseInt(textCantidad.getText());
				int Precio = Integer.parseInt(textPrecio.getText());
				int IdIngreso = Integer.parseInt(textIdIngreso.getText());
				int IdArticulo = Integer.parseInt(textIdArticulo.getText());

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement(
							"UPDATE detalleIngreso SET cantidad=?,precio=?,id_ingreso=?,id_articulo=? WHERE id_detalleIngreso=?");

					ps.setInt(1, Cantidad);
					ps.setInt(2, Precio);
					ps.setInt(3, IdIngreso);
					ps.setInt(4, IdArticulo);
					ps.setInt(5, IdDetalleIngreso);

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

				int IdDetalleIngreso = Integer.parseInt(textIdDetalleIngreso.getText());

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement("DELETE FROM detalleIngreso WHERE id_detalleIngreso=?");

					ps.setInt(1, IdDetalleIngreso);

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

		JScrollPane scrollPaneDetalleIngreso = new JScrollPane();
		scrollPaneDetalleIngreso.setWheelScrollingEnabled(false);
		scrollPaneDetalleIngreso.setViewportBorder(null);
		scrollPaneDetalleIngreso.setVerifyInputWhenFocusTarget(false);
		scrollPaneDetalleIngreso.setFocusable(false);
		scrollPaneDetalleIngreso.setFocusTraversalKeysEnabled(false);
		scrollPaneDetalleIngreso.setEnabled(false);
		scrollPaneDetalleIngreso.setBorder(null);
		scrollPaneDetalleIngreso.setBounds(10, 231, 623, 136);
		contentPane.add(scrollPaneDetalleIngreso);

		tableDetalleIngreso = new JTable();
		tableDetalleIngreso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {

					int fila = tableDetalleIngreso.getSelectedRow();
					int id = Integer.parseInt(tableDetalleIngreso.getValueAt(fila, 0).toString());

					PreparedStatement ps;
					ResultSet rs;

					Connection cn = ConexionSQL.Obtenerconexion();
					ps = cn.prepareStatement(
							"SELECT cantidad,precio,id_ingreso,id_articulo FROM detalleIngreso WHERE id_detalleIngreso=?");

					ps.setInt(1, id);
					rs = ps.executeQuery();

					while (rs.next()) {

						textIdDetalleIngreso.setText(String.valueOf(id));
						textCantidad.setText(rs.getString("cantidad"));
						textPrecio.setText(rs.getString("precio"));
						textIdIngreso.setText(rs.getString("id_ingreso"));
						textIdArticulo.setText(rs.getString("id_articulo"));

					}

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, e1.toString());

				}

			}
		});
		tableDetalleIngreso.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id Detalle Ingreso", "Cantidad", "Precio", "Id Ingreso", "Id Articulo" }));
		tableDetalleIngreso.setToolTipText("");
		tableDetalleIngreso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDetalleIngreso.setSelectionBackground(Color.WHITE);
		tableDetalleIngreso.setFont(new Font("Roboto", Font.PLAIN, 11));
		tableDetalleIngreso.setBorder(null);
		tableDetalleIngreso.setAutoscrolls(false);
		scrollPaneDetalleIngreso.setViewportView(tableDetalleIngreso);

		cargarTabla();
	}
	
	/**
	 * limpiar():
	 * 
	 * Este  motodo lo que realiza es dejar las casillas limpias para la nueva inserccion.
	 */
	private void limpiar() {

		textIdDetalleIngreso.setText("");
		textCantidad.setText("");
		textPrecio.setText("");
		textIdIngreso.setText("");
		textIdArticulo.setText("");

	}

	/**
	 * cargarTabla():
	 * 
	 * Este  motodo lo que realiza es cargar la tabla con el contenido que hay en la base de datos.
	 */
	private void cargarTabla() {

		DefaultTableModel modeloTabla = (DefaultTableModel) tableDetalleIngreso.getModel();

		modeloTabla.setRowCount(0);

		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;

		int columnas;

		try {
			Connection cn = ConexionSQL.Obtenerconexion();
			ps = cn.prepareStatement(
					"SELECT id_detalleIngreso,cantidad,precio,id_ingreso,id_articulo FROM detalleIngreso");

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
