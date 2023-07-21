package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	public JTextField txtUser;
	public JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		interacion();

	}

	public void interacion() {

		JPanel backGround = new JPanel();
		backGround.setBackground(new Color(255, 255, 255));
		backGround.setBounds(0, 0, 677, 423);
		contentPane.add(backGround);
		backGround.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/com/imagenes/logo.png")));
		lblLogo.setBounds(491, 89, 157, 143);
		backGround.add(lblLogo);

		JLabel lblCity = new JLabel("");
		lblCity.setIcon(new ImageIcon(Login.class.getResource("/com/imagenes/city.png")));
		lblCity.setBounds(428, 0, 264, 461);
		backGround.add(lblCity);

		JLabel lbl = new JLabel("");
		lbl.setFont(new Font("Roboto", Font.BOLD, 15));
		lbl.setIcon(new ImageIcon(Login.class.getResource("/com/imagenes/favicon.png")));
		lbl.setBounds(28, 36, 47, 31);
		backGround.add(lbl);

		JLabel lblInicioSesion = new JLabel("INICIAR SESION");
		lblInicioSesion.setFont(new Font("Roboto", Font.BOLD, 20));
		lblInicioSesion.setBounds(28, 89, 202, 14);
		backGround.add(lblInicioSesion);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Roboto", lblUsuario.getFont().getStyle(), 15));
		lblUsuario.setBounds(28, 124, 110, 14);
		backGround.add(lblUsuario);

		txtUser = new JTextField();
		txtUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtUser.getText().equals("Ingrese su nombre de usuario")) {
					txtUser.setText("");
					txtUser.setForeground(Color.black);
				}
				if (String.valueOf(txtPass.getPassword()).isEmpty()) {
					txtPass.setText("●●●●●●●●●●●");
					txtPass.setForeground(Color.gray);
				}
			}
		});

		txtPass = new JPasswordField();
		txtPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(txtPass.getPassword()).equals("●●●●●●●●●●●")) {
					txtPass.setText("");
					txtPass.setForeground(Color.black);
				}
				if (txtUser.getText().isEmpty()) {
					txtUser.setText("Ingrese su nombre de usuario");
					txtUser.setForeground(Color.gray);
				}
			}
		});
		txtUser.setBorder(null);
		txtUser.setFont(new Font("Roboto", txtUser.getFont().getStyle(), 11));
		txtUser.setForeground(Color.LIGHT_GRAY);
		txtUser.setText("Ingrese su nombre de usuario");
		txtUser.setBounds(28, 149, 264, 20);
		backGround.add(txtUser);
		txtUser.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		separator.setAlignmentX(Component.LEFT_ALIGNMENT);
		separator.setToolTipText("");
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(28, 180, 264, 2);
		backGround.add(separator);

		JLabel lblContrasena = new JLabel("CONTRASENA");
		lblContrasena.setFont(new Font("Roboto", lblContrasena.getFont().getStyle(), 15));
		lblContrasena.setBounds(28, 216, 110, 14);
		backGround.add(lblContrasena);

		txtPass.setText("●●●●●●●●●●●");
		txtPass.setToolTipText("");
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPass.setForeground(Color.LIGHT_GRAY);
		txtPass.setBorder(null);
		txtPass.setBounds(28, 241, 264, 20);
		backGround.add(txtPass);

		JSeparator separator2 = new JSeparator();
		separator2.setToolTipText("");
		separator2.setForeground(Color.BLACK);
		separator2.setBackground(Color.BLACK);
		separator2.setAlignmentY(1.0f);
		separator2.setAlignmentX(0.0f);
		separator2.setBounds(28, 269, 264, 2);
		backGround.add(separator2);

		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBorder(null);
		btnEntrar.setBorderPainted(false);
		btnEntrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEntrar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEntrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEntrar.setContentAreaFilled(false);
		btnEntrar.setIcon(new ImageIcon(Login.class.getResource("/com/imagenes/iniciar-sesion.png")));
		btnEntrar.setFont(new Font("Roboto", Font.BOLD, 13));
		btnEntrar.setBackground(new Color(0, 191, 255));
		btnEntrar.addActionListener(new ActionListener() {
			/**
			 * actionPerformed-Entrar():
			 * 
			 * Este metodo lo que realiza es el que realiza la comprobacion de user y pass, para la comprobacion.
			 */
			public void actionPerformed(ActionEvent e) {

			     if (txtUser.getText().equals("David ereu") && txtPass.getText().equals("1212")) {
			    	 
			    	dispose();       	
			        JOptionPane.showMessageDialog(null, "Login exitoso, bienvenido "+ "David ereu");
			        InicioSA ini = new InicioSA();
			        ini.setVisible(true);
			                   
			        } else {
			        	
			        	dispose(); 
			        	JOptionPane.showMessageDialog(null, "Login exitoso bienvenido");
				        Inicio ini = new Inicio();
				        ini.setVisible(true);

			        } 
	
			}		
		});
		btnEntrar.setBounds(28, 282, 110, 96);
		backGround.add(btnEntrar);

	}
}
