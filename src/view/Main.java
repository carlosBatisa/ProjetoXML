package view;

import controle.ParseXML;

public class Main {

	public static void main(String[] args) {
		try {
			ParseXML px = new ParseXML();
			
			
			System.out.println(px.criarDocumentoXML().get(32));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
