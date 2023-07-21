package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.TextField;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import java.awt.ScrollPane;
import java.awt.Component;
import javax.swing.DropMode;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Proveedores extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdProveedor;
	private JTextField txtNombreCompania;
	private JTextField txtNumeroContacto;
	private JTextField txtNombreContacto;
	private JTextField txtDireccion;
	private JTable tableProveedores;
	private JTextField txtCiudad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proveedores frame = new Proveedores();
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
	public Proveedores() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setResizable(false);
		setAlwaysOnTop(true);
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

		Label label = new Label("Proveedores");
		label.setBounds(51, 0, 512, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Roboto Black", Font.BOLD, 15));
		contentPane.add(label);

		JLabel lblIdProveedor = new JLabel("Id Proveedor");
		lblIdProveedor.setBounds(51, 27, 117, 14);
		lblIdProveedor.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblIdProveedor);

		txtIdProveedor = new JTextField();
		txtIdProveedor.setBounds(162, 27, 138, 14);
		txtIdProveedor.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtIdProveedor.setBorder(null);
		contentPane.add(txtIdProveedor);
		txtIdProveedor.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(162, 42, 138, 2);
		contentPane.add(separator);

		JLabel lblNombreCompania = new JLabel("Nombre Compania");
		lblNombreCompania.setBounds(51, 63, 117, 14);
		lblNombreCompania.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblNombreCompania);

		txtNombreCompania = new JTextField();
		txtNombreCompania.setBounds(162, 63, 138, 14);
		txtNombreCompania.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtNombreCompania.setBorder(null);
		txtNombreCompania.setColumns(10);
		contentPane.add(txtNombreCompania);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(162, 78, 138, 2);
		contentPane.add(separator_1);

		JLabel lblNumeroContacto = new JLabel("Numero Contacto");
		lblNumeroContacto.setBounds(51, 101, 117, 14);
		lblNumeroContacto.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblNumeroContacto);

		txtNumeroContacto = new JTextField();
		txtNumeroContacto.setBounds(162, 98, 138, 14);
		txtNumeroContacto.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtNumeroContacto.setBorder(null);
		txtNumeroContacto.setColumns(10);
		contentPane.add(txtNumeroContacto);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(162, 113, 138, 2);
		contentPane.add(separator_1_1);

		JLabel lblNombreContacto = new JLabel("Nombre Contacto");
		lblNombreContacto.setBounds(51, 137, 117, 14);
		lblNombreContacto.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblNombreContacto);

		txtNombreContacto = new JTextField();
		txtNombreContacto.setBounds(162, 135, 138, 14);
		txtNombreContacto.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtNombreContacto.setColumns(10);
		txtNombreContacto.setBorder(null);
		contentPane.add(txtNombreContacto);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(162, 149, 138, 2);
		contentPane.add(separator_1_1_1);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(51, 172, 117, 14);
		lblDireccion.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(162, 172, 138, 14);
		txtDireccion.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtDireccion.setColumns(10);
		txtDireccion.setBorder(null);
		contentPane.add(txtDireccion);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(162, 186, 138, 2);
		contentPane.add(separator_1_1_1_1);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		lblCiudad.setBounds(51, 201, 117, 14);
		contentPane.add(lblCiudad);

		txtCiudad = new JTextField();
		txtCiudad.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtCiudad.setColumns(10);
		txtCiudad.setBorder(null);
		txtCiudad.setBounds(162, 197, 138, 14);
		contentPane.add(txtCiudad);

		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setBounds(162, 213, 138, 2);
		contentPane.add(separator_1_1_1_1_1);

		// Tabla

		JScrollPane scrollPaneProveedores = new JScrollPane();
		scrollPaneProveedores.addMouseListener(new MouseAdapter() {
		});
		scrollPaneProveedores.setBounds(10, 226, 599, 179);
		scrollPaneProveedores.setEnabled(false);
		scrollPaneProveedores.setFocusTraversalKeysEnabled(false);
		scrollPaneProveedores.setVerifyInputWhenFocusTarget(false);
		scrollPaneProveedores.setViewportBorder(null);
		scrollPaneProveedores.setWheelScrollingEnabled(false);
		scrollPaneProveedores.setFocusable(false);
		scrollPaneProveedores.setBorder(null);
		contentPane.add(scrollPaneProveedores);

		tableProveedores = new JTable();
		tableProveedores.setCellSelectionEnabled(true);
		tableProveedores.setColumnSelectionAllowed(true);
		tableProveedores.setOpaque(false);
		tableProveedores.setVerifyInputWhenFocusTarget(false);
		tableProveedores.setUpdateSelectionOnSort(false);
		tableProveedores.setRowSelectionAllowed(false);
		tableProveedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {

					int fila = tableProveedores.getSelectedRow();
					int id = Integer.parseInt(tableProveedores.getValueAt(fila, 0).toString());

					PreparedStatement ps;
					ResultSet rs;

					Connection cn = ConexionSQL.Obtenerconexion();
					ps = cn.prepareStatement(
							"SELECT nombreCompania,numeroContacto,nombreContacto,direccion,ciudad FROM proveedor WHERE id_proveedor=?");

					ps.setInt(1, id);
					rs = ps.executeQuery();

					while (rs.next()) {

						txtIdProveedor.setText(String.valueOf(id));
						txtNombreCompania.setText(rs.getString("nombreCompania"));
						txtNumeroContacto.setText(rs.getString("numeroContacto"));
						txtNombreContacto.setText(rs.getString("nombreContacto"));
						txtDireccion.setText(rs.getString("direccion"));
						txtCiudad.setText(rs.getString("ciudad"));

					}

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, e1.toString());

				}
			}
		});
		tableProveedores.setAutoscrolls(false);
		tableProveedores.setSelectionBackground(Color.WHITE);
		tableProveedores.setToolTipText("");
		tableProveedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneProveedores.setViewportView(tableProveedores);
		tableProveedores.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id Proveedor",
				"Nombre Compania", "Numero Contacto", "Nombre Contacto", "Direccion", "Ciudad" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, Integer.class, String.class, String.class,
					Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableProveedores.getColumnModel().getColumn(0).setPreferredWidth(96);
		tableProveedores.getColumnModel().getColumn(1).setPreferredWidth(101);
		tableProveedores.getColumnModel().getColumn(2).setPreferredWidth(108);
		tableProveedores.getColumnModel().getColumn(3).setPreferredWidth(95);
		tableProveedores.setFont(new Font("Roboto", Font.PLAIN, 11));
		tableProveedores.setBorder(null);

		cargarTabla();

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

				int IdProveedor = Integer.parseInt(txtIdProveedor.getText());
				String NombreCompania = txtNombreCompania.getText();
				int NumeroContacto = Integer.parseInt(txtNumeroContacto.getText());
				String NombreContacto = txtNombreContacto.getText();
				String Direccion = txtDireccion.getText();
				String Ciudad = txtCiudad.getText();

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement(
							"INSERT into proveedor(id_proveedor,nombreCompania,numeroContacto,nombreContacto,direccion,ciudad) VALUES (?,?,?,?,?,?)");

					ps.setInt(1, IdProveedor);
					ps.setString(2, NombreCompania);
					ps.setInt(3, NumeroContacto);
					ps.setString(4, NombreContacto);
					ps.setString(5, Direccion);
					ps.setString(6, Ciudad);

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

				int IdProveedor = Integer.parseInt(txtIdProveedor.getText());
				String NombreCompania = txtNombreCompania.getText();
				int NumeroContacto = Integer.parseInt(txtNumeroContacto.getText());
				String NombreContacto = txtNombreContacto.getText();
				String Direccion = txtDireccion.getText();
				String Ciudad = txtCiudad.getText();

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement(
							"UPDATE proveedor SET nombreCompania=?,numeroContacto=?,nombreContacto=?,direccion=?,ciudad=? WHERE id_proveedor=?");

					ps.setString(1, NombreCompania);
					ps.setInt(2, NumeroContacto);
					ps.setString(3, NombreContacto);
					ps.setString(4, Direccion);
					ps.setString(5, Ciudad);
					ps.setInt(6, IdProveedor);

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

				int IdProveedor = Integer.parseInt(txtIdProveedor.getText());

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement("DELETE FROM proveedor WHERE id_proveedor=?");

					ps.setInt(1, IdProveedor);

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
				dispose();

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
	}

	/**
	 * limpiar():
	 * 
	 * Este  motodo lo que realiza es dejar las casillas limpias para la nueva inserccion.
	 */
	private void limpiar() {

		txtIdProveedor.setText("");
		txtNombreCompania.setText("");
		txtNumeroContacto.setText("");
		txtNombreContacto.setText("");
		txtDireccion.setText("");
		txtCiudad.setText("");

	}

	/**
	 * cargarTabla():
	 * 
	 * Este  motodo lo que realiza es cargar la tabla con el contenido que hay en la base de datos.
	 */
	private void cargarTabla() {

		DefaultTableModel modeloTabla = (DefaultTableModel) tableProveedores.getModel();

		modeloTabla.setRowCount(0);

		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;

		int columnas;

		try {
			Connection cn = ConexionSQL.Obtenerconexion();
			ps = cn.prepareStatement(
					"SELECT id_proveedor,nombreCompania,numeroContacto,nombreContacto,direccion,ciudad FROM proveedor");

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
