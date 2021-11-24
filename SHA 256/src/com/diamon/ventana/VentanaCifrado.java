package com.diamon.ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.diamon.cifrado.CifradoSha256;

public class VentanaCifrado extends JFrame implements MouseListener, KeyListener, Runnable {

	private static final long serialVersionUID = 1L;

	private CifradoSha256 cifrar;

	private JButton generarHash;

	private JButton minar;

	private JTextField cajaTexto;

	private JLabel hash;

	private boolean teclaPrecionada = true;

	private JTextField cajaTextoVersion;

	private JTextField cajaTextoHashAnterior;

	private JTextField cajaTextoMerkle;

	private JTextField cajaTextoTiempo;

	private JTextField cajaTextoTamanoBytes;

	private JTextField cajaTextoNonce;

	private JLabel hashValido;

	private boolean minarBloque;

	private JLabel cajaTextoNumeroTrabajo;

	private JPanel panel;

	private boolean clic;

	public VentanaCifrado() {

		super("SHA-256");

		setSize(800, 600);

		setDefaultCloseOperation(VentanaCifrado.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);

		panel = new JPanel();

		panel.setPreferredSize(new Dimension(800, 600));

		panel.setBackground(Color.CYAN);

		// panel.setLayout(new BorderLayout());

		minarBloque = false;

		clic = false;

		cifrar = new CifradoSha256();

		cajaTexto = new JTextField("Texto a Hash", 64);

		hash = new JLabel("Hash:");

		setResizable(false);

		UI();

		panel.add(cajaTexto);

		panel.add(hash);

		add(panel);

		generarHash.addMouseListener(this);

		minar.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent ev) {

				minarBloque = true;

				cifrar.setNumeroDeTrabajo(cifrar.getBinario().hexadecimalDecimal8(cajaTextoNonce.getText()));

				cifrar.setTrabajo(true);

			}

			@Override
			public void mouseEntered(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

		});

		cajaTexto.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent ev) {
				// TODO Auto-generated method stub

				if (!clic) {

					cajaTexto.setText("");
					clic = true;
				}

			}

			@Override
			public void mouseEntered(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent ev) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent ev) {
				// TODO Auto-generated method stub

			}
		});

		new Thread(this).start();

		setVisible(true);

	}

	protected void showStatus(String string) {
		// TODO Auto-generated method stub

	}

	private void UI() {

		cajaTextoVersion = new JTextField("Version en Hex", 8);
		cajaTextoHashAnterior = new JTextField("Hash Anterir en Hex", 64);
		cajaTextoMerkle = new JTextField("Merkle en Hex", 64);
		cajaTextoTiempo = new JTextField("Tiempo en Hex", 8);
		cajaTextoTamanoBytes = new JTextField("Bits en Hex", 8);
		cajaTextoNonce = new JTextField("Nonce en Hex", 8);
		generarHash = new JButton("Generar Hash");
		minar = new JButton("Minar");
		hashValido = new JLabel("Hash Valido:");

		cajaTextoNumeroTrabajo = new JLabel("Numero de Trabajo:");

		// cajaTextoVersion.setBounds(23, 22, 22, 22);

		panel.add(cajaTextoVersion);
		panel.add(cajaTextoHashAnterior);
		panel.add(cajaTextoMerkle);
		panel.add(cajaTextoTiempo);
		panel.add(cajaTextoTamanoBytes);
		panel.add(cajaTextoNonce);
		panel.add(generarHash);
		panel.add(minar);
		panel.add(hashValido);
		panel.add(cajaTextoNumeroTrabajo);

	}

	@Override
	public void mouseClicked(MouseEvent ev) {

		cifrar.setTrabajo(false);

		minarBloque = false;

		String hashGenerado = cifrar.cifrarTextoManualHex(cajaTextoVersion.getText(), cajaTextoHashAnterior.getText(),
				cajaTextoMerkle.getText(), cajaTextoTiempo.getText(), cajaTextoTamanoBytes.getText(),
				cajaTextoNonce.getText());

		hashValido.setText("Hash Valido: " + hashGenerado);

	}

	@Override
	public void mouseEntered(MouseEvent ev) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent ev) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent ev) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent ev) {

	}

	@Override
	public void keyReleased(KeyEvent ev) {

	}

	@Override
	public void keyTyped(KeyEvent ev) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {

		while (teclaPrecionada) {

			String texto = cifrar.cifrarTexto(cajaTexto.getText());

			hash.setText("Hash: " + texto);

			if (minarBloque) {

				String hashGenerado = cifrar.cifrarTextoManualHexValido(cajaTextoVersion.getText(),
						cajaTextoHashAnterior.getText(), cajaTextoMerkle.getText(), cajaTextoTiempo.getText(),
						cajaTextoTamanoBytes.getText());

				hashValido.setText("Hash Valido: " + hashGenerado);

				cajaTextoNumeroTrabajo.setText(
						"Numero de Trabajo:" + cifrar.getBinario().decimalHexadecimal(cifrar.getNumeroDeTrabajo() - 1));

			}

		}

	}

}
