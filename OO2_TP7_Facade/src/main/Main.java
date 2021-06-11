package main;

import java.util.List;
import java.util.Map;

import acceso.Fachada;
import modelo.DBFacade;

public class Main {

	public static void main(String[] args) {
		DBFacade fachada = new Fachada();
		fachada.open();
		List<Map<String, String>> mapList = fachada.queryResultAsAsociation("SELECT * FROM clientes");
		List<String[]> list = fachada.queryResultAsArray("SELECT * FROM clientes");
		fachada.close();
		System.out.println(mapList);
		for (String[] strings : list) {
			for (int i = 0; i < strings.length; i++) {
				System.out.print(strings[i] + " ");
			}
			System.out.println();
		}

	}

}
