package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Categorias extends JFrame {

	private JPanel contentPane;
	private JTextField textIdCategoria;
	private JTextField textNombre;
	private JLabel lblDescripcion;
	private JTextField textDescripcion;
	private JTextField textMarca;
	private JTable tableCategorias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categorias frame = new Categorias();
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
	public Categorias() {

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

		Label label = new Label("Categorias");
		label.setBounds(51, 0, 512, 22);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Roboto Black", Font.BOLD, 15));
		contentPane.add(label);

		JLabel lblIdCategoria = new JLabel("Id Categoria");
		lblIdCategoria.setBounds(51, 27, 117, 14);
		lblIdCategoria.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblIdCategoria);

		textIdCategoria = new JTextField();
		textIdCategoria.setFont(new Font("Roboto", Font.PLAIN, 12));
		textIdCategoria.setColumns(10);
		textIdCategoria.setBorder(null);
		textIdCategoria.setBounds(162, 27, 138, 14);
		contentPane.add(textIdCategoria);

		JSeparator separator = new JSeparator();
		separator.setBounds(162, 42, 138, 2);
		contentPane.add(separator);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(51, 53, 117, 14);
		lblNombre.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Roboto", Font.PLAIN, 12));
		textNombre.setColumns(10);
		textNombre.setBorder(null);
		textNombre.setBounds(162, 52, 138, 14);
		contentPane.add(textNombre);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(162, 66, 138, 2);
		contentPane.add(separator_1);

		JLabel lblDescripcion;
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(51, 78, 117, 14);
		lblDescripcion.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblDescripcion);

		textDescripcion = new JTextField();
		textDescripcion.setFont(new Font("Roboto", Font.PLAIN, 12));
		textDescripcion.setColumns(10);
		textDescripcion.setBorder(null);
		textDescripcion.setBounds(162, 78, 138, 12);
		contentPane.add(textDescripcion);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(162, 90, 138, 2);
		contentPane.add(separator_1_1);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(51, 101, 117, 14);
		lblMarca.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		contentPane.add(lblMarca);

		textMarca = new JTextField();
		textMarca.setFont(new Font("Roboto", Font.PLAIN, 12));
		textMarca.setColumns(10);
		textMarca.setBorder(null);
		textMarca.setBounds(162, 103, 138, 11);
		contentPane.add(textMarca);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(162, 114, 138, 2);
		contentPane.add(separator_1_1_1);

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

				int IdCategoria = Integer.parseInt(textIdCategoria.getText());
				String Nombre = textNombre.getText();
				String Descripcion = textDescripcion.getText();
				String Marca = textMarca.getText();

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement(
							"INSERT into categoria(id_categoria,nombre,descripcion,marca) VALUES (?,?,?,?)");

					ps.setInt(1, IdCategoria);
					ps.setString(2, Nombre);
					ps.setString(3, Descripcion);
					ps.setString(4, Marca);

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

				int IdCategoria = Integer.parseInt(textIdCategoria.getText());
				String Nombre = textNombre.getText();
				String Descripcion = textDescripcion.getText();
				String Marca = textMarca.getText();

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement(
							"UPDATE categoria SET nombre=?,descripcion=?,marca=? WHERE id_categoria=?");

					ps.setString(1, Nombre);
					ps.setString(2, Descripcion);
					ps.setString(3, Marca);
					ps.setInt(4, IdCategoria);

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

				int IdCategoria = Integer.parseInt(textIdCategoria.getText());

				try {
					Connection cn = ConexionSQL.Obtenerconexion();
					PreparedStatement ps = cn.prepareStatement("DELETE FROM categoria WHERE id_categoria=?");

					ps.setInt(1, IdCategoria);

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

		JScrollPane scrollPaneCategorias = new JScrollPane();
		scrollPaneCategorias.setWheelScrollingEnabled(false);
		scrollPaneCategorias.setViewportBorder(null);
		scrollPaneCategorias.setVerifyInputWhenFocusTarget(false);
		scrollPaneCategorias.setFocusable(false);
		scrollPaneCategorias.setFocusTraversalKeysEnabled(false);
		scrollPaneCategorias.setEnabled(false);
		scrollPaneCategorias.setBorder(null);
		scrollPaneCategorias.setBounds(29, 231, 623, 98);
		contentPane.add(scrollPaneCategorias);

		tableCategorias = new JTable();
		tableCategorias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {

					int fila = tableCategorias.getSelectedRow();
					int id = Integer.parseInt(tableCategorias.getValueAt(fila, 0).toString());

					PreparedStatement ps;
					ResultSet rs;

					Connection cn = ConexionSQL.Obtenerconexion();
					ps = cn.prepareStatement("SELECT nombre,descripcion,marca FROM categoria WHERE id_categoria=?");

					ps.setInt(1, id);
					rs = ps.executeQuery();

					while (rs.next()) {

						textIdCategoria.setText(String.valueOf(id));
						textNombre.setText(rs.getString("nombre"));
						textDescripcion.setText(rs.getString("descripcion"));
						textMarca.setText(rs.getString("marca"));

					}

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, e1.toString());

				}

			}
		});
		tableCategorias.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id Categoria", "Nombre", "Descipcion", "Marca" }));
		tableCategorias.setToolTipText("");
		tableCategorias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCategorias.setSelectionBackground(Color.WHITE);
		tableCategorias.setFont(new Font("Roboto", Font.PLAIN, 11));
		tableCategorias.setBorder(null);
		tableCategorias.setAutoscrolls(false);
		scrollPaneCategorias.setViewportView(tableCategorias);

		cargarTabla();
	}
	
	/**
	 * limpiar():
	 * 
	 * Este  motodo lo que realiza es dejar las casillas limpias para la nueva inserccion.
	 */
	private void limpiar() {

		textIdCategoria.setText("");
		textNombre.setText("");
		textDescripcion.setText("");
		textMarca.setText("");

	}

	/**
	 * cargarTabla():
	 * 
	 * Este  motodo lo que realiza es cargar la tabla con el contenido que hay en la base de datos.
	 */
	private void cargarTabla() {

		DefaultTableModel modeloTabla = (DefaultTableModel) tableCategorias.getModel();

		modeloTabla.setRowCount(0);

		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;

		int columnas;

		try {
			Connection cn = ConexionSQL.Obtenerconexion();
			ps = cn.prepareStatement("SELECT id_categoria,nombre,descripcion,marca FROM categoria");

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
