package com.diamon.cifrado;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


import com.diamon.minado.Binarios;

public class CifradoSha256 {

	private boolean trabajo;

	private int numeroDeTrabajo;

	private Binarios binario;

	private StringBuilder has;

	public CifradoSha256() {

		
		
		numeroDeTrabajo = 0;

		trabajo = false;

		has = new StringBuilder();

		binario = new Binarios();
	}

	public String obtenerMerkle(String[] textos) {

		if (textos.length == 1) {

			return textos[0];

		}

		ArrayList<String> textosHashLista = new ArrayList<String>();

		for (int i = 0; i < textos.length - 1; i += 2) {

			textosHashLista.add(cifrarTransiciones(textos[i], textos[i + 1]));

		}

		if (textos.length % 2 == 1) {

			textosHashLista.add(cifrarTransiciones(textos[textos.length - 1], textos[textos.length - 1]));

		}

		String[] textosHash = new String[textosHashLista.size()];

		for (int i = 0; i < textosHash.length; i++) {

			textosHash[i] = textosHashLista.get(i);
		}

		return obtenerMerkle(textosHash);

	}

	public String cifrarTransiciones(String texto1, String texto2) {

		MessageDigest codigo = null;

		byte[] cabecera = new byte[texto1.length() / 2 + texto2.length() / 2];

		byte[] a = binario.bytesInvertidos(texto1);

		byte[] b = binario.bytesInvertidos(texto2);

		int indice = 0;

		for (int i = 0; i < a.length; i++) {

			cabecera[indice] = a[i];

			indice++;

		}

		for (int i = 0; i < b.length; i++) {

			cabecera[indice] = b[i];

			indice++;

		}

		try {
			codigo = MessageDigest.getInstance("SHA-256");

		} catch (NoSuchAlgorithmException e) {

			return "No existe";
		}

		byte[] hash = codigo.digest(codigo.digest(cabecera));

		StringBuilder cifrado = new StringBuilder();

		for (byte bit : hash) {

			cifrado.append(String.format("%02x", bit));

		}

		StringBuilder[] datos = new StringBuilder[cifrado.toString().length() / 2];

		for (int i = 0; i < datos.length; i++) {

			datos[i] = new StringBuilder();

		}

		int in = 0;

		for (int i = 0; i < datos.length; i++) {

			datos[i].append(cifrado.toString().charAt(in));

			in++;

			datos[i].append(cifrado.toString().charAt(in));

			in++;

		}

		StringBuilder invertir = new StringBuilder();

		for (int i = datos.length - 1; i >= 0; i--) {

			invertir.append(datos[i].toString());

		}

		return invertir.toString();

	}

	public String cifrarTextoPrueba(String texto) {

		MessageDigest codigo = null;

		try {
			codigo = MessageDigest.getInstance("SHA-256");

		} catch (NoSuchAlgorithmException e) {

			return "No existe";
		}

		byte[] bytes = binario.bytesInvertidos(texto);

		byte[] hash = codigo.digest(codigo.digest(bytes));

		StringBuilder cifrado = new StringBuilder();

		for (byte bit : hash) {

			cifrado.append(String.format("%02x", bit));

		}

		StringBuilder[] datos = new StringBuilder[cifrado.toString().length() / 2];

		for (int i = 0; i < datos.length; i++) {

			datos[i] = new StringBuilder();

		}

		int in = 0;

		for (int i = 0; i < datos.length; i++) {

			datos[i].append(cifrado.toString().charAt(in));

			in++;

			datos[i].append(cifrado.toString().charAt(in));

			in++;

		}

		StringBuilder invertir = new StringBuilder();

		for (int i = datos.length - 1; i >= 0; i--) {

			invertir.append(datos[i].toString());

		}

		return invertir.toString();

	}

	public String cifrarTextoManualHex(String versionHexadecimal, String hashAnterirHexadecimal,
			String MerkleRootHexadecimal, String tiempoHexadecimal, String tamanoBytesHexadecimal,
			String nonceHexadecimal) {

		byte[] cabecera = new byte[versionHexadecimal.length() / 2 + hashAnterirHexadecimal.length() / 2
				+ MerkleRootHexadecimal.length() / 2 + tiempoHexadecimal.length() / 2
				+ tamanoBytesHexadecimal.length() / 2 + nonceHexadecimal.length() / 2];

		byte[] version = new byte[versionHexadecimal.length() / 2];

		byte[] hashAnterior = new byte[hashAnterirHexadecimal.length() / 2];

		byte[] merkle = new byte[MerkleRootHexadecimal.length() / 2];

		byte[] tiempo = new byte[tiempoHexadecimal.length() / 2];

		byte[] tamanoBytes = new byte[tamanoBytesHexadecimal.length() / 2];

		byte[] nonce = new byte[nonceHexadecimal.length() / 2];

		version = binario.bytesInvertidos(versionHexadecimal);

		hashAnterior = binario.bytesInvertidos(hashAnterirHexadecimal);

		merkle = binario.bytesInvertidos(MerkleRootHexadecimal);

		tiempo = binario.bytesInvertidos(tiempoHexadecimal);

		tamanoBytes = binario.bytesInvertidos(tamanoBytesHexadecimal);

		nonce = binario.bytesInvertidos(nonceHexadecimal);

		int indice = 0;

		for (int i = 0; i < version.length; i++) {

			cabecera[indice] = version[i];

			indice++;

		}

		for (int i = 0; i < hashAnterior.length; i++) {

			cabecera[indice] = hashAnterior[i];

			indice++;
		}

		for (int i = 0; i < merkle.length; i++) {

			cabecera[indice] = merkle[i];

			indice++;
		}

		for (int i = 0; i < tiempo.length; i++) {

			cabecera[indice] = tiempo[i];

			indice++;
		}

		for (int i = 0; i < tamanoBytes.length; i++) {

			cabecera[indice] = tamanoBytes[i];

			indice++;
		}

		for (int i = 0; i < nonce.length; i++) {

			cabecera[indice] = nonce[i];

			indice++;

		}

		MessageDigest codigo = null;

		try {
			codigo = MessageDigest.getInstance("SHA-256");

		} catch (NoSuchAlgorithmException e) {

			return "No existe";
		}

		byte[] hash = codigo.digest(codigo.digest(cabecera));

		StringBuilder cifrado = new StringBuilder();

		for (byte bit : hash) {

			cifrado.append(String.format("%02x", bit));

		}

		StringBuilder[] datos = new StringBuilder[cifrado.toString().length() / 2];

		for (int i = 0; i < datos.length; i++) {

			datos[i] = new StringBuilder();

		}

		int in = 0;

		for (int i = 0; i < datos.length; i++) {

			datos[i].append(cifrado.toString().charAt(in));

			in++;

			datos[i].append(cifrado.toString().charAt(in));

			in++;

		}

		StringBuilder invertir = new StringBuilder();

		for (int i = datos.length - 1; i >= 0; i--) {

			invertir.append(datos[i].toString());

		}

		return invertir.toString();

	}

	public String cifrarTexto(String texto) {

		MessageDigest codigo = null;

		try {
			codigo = MessageDigest.getInstance("SHA-256");

		} catch (NoSuchAlgorithmException e) {

			return "No existe";
		}

		byte[] hash = codigo.digest(texto.getBytes());

		StringBuilder cifrado = new StringBuilder();

		for (byte bit : hash) {

			cifrado.append(String.format("%02x", bit));

		}

		return cifrado.toString();

	}
	
	
	
	
	
	
	public String cifrarTextoBytes(String texto) {
		
		
		
		byte[] bytes = binario.bytesNoInvertidos(texto);
		
		
		

		MessageDigest codigo = null;

		try {
			codigo = MessageDigest.getInstance("SHA-256");

		} catch (NoSuchAlgorithmException e) {

			return "No existe";
		}

		byte[] hash = codigo.digest(bytes);

		StringBuilder cifrado = new StringBuilder();

		for (byte bit : hash) {

			cifrado.append(String.format("%02x", bit));

		}

		return cifrado.toString();

	}
	
	
	
	
	
	
	
	
	
	
	

	public String cifrarTextoManualHexValido(String versionHexadecimal, String hashAnterirHexadecimal,
			String MerkleRootHexadecimal, String tiempoHexadecimal, String tamanoBytesHexadecimal) {

		StringBuilder inv = new StringBuilder();

		if (trabajo) {

			StringBuilder invertir = new StringBuilder();

			String nonceHexadecimal = binario.decimalHexadecimal(numeroDeTrabajo);

			numeroDeTrabajo++;

			byte[] cabecera = new byte[versionHexadecimal.length() / 2 + hashAnterirHexadecimal.length() / 2
					+ MerkleRootHexadecimal.length() / 2 + tiempoHexadecimal.length() / 2
					+ tamanoBytesHexadecimal.length() / 2 + nonceHexadecimal.length() / 2];

			byte[] version = new byte[versionHexadecimal.length() / 2];

			byte[] hashAnterior = new byte[hashAnterirHexadecimal.length() / 2];

			byte[] merkle = new byte[MerkleRootHexadecimal.length() / 2];

			byte[] tiempo = new byte[tiempoHexadecimal.length() / 2];

			byte[] tamanoBytes = new byte[tamanoBytesHexadecimal.length() / 2];

			byte[] nonce = new byte[nonceHexadecimal.length() / 2];

			version = binario.bytesInvertidos(versionHexadecimal);

			hashAnterior = binario.bytesInvertidos(hashAnterirHexadecimal);

			merkle = binario.bytesInvertidos(MerkleRootHexadecimal);

			tiempo = binario.bytesInvertidos(tiempoHexadecimal);

			tamanoBytes = binario.bytesInvertidos(tamanoBytesHexadecimal);

			nonce = binario.bytesInvertidos(nonceHexadecimal);

			int indice = 0;

			for (int i = 0; i < version.length; i++) {

				cabecera[indice] = version[i];

				indice++;

			}

			for (int i = 0; i < hashAnterior.length; i++) {

				cabecera[indice] = hashAnterior[i];

				indice++;
			}

			for (int i = 0; i < merkle.length; i++) {

				cabecera[indice] = merkle[i];

				indice++;
			}

			for (int i = 0; i < tiempo.length; i++) {

				cabecera[indice] = tiempo[i];

				indice++;
			}

			for (int i = 0; i < tamanoBytes.length; i++) {

				cabecera[indice] = tamanoBytes[i];

				indice++;
			}

			for (int i = 0; i < nonce.length; i++) {

				cabecera[indice] = nonce[i];

				indice++;

			}

			MessageDigest codigo = null;

			try {
				codigo = MessageDigest.getInstance("SHA-256");

			} catch (NoSuchAlgorithmException e) {

				return "No existe";
			}

			byte[] hash = codigo.digest(codigo.digest(cabecera));

			StringBuilder cifrado = new StringBuilder();

			for (byte bit : hash) {

				cifrado.append(String.format("%02x", bit));

			}

			StringBuilder[] datos = new StringBuilder[cifrado.toString().length() / 2];

			for (int i = 0; i < datos.length; i++) {

				datos[i] = new StringBuilder();

			}

			int in = 0;

			for (int i = 0; i < datos.length; i++) {

				datos[i].append(cifrado.toString().charAt(in));

				in++;

				datos[i].append(cifrado.toString().charAt(in));

				in++;

			}

			for (int i = datos.length - 1; i >= 0; i--) {

				invertir.append(datos[i].toString());

			}

			String objetivo = binario.obtenerObjetivo(tamanoBytesHexadecimal);

			BigInteger nume1 = new BigInteger(binario.hexadecimalDecimalGigante(objetivo));

			BigInteger nume2 = new BigInteger(binario.hexadecimalDecimalGigante(invertir.toString()));

			if (nume2.compareTo(nume1) < 0) {

				trabajo = false;

				has = invertir;

			}

			/*
			 * if (invertir.toString().charAt(0) == '0' && invertir.toString().charAt(1) ==
			 * '0' && invertir.toString().charAt(2) == '0' && invertir.toString().charAt(3)
			 * == '0' && invertir.toString().charAt(4) == '0' &&
			 * invertir.toString().charAt(5) == '0' && invertir.toString().charAt(6) == '0'
			 * && invertir.toString().charAt(7) == '0' && invertir.toString().charAt(8) ==
			 * '0' && invertir.toString().charAt(9) == '0' && invertir.toString().charAt(10)
			 * == '0' && invertir.toString().charAt(11) == '0' &&
			 * invertir.toString().charAt(12) == '0' && invertir.toString().charAt(13) ==
			 * '0' && invertir.toString().charAt(14) == '0' &&
			 * invertir.toString().charAt(15) == '0' && invertir.toString().charAt(16) ==
			 * '0' && invertir.toString().charAt(17) == '0' &&
			 * invertir.toString().charAt(18) == '0') {
			 * 
			 * trabajo = false;
			 * 
			 * has = invertir;
			 * 
			 * }
			 */

			inv = invertir;

		}

		if (trabajo) {

			return inv.toString();

		} else {

			return has.toString();

		}

	}

	public boolean isTrabajo() {
		return trabajo;
	}

	public void setTrabajo(boolean trabajo) {
		this.trabajo = trabajo;
	}

	public int getNumeroDeTrabajo() {
		return numeroDeTrabajo;
	}

	public Binarios getBinario() {
		return binario;
	}

	public void setNumeroDeTrabajo(int numeroDeTrabajo) {
		this.numeroDeTrabajo = numeroDeTrabajo;
	}

}
