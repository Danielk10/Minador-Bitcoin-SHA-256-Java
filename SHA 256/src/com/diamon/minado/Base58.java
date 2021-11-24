package com.diamon.minado;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Base58 {

	private Binarios binario = new Binarios();

	private final static String ALFABETO = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";

	private String[] getLetras(String texto) {

		String[] letas = new String[texto.length()];

		for (int i = 0; i < letas.length; i++) {

			letas[i] = "" + texto.charAt(i);

		}

		return letas;
	}

	public String base58Codificar(BigInteger indice) {

		BigInteger cero = new BigInteger("0");

		BigInteger base = new BigInteger("58");

		StringBuilder codigo = new StringBuilder();

		String[] letras = getLetras(ALFABETO);

		while (indice.compareTo(cero) > 0) {

			codigo.append(letras[Integer.parseInt(indice.mod(base).toString())]).toString();

			indice = indice.divide(base);

		}

		StringBuilder invertir = new StringBuilder();

		for (int i = codigo.toString().length() - 1; i >= 0; i--) {

			invertir.append(codigo.toString().charAt(i));

		}

		return invertir.toString();

	}

	public int base58Decodificar(String texto) {

		int codigo = 0;

		codigo = ALFABETO.indexOf(texto);

		return codigo;

	}

	private int deByteASCII(byte digito) {

		int numeros[] = new int[256];

		int numerosASCII[] = new int[256];

		int numero = -128;

		int caracter = 0;

		for (int i = 0; i < 128; i++) {

			numeros[i] = i;

		}

		for (int i = 128; i < 256; i++) {

			numeros[i] = numero;

			numero++;

		}

		for (int i = 0; i < 256; i++) {

			numerosASCII[i] = i;

		}

		for (int i = 0; i < 256; i++) {

			if (digito == numeros[i]) {

				caracter = numerosASCII[i];

			}

		}

		return caracter;

	}

	public BigInteger base256Decodificar(String texto) {

		BigInteger m = new BigInteger("256");

		BigInteger nui = new BigInteger("0");

		byte[] n = binario.bytesNoInvertidos(texto);

		for (int i = 0; i < n.length; i++) {

			nui = nui.multiply(m).add(new BigInteger("" + deByteASCII(n[i])));

		}

		return nui;

	}

	public String base58CodificarChequear(int ver, String texto) {

		String t = Integer.toHexString(ver);

		byte[] version = binario.bytesNoInvertidos(t);

		byte[] clave = binario.bytesNoInvertidos(texto);

		byte[] cabecera = new byte[version.length + clave.length];

		int indice = 0;

		for (int i = 0; i < version.length; i++) {

			cabecera[indice] = version[i];

			indice++;

		}

		for (int i = 0; i < clave.length; i++) {

			cabecera[indice] = clave[i];

			indice++;
		}

		MessageDigest codigo = null;

		try {
			codigo = MessageDigest.getInstance("SHA-256");

		} catch (NoSuchAlgorithmException e) {

			return "No existe";
		}

		byte[] hash = codigo.digest(codigo.digest(cabecera));

		byte[] hash4 = new byte[4];

		for (int i = 0; i < 4; i++) {

			hash4[i] = hash[i];

		}

		byte[] co = new byte[cabecera.length + hash4.length];

		int in = 0;

		for (int i = 0; i < cabecera.length; i++) {

			co[in] = cabecera[i];

			in++;

		}

		for (int i = 0; i < hash4.length; i++) {

			co[in] = hash4[i];

			in++;
		}

		StringBuilder cifrado = new StringBuilder();

		for (byte bit : co) {

			cifrado.append(String.format("%02x", bit));

		}

		return base58Codificar(base256Decodificar(cifrado.toString()));

	}

}
