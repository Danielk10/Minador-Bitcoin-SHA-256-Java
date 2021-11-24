package com.diamon.minado;

import java.math.BigInteger;

public class Binarios {

	public byte[] bytesNoInvertidos(String texto) {

		byte[] pares = new byte[texto.length() / 2];

		if (!(texto == "" || texto == " " || texto == null)) {

			StringBuilder[] paresTexto = new StringBuilder[texto.length() / 2];

			for (int i = 0; i < paresTexto.length; i++) {

				paresTexto[i] = new StringBuilder();

			}

			int j = 0;

			for (int i = 0; i < paresTexto.length; i++) {

				paresTexto[i].append(texto.charAt(j));

				j++;

				paresTexto[i].append(texto.charAt(j));

				j++;

			}

			for (int i = 0; i < paresTexto.length; i++) {

				pares[i] = (byte) hexadecimalDecimal(paresTexto[i].toString());

			}

		}

		return pares;

	}

	public byte[] bytesInvertidos(String texto) {

		byte[] paresInvertidos = new byte[texto.length() / 2];

		StringBuilder[] paresTexto = new StringBuilder[texto.length() / 2];

		for (int i = 0; i < paresTexto.length; i++) {

			paresTexto[i] = new StringBuilder();

		}

		int j = 0;

		for (int i = 0; i < paresTexto.length; i++) {

			paresTexto[i].append(texto.charAt(j));

			j++;

			paresTexto[i].append(texto.charAt(j));

			j++;

		}

		byte[] pares = new byte[texto.length() / 2];

		for (int i = 0; i < paresTexto.length; i++) {

			pares[i] = (byte) hexadecimalDecimal(paresTexto[i].toString());

		}

		int indice = 0;

		for (int i = pares.length - 1; i >= 0; i--) {

			paresInvertidos[indice] = pares[i];

			indice++;

		}

		return paresInvertidos;

	}

	private int hexadecimalDecimal(String texto) {

		int[] numero = new int[texto.length()];

		for (int i = 0; i < texto.length(); i++) {

			if (texto.charAt(i) == '0') {

				numero[i] = 0;

			}
			if (texto.charAt(i) == '1') {

				numero[i] = 1;

			}
			if (texto.charAt(i) == '2') {

				numero[i] = 2;

			}
			if (texto.charAt(i) == '3') {

				numero[i] = 3;

			}
			if (texto.charAt(i) == '4') {

				numero[i] = 4;

			}
			if (texto.charAt(i) == '5') {

				numero[i] = 5;

			}
			if (texto.charAt(i) == '6') {

				numero[i] = 6;

			}
			if (texto.charAt(i) == '7') {

				numero[i] = 7;

			}
			if (texto.charAt(i) == '8') {

				numero[i] = 8;

			}
			if (texto.charAt(i) == '9') {
				numero[i] = 9;

			}
			if (texto.charAt(i) == 'a') {

				numero[i] = 10;

			}
			if (texto.charAt(i) == 'b') {

				numero[i] = 11;

			}
			if (texto.charAt(i) == 'c') {

				numero[i] = 12;

			}
			if (texto.charAt(i) == 'd') {

				numero[i] = 13;

			}
			if (texto.charAt(i) == 'e') {
				numero[i] = 14;

			}
			if (texto.charAt(i) == 'f') {

				numero[i] = 15;

			}

			if (texto.charAt(i) == 'A') {

				numero[i] = 10;

			}
			if (texto.charAt(i) == 'B') {

				numero[i] = 11;

			}
			if (texto.charAt(i) == 'C') {

				numero[i] = 12;

			}
			if (texto.charAt(i) == 'D') {

				numero[i] = 13;

			}
			if (texto.charAt(i) == 'E') {

				numero[i] = 14;

			}
			if (texto.charAt(i) == 'F') {

				numero[i] = 15;

			}

		}

		int numeroDecimal = numero[1] + numero[0] * (16);

		return numeroDecimal;

	}

	public int hexadecimalDecimal8(String texto) {

		int[] numero = new int[texto.length()];

		for (int i = 0; i < texto.length(); i++) {

			if (texto.charAt(i) == '0') {

				numero[i] = 0;

			}
			if (texto.charAt(i) == '1') {

				numero[i] = 1;

			}
			if (texto.charAt(i) == '2') {

				numero[i] = 2;

			}
			if (texto.charAt(i) == '3') {

				numero[i] = 3;

			}
			if (texto.charAt(i) == '4') {

				numero[i] = 4;

			}
			if (texto.charAt(i) == '5') {

				numero[i] = 5;

			}
			if (texto.charAt(i) == '6') {

				numero[i] = 6;

			}
			if (texto.charAt(i) == '7') {

				numero[i] = 7;

			}
			if (texto.charAt(i) == '8') {

				numero[i] = 8;

			}
			if (texto.charAt(i) == '9') {
				numero[i] = 9;

			}
			if (texto.charAt(i) == 'a') {
				numero[i] = 10;

			}
			if (texto.charAt(i) == 'b') {

				numero[i] = 11;

			}
			if (texto.charAt(i) == 'c') {

				numero[i] = 12;

			}
			if (texto.charAt(i) == 'd') {

				numero[i] = 13;

			}
			if (texto.charAt(i) == 'e') {

				numero[i] = 14;

			}
			if (texto.charAt(i) == 'f') {

				numero[i] = 15;

			}

			if (texto.charAt(i) == 'A') {

				numero[i] = 10;

			}
			if (texto.charAt(i) == 'B') {

				numero[i] = 11;

			}
			if (texto.charAt(i) == 'C') {

				numero[i] = 12;

			}
			if (texto.charAt(i) == 'D') {

				numero[i] = 13;

			}
			if (texto.charAt(i) == 'E') {

				numero[i] = 14;

			}
			if (texto.charAt(i) == 'F') {

				numero[i] = 15;

			}

		}

		int numeroDecimal = (int) (numero[7] + numero[6] * (16) + numero[5] * Math.pow(16, 2)
				+ numero[4] * Math.pow(16, 3) + numero[3] * Math.pow(16, 4) + numero[2] * Math.pow(16, 5)
				+ numero[1] * Math.pow(16, 6) + numero[0] * Math.pow(16, 7));

		return numeroDecimal;

	}

	public String hexadecimalDecimalGigante(String textoHexadecimal) {

		StringBuilder[] numeroDecimal = new StringBuilder[textoHexadecimal.length()];

		for (int i = 0; i < textoHexadecimal.length(); i++) {

			numeroDecimal[i] = new StringBuilder();

		}

		for (int i = 0; i < textoHexadecimal.length(); i++) {

			if (textoHexadecimal.charAt(i) == '0') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '1') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '2') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '3') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '4') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '5') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '6') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '7') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '8') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == '9') {

				numeroDecimal[i].append(textoHexadecimal.charAt(i));

			}
			if (textoHexadecimal.charAt(i) == 'a') {

				numeroDecimal[i].append("10");
			}
			if (textoHexadecimal.charAt(i) == 'b') {

				numeroDecimal[i].append("11");

			}
			if (textoHexadecimal.charAt(i) == 'c') {

				numeroDecimal[i].append("12");

			}
			if (textoHexadecimal.charAt(i) == 'd') {

				numeroDecimal[i].append("13");

			}
			if (textoHexadecimal.charAt(i) == 'e') {

				numeroDecimal[i].append("14");

			}
			if (textoHexadecimal.charAt(i) == 'f') {

				numeroDecimal[i].append("15");

			}

			if (textoHexadecimal.charAt(i) == 'A') {

				numeroDecimal[i].append("10");
			}
			if (textoHexadecimal.charAt(i) == 'B') {

				numeroDecimal[i].append("11");

			}
			if (textoHexadecimal.charAt(i) == 'C') {

				numeroDecimal[i].append("12");

			}
			if (textoHexadecimal.charAt(i) == 'D') {

				numeroDecimal[i].append("13");

			}
			if (textoHexadecimal.charAt(i) == 'E') {

				numeroDecimal[i].append("14");

			}
			if (textoHexadecimal.charAt(i) == 'F') {

				numeroDecimal[i].append("15");

			}

		}

		BigInteger[] numeros = new BigInteger[numeroDecimal.length];

		BigInteger[] partes = new BigInteger[numeroDecimal.length];

		BigInteger[] suma = new BigInteger[numeroDecimal.length - 1];

		BigInteger base = new BigInteger("16");

		for (int i = 0; i < numeros.length; i++) {

			numeros[i] = new BigInteger(numeroDecimal[i].toString());

		}

		int indice = numeros.length - 1;

		for (int i = 0; i < numeros.length; i++) {

			partes[i] = numeros[indice].multiply(base.pow(i));

			indice--;

		}

		suma[0] = partes[0].add(partes[1]);

		for (int i = 1; i < numeros.length - 1; i++) {

			suma[i] = suma[i - 1].add(partes[i + 1]);

		}

		BigInteger numeroDe = suma[suma.length - 1];

		return numeroDe.toString();

	}

	public String decimalGiganteHexadecimal(String numeroDecimal) {

		BigInteger numero = new BigInteger(numeroDecimal);

		BigInteger base = new BigInteger("16");

		int potencia = 0;

		for (int i = 0; i < 1000; i++) {

			if (base.pow(i).bitLength() >= numero.bitLength()) {

				potencia = i - 1;

				break;

			}

		}

		BigInteger[] division = new BigInteger[potencia];

		BigInteger[] resto = new BigInteger[potencia];

		division[0] = numero.divide(base.pow(potencia));

		resto[0] = numero.mod(base.pow(potencia));

		for (int i = 1; i < potencia; i++) {

			division[i] = resto[i - 1].divide(base.pow(potencia - i));

			resto[i] = resto[i - 1].mod(base.pow(potencia - i));

		}

		String[] num = new String[potencia + 1];

		for (int i = 0; i < potencia; i++) {

			num[i] = division[i].toString();

			if (i == potencia - 1) {

				num[i + 1] = resto[i].toString();

			}

		}

		StringBuilder numeroHex = new StringBuilder();

		for (int i = 0; i < num.length; i++) {

			for (int j = 0; j < 16; j++) {

				if (num[i].equals("" + j)) {

					if (j == 10) {

						numeroHex.append("A");

					} else if (j == 11) {

						numeroHex.append("B");

					} else if (j == 12) {

						numeroHex.append("C");

					} else if (j == 13) {

						numeroHex.append("D");

					} else if (j == 14) {

						numeroHex.append("E");

					} else if (j == 15) {

						numeroHex.append("F");

					} else {

						numeroHex.append("" + j);

					}

				}

			}

		}

		return numeroHex.toString();

	}

	public String hexadecimalAhexadecimal64(String texto) {

		String t = texto;

		String tHex = "";

		StringBuilder ceros = new StringBuilder();

		for (int i = 0; i < 64; i++) {

			if (t.length() == i + 1) {

				for (int j = 0; j < 64 - (i + 1); j++) {

					ceros.append("0");

				}

				tHex = ceros + t;

			}

		}

		return tHex;

	}

	public String obtenerObjetivo(String bitHex) {

		int exponente = hexadecimalDecimal8(bitHex) >> 24;

		int numoroObtenido = hexadecimalDecimal8(bitHex) & 0xffffff;

		BigInteger numeroGrande = new BigInteger("1");

		int desplazar = (8 * (exponente - 3));

		BigInteger numeroGrande2 = new BigInteger(String.valueOf(numoroObtenido));

		BigInteger numeroGrande3 = numeroGrande.shiftLeft(desplazar);

		BigInteger numero = numeroGrande2.multiply(numeroGrande3);

		BigInteger base = new BigInteger("16");

		int potencia = 0;

		for (int i = 0; i < 1000; i++) {

			if (base.pow(i).compareTo(numero) >= 1) {

				potencia = i - 1;

				break;

			}

		}

		BigInteger[] division = new BigInteger[potencia];

		BigInteger[] resto = new BigInteger[potencia];

		division[0] = numero.divide(base.pow(potencia));

		resto[0] = numero.mod(base.pow(potencia));

		for (int i = 1; i < potencia; i++) {

			division[i] = resto[i - 1].divide(base.pow(potencia - i));

			resto[i] = resto[i - 1].mod(base.pow(potencia - i));

		}

		String[] num = new String[potencia + 1];

		for (int i = 0; i < potencia; i++) {

			num[i] = division[i].toString();

			if (i == potencia - 1) {

				num[i + 1] = resto[i].toString();

			}

		}

		StringBuilder numeroHex = new StringBuilder();

		for (int i = 0; i < num.length; i++) {

			for (int j = 0; j < 16; j++) {

				if (num[i].equals("" + j)) {

					if (j == 10) {

						numeroHex.append("A");

					} else if (j == 11) {

						numeroHex.append("B");

					} else if (j == 12) {

						numeroHex.append("C");

					} else if (j == 13) {

						numeroHex.append("D");

					} else if (j == 14) {

						numeroHex.append("E");

					} else if (j == 15) {

						numeroHex.append("F");

					} else {

						numeroHex.append("" + j);

					}

				}

			}

		}

		String objetivo = hexadecimalAhexadecimal64(numeroHex.toString());

		return objetivo;

	}

	public String decimalHexadecimal(int numero) {

		String t = Integer.toHexString(numero);

		String tHex = "";

		if (t.length() == 1) {

			tHex = "0000000" + t;

		}

		if (t.length() == 2) {

			tHex = "000000" + t;

		}
		if (t.length() == 3) {

			tHex = "00000" + t;

		}
		if (t.length() == 4) {

			tHex = "0000" + t;

		}
		if (t.length() == 5) {

			tHex = "000" + t;

		}
		if (t.length() == 6) {

			tHex = "00" + t;
		}

		if (t.length() == 7) {

			tHex = "0" + t;

		}
		if (t.length() == 8) {

			tHex = t;

		}

		return tHex;

	}

}
