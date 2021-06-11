package main;

import java.util.List;
import java.util.Map;

import acceso.Fachada;
import modelo.DBFacade;

public class Main {

	public static void main(String[] args) {
		DBFacade fachada = new Fachada();
		fachada.open();
		List<Map<String, String>> mapList = fachada.queryResultAsAsociation("Sentencia sql");
		List<String[]> list = fachada.queryResultAsArray("Sentencia sql");
		fachada.close();

	}

}
