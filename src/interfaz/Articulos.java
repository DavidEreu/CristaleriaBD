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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Articulos extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdArticulo;
	private JTextField txtCodigo;
	private JTextField textNombre;
	private JTextField textPrecioVenta;
	private JTextField textDescripcion;
	private JTextField textStock;
	private JTextField textIdCategoria;
	private JTable tableArticulos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Articulos frame = new Articulos();
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
	public Articulos() {

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

		Label label = new Label("Articulos");
		label.setBounds(51, 0, 512, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Roboto Black", Font.BOLD, 15));
		contentPane.add(label);

		JLabel lblIdArticulo = new JLabel("Id Articulo");
		lblIdArticulo.setBounds(51, 27, 117, 14);
		lblIdArticulo.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblIdArticulo);

		txtIdArticulo = new JTextField();
		txtIdArticulo.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtIdArticulo.setColumns(10);
		txtIdArticulo.setBorder(null);
		txtIdArticulo.setBounds(162, 27, 138, 14);
		contentPane.add(txtIdArticulo);

		JSeparator separator = new JSeparator();
		separator.setBounds(162, 42, 138, 2);
		contentPane.add(separator);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(51, 53, 117, 14);
		lblCodigo.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtCodigo.setColumns(10);
		txtCodigo.setBorder(null);
		txtCodigo.setBounds(162, 52, 138, 14);
		contentPane.add(txtCodigo);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(162, 66, 138, 2);
		contentPane.add(separator_1);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(51, 78, 117, 14);
		lblNombre.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Roboto", Font.PLAIN, 12));
		textNombre.setColumns(10);
		textNombre.setBorder(null);
		textNombre.setBounds(162, 76, 138, 14);
		contentPane.add(textNombre);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(162, 90, 138, 2);
		contentPane.add(separator_1_1);

		JLabel lblPrecioVenta = new JLabel("Precio Venta");
		lblPrecioVenta.setBounds(51, 101, 117, 14);
		lblPrecioVenta.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblPrecioVenta);

		textPrecioVenta = new JTextField();
		textPrecioVenta.setFont(new Font("Roboto", Font.PLAIN, 12));
		textPrecioVenta.setColumns(10);
		textPrecioVenta.setBorder(null);
		textPrecioVenta.setBounds(162, 101, 138, 12);
		contentPane.add(textPrecioVenta);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(162, 114, 138, 2);
		contentPane.add(separator_1_1_1);

		JLabel lblDescripcion = new JLabel("Descipcion ");
		lblDescripcion.setBounds(51, 126, 117, 14);
		lblDescripcion.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblDescripcion);

		textDescripcion = new JTextField();
		textDescripcion.setFont(new Font("Roboto", Font.PLAIN, 12));
		textDescripcion.setColumns(10);
		textDescripcion.setBorder(null);
		textDescripcion.setBounds(162, 126, 138, 12);
		contentPane.add(textDescripcion);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(162, 138, 138, 2);
		contentPane.add(separator_1_1_1_1);

		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		lblStock.setBounds(51, 149, 43, 14);
		contentPane.add(lblStock);

		textStock = new JTextField();
		textStock.setFont(new Font("Roboto", Font.PLAIN, 12));
		textStock.setColumns(10);
		textStock.setBorder(null);
		textStock.setBounds(162, 151, 138, 11);
		contentPane.add(textStock);

		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setBounds(162, 162, 138, 2);
		contentPane.add(separator_1_1_1_1_1);

		JLabel lblIdCategoria = new JLabel("Id Categoria");
		lblIdCategoria.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		lblIdCategoria.setBounds(51, 174, 117, 14);
		contentPane.add(lblIdCategoria);

		textIdCategoria = new JTextField();
		textIdCategoria.setFont(new Font("Roboto", Font.PLAIN, 12));
		textIdCategoria.setColumns(10);
		textIdCategoria.setBorder(null);
		textIdCategoria.setBounds(162, 173, 138, 11);
		contentPane.add(textIdCategoria);

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

				int IdArticulo = Integer.parseInt(txtIdArticulo.getText());
				String Codigo = txtCodigo.getText();
				String Nombre = textNombre.getText();
				int PrecioVenta = Integer.parseInt(textPrecioVenta.getText());
				String Descripcion = textDescripcion.getText();
				int Stock = Integer.parseInt(textStock.getText());
				int IdCategoria = Integer.parseInt(textIdCategoria.getText());

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement("INSERT into articulo(id_articulo,codigo,nombre,"
							+ "precioVenta,descripcion,stock,id_categoria) VALUES (?,?,?,?,?,?,?)");

					ps.setInt(1, IdArticulo);
					ps.setString(2, Codigo);
					ps.setString(3, Nombre);
					ps.setInt(4, PrecioVenta);
					ps.setString(5, Descripcion);
					ps.setInt(6, Stock);
					ps.setInt(7, IdCategoria);

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

				int IdArticulo = Integer.parseInt(txtIdArticulo.getText());
				String Codigo = txtCodigo.getText();
				String Nombre = textNombre.getText();
				int PrecioVenta = Integer.parseInt(textPrecioVenta.getText());
				String Descripcion = textDescripcion.getText();
				int Stock = Integer.parseInt(textStock.getText());
				int IdCategoria = Integer.parseInt(textIdCategoria.getText());

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement(
							"UPDATE articulo SET codigo=?,nombre=?,precioVenta=?,descripcion=?,stock=?,id_categoria=? WHERE id_articulo=?");

					ps.setString(1, Codigo);
					ps.setString(2, Nombre);
					ps.setInt(3, PrecioVenta);
					ps.setString(4, Descripcion);
					ps.setInt(5, Stock);
					ps.setInt(6, IdCategoria);
					ps.setInt(7, IdArticulo);

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

				int IdArticulo = Integer.parseInt(txtIdArticulo.getText());

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement("DELETE FROM articulo WHERE id_articulo=?");

					ps.setInt(1, IdArticulo);

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

		JScrollPane scrollPaneArticulos = new JScrollPane();
		scrollPaneArticulos.setWheelScrollingEnabled(false);
		scrollPaneArticulos.setViewportBorder(null);
		scrollPaneArticulos.setVerifyInputWhenFocusTarget(false);
		scrollPaneArticulos.setFocusable(false);
		scrollPaneArticulos.setFocusTraversalKeysEnabled(false);
		scrollPaneArticulos.setEnabled(false);
		scrollPaneArticulos.setBorder(null);
		scrollPaneArticulos.setBounds(29, 213, 623, 151);
		contentPane.add(scrollPaneArticulos);

		tableArticulos = new JTable();
		tableArticulos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {

					int fila = tableArticulos.getSelectedRow();
					int id = Integer.parseInt(tableArticulos.getValueAt(fila, 0).toString());

					PreparedStatement ps;
					ResultSet rs;

					Connection cn = ConexionSQL.Obtenerconexion();
					ps = cn.prepareStatement(
							"SELECT codigo,nombre,precioVenta,descripcion,stock,id_categoria FROM articulo WHERE id_articulo=?");

					ps.setInt(1, id);
					rs = ps.executeQuery();

					while (rs.next()) {

						txtIdArticulo.setText(String.valueOf(id));
						txtCodigo.setText(rs.getString("codigo"));
						textNombre.setText(rs.getString("nombre"));
						textPrecioVenta.setText(rs.getString("precioVenta"));
						textDescripcion.setText(rs.getString("descripcion"));
						textStock.setText(rs.getString("stock"));
						textIdCategoria.setText(rs.getString("id_categoria"));

					}

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, e1.toString());

				}
			}
		});
		tableArticulos.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id Articulo", "Codigo",
				"Nombre", "Precio Venta", "Descripcion", "Stock", "Id Categoria" }));
		tableArticulos.getColumnModel().getColumn(0).setPreferredWidth(69);
		tableArticulos.getColumnModel().getColumn(1).setPreferredWidth(66);
		tableArticulos.getColumnModel().getColumn(2).setPreferredWidth(62);
		tableArticulos.getColumnModel().getColumn(3).setPreferredWidth(71);
		tableArticulos.getColumnModel().getColumn(4).setPreferredWidth(121);
		tableArticulos.setToolTipText("");
		tableArticulos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableArticulos.setSelectionBackground(Color.WHITE);
		tableArticulos.setFont(new Font("Roboto", Font.PLAIN, 11));
		tableArticulos.setBorder(null);
		tableArticulos.setAutoscrolls(false);
		scrollPaneArticulos.setViewportView(tableArticulos);

		cargarTabla();

	}
	/**
	 * limpiar():
	 * 
	 * Este  motodo lo que realiza es dejar las casillas limpias para la nueva inserccion.
	 */
	private void limpiar() {

		txtIdArticulo.setText("");
		txtCodigo.setText("");
		textNombre.setText("");
		textPrecioVenta.setText("");
		textDescripcion.setText("");
		textStock.setText("");
		textIdCategoria.setText("");

	}
	
	/**
	 * cargarTabla():
	 * 
	 * Este  motodo lo que realiza es cargar la tabla con el contenido que hay en la base de datos.
	 */
	private void cargarTabla() {

		DefaultTableModel modeloTabla = (DefaultTableModel) tableArticulos.getModel();

		modeloTabla.setRowCount(0);

		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;

		int columnas;

		try {
			Connection cn = ConexionSQL.Obtenerconexion();
			ps = cn.prepareStatement(
					"SELECT id_articulo,codigo,nombre,precioVenta,descripcion,stock,id_categoria FROM articulo");

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
