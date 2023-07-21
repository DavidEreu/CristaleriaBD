package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InicioSA extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSA frame = new InicioSA();
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
	public InicioSA() {
setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel backGround = new JPanel();
		backGround.setBounds(0, 0, 774, 485);
		backGround.setBackground(Color.WHITE);
		contentPane.add(backGround);
		backGround.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Inicio.class.getResource("/com/imagenes/logo.png")));
		lblLogo.setBounds(602, 105, 150, 150);
		backGround.add(lblLogo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Inicio.class.getResource("/com/imagenes/city.png")));
		lblFondo.setBounds(557, -11, 227, 511);
		backGround.add(lblFondo);
		
		
		
		JButton btnProveedores = new JButton("Proveedores");
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
				Proveedores newframe = new Proveedores();
				
					newframe.setVisible(true);
			}
		});
		btnProveedores.setBorder(null);
		btnProveedores.setBorderPainted(false);
		btnProveedores.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnProveedores.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProveedores.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnProveedores.setContentAreaFilled(false);
		btnProveedores.setIcon(new ImageIcon(Inicio.class.getResource("/com/imagenes/repartidor3.png")));
		btnProveedores.setBounds(43, 63, 120, 87);
		backGround.add(btnProveedores);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBorder(null);
		btnSalir.setBorderPainted(false);
		btnSalir.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(WIDTH);
				
			}
		});
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setIcon(new ImageIcon(Inicio.class.getResource("/com/imagenes/regreso.png")));
		btnSalir.setBounds(43, 361, 107, 76);
		backGround.add(btnSalir);
		
		JButton btnArticulo = new JButton("Articulos");
		btnArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Articulos newframe = new Articulos();
				
					newframe.setVisible(true);
		
			}
		});
		btnArticulo.setBorder(null);
		btnArticulo.setBorderPainted(false);
		btnArticulo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnArticulo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnArticulo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnArticulo.setContentAreaFilled(false);
		btnArticulo.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnArticulo.setIcon(new ImageIcon(Inicio.class.getResource("/com/imagenes/libro-de-recetas.png")));
		btnArticulo.setBounds(175, 61, 113, 87);
		backGround.add(btnArticulo);
		
		JButton btnCategoria = new JButton("Categorias");
		btnCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Categorias newframe = new Categorias();
				
					newframe.setVisible(true);
	
			}
		});
		btnCategoria.setBorder(null);
		btnCategoria.setBorderPainted(false);
		btnCategoria.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCategoria.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCategoria.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCategoria.setContentAreaFilled(false);
		btnCategoria.setIcon(new ImageIcon(Inicio.class.getResource("/com/imagenes/categorias.png")));
		btnCategoria.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnCategoria.setBounds(314, 61, 97, 87);
		backGround.add(btnCategoria);
		
		JButton btnDetalleIngreso = new JButton("Detalle Ingreso");
		btnDetalleIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DetalleIngreso newframe = new DetalleIngreso();
				
					newframe.setVisible(true);

			}
		});
		btnDetalleIngreso.setBorder(null);
		btnDetalleIngreso.setBorderPainted(false);
		btnDetalleIngreso.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDetalleIngreso.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDetalleIngreso.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDetalleIngreso.setContentAreaFilled(false);
		btnDetalleIngreso.setIcon(new ImageIcon(Inicio.class.getResource("/com/imagenes/informacion.png")));
		btnDetalleIngreso.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnDetalleIngreso.setBackground(Color.WHITE);
		btnDetalleIngreso.setBounds(241, 196, 120, 97);
		backGround.add(btnDetalleIngreso);
		
		JButton btnIngreso = new JButton("Ingreso");
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ingreso newframe = new Ingreso();
				
					newframe.setVisible(true);

			}
		});
		btnIngreso.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnIngreso.setVerticalAlignment(SwingConstants.BOTTOM);
		btnIngreso.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIngreso.setContentAreaFilled(false);
		btnIngreso.setBorderPainted(false);
		btnIngreso.setBorder(null);
		btnIngreso.setIcon(new ImageIcon(Inicio.class.getResource("/com/imagenes/registro-en-linea.png")));
		btnIngreso.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnIngreso.setBounds(119, 206, 89, 87);
		backGround.add(btnIngreso);
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.setIcon(new ImageIcon(InicioSA.class.getResource("/com/imagenes/history.png")));
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Historial newframe = new Historial();
				
				newframe.setVisible(true);
			}
		});
		btnHistorial.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHistorial.setVerticalAlignment(SwingConstants.BOTTOM);
		btnHistorial.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHistorial.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnHistorial.setContentAreaFilled(false);
		btnHistorial.setBorderPainted(false);
		btnHistorial.setBorder(null);
		btnHistorial.setBackground(Color.WHITE);
		btnHistorial.setBounds(168, 304, 120, 97);
		backGround.add(btnHistorial);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Roboto Black", Font.ITALIC, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(175, 11, 173, 25);
		backGround.add(lblNewLabel);
	}
}
