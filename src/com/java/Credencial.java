package com.java;

import Exceptions.SamePassException;
import Exceptions.WrongPasswordFormat;

public class Credencial {
	private String username;
	private String passwd;
	private static int secuencia = 100;
	
	
	public Credencial(String passwd, String nombre, String apellido) throws Exception{
		super();
		
		try {
			setPasswd(passwd);
			
		}  catch(WrongPasswordFormat e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(nombre.charAt(nombre.length()-3));
		sb.append(nombre.charAt(nombre.length()-2));
		sb.append(nombre.charAt(nombre.length()-1));
		
		sb.append(apellido.charAt(0));
		sb.append(apellido.charAt(1));
		sb.append(apellido.charAt(2));

		sb.append(secuencia);
		secuencia ++;
		this.username = sb.toString();
	}
	
	
	public boolean esPassSegura(String contra) {
		 boolean longitud = contra.length() >= 8;	    
	     boolean tieneLetra = false;
	     boolean tieneNumero = false;
	     boolean tieneCaracterEsp = false;

	     for (char c : contra.toCharArray()) {
	            if (Character.isLetter(c)) {
	                tieneLetra = true;
	            }
	            else if (Character.isDigit(c)) {
	                tieneNumero = true;
	            }
	            else {
	            	tieneCaracterEsp = true;
	            }
	        }
	        return longitud && tieneLetra && tieneNumero && tieneCaracterEsp; 
	    }


	public String getUsername() {
		return this.username;
	}


	public void setPasswd(String passwd) throws SamePassException, WrongPasswordFormat {
	    if (this.passwd != null && passwd.equals(this.passwd)) {
	        throw new SamePassException();
	    } else if (!esPassSegura(passwd)) {
	        throw new WrongPasswordFormat();
	    } else {
	        this.passwd = passwd;
	    }
	}

	
	public boolean comprobarPasswd(String passwd) {
		return this.passwd.equals(passwd);
	}
	
	
		
	}
	
	
	
	
