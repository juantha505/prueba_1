package co.edu.unbosque.ciclo3demo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.simple.parser.JSONParser;
//import org.apache.tomcat.util.json.JSONParser;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.InputStream;

public class TestJSONVentas {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
public static int postJSON(Ventas ventas) throws IOException, ParseException, org.json.simple.parser.ParseException {
	
	url = new URL(sitio+"ventas/guardar");
	HttpURLConnection http;
	http = (HttpURLConnection)url.openConnection();
	
	try {
		http.setRequestMethod("POST");
	} catch (ProtocolException e) {
		e.printStackTrace();
	}
	
	http.setDoOutput(true);
	http.setRequestProperty("Accept", "application/json");
	http.setRequestProperty("content-Type", "application/json");
	
	String data = "{"
			+ "\"codigo_venta\":\""+ String.valueOf(ventas.getCodigo_venta())
			+"\",\"cedula_cliente\": \""+ String.valueOf(ventas.getCedula_cliente())
			+"\",\"cedula_usuario\": \""+ String.valueOf(ventas.getCedula_usuario())
			+"\",\"iva_venta\": \""+ String.valueOf(ventas.getIva_venta())
			+"\",\"total_venta\": \""+ String.valueOf(ventas.getTotal_venta())
			+"\",\"valor_venta\": \""+ String.valueOf(ventas.getValor_venta())
			
			+"\"}";
	
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}

public static Long parsingConsecutivo(String json) throws IOException, ParseException, org.json.simple.parser.ParseException {
	Long cod=null;
	JSONParser jsonParser = new JSONParser();
	JSONObject innerObj = (JSONObject) jsonParser.parse(json);
		 
	if (innerObj!=null && !innerObj.isEmpty()) {
	    cod=Long.parseLong(innerObj.get("id").toString());
	}
	return cod;
}
public static Long getConsecutivo() throws IOException, ParseException, org.json.simple.parser.ParseException {
	Long cod=null;
	
	url = new URL(sitio+"ventas/consecutivo");
	HttpURLConnection http;
	http = (HttpURLConnection)url.openConnection();
	
	http.setRequestMethod("GET");
	http.setRequestProperty("Accept", "application/json");
	
	InputStream respuesta = http.getInputStream();
	byte[] inp = respuesta.readAllBytes();
	String json = "";
	
	for (int i = 0; i<inp.length ; i++) {
		   json += (char)inp[i];
	}
		
	cod = parsingConsecutivo(json);
	http.disconnect();
	return cod;
	
}


}