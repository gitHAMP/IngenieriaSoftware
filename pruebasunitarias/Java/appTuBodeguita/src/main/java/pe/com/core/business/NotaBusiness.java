package pe.com.core.business;

import java.util.logging.Logger;

public class NotaBusiness {

	private final static Logger LOGGER=Logger.getLogger(NotaBusiness.class.getName());
	
	public static String evaluarNota(String valor) {
		String mensaje="NO VALIDO";
		try {
			int nota=Integer.parseInt(valor);
			if(nota>=0 && nota<=10) {
				mensaje="DESAPROBADO";
			}else if(nota>=11 && nota<=20) {
				mensaje="APROBADO";
			}else {
				mensaje="NO VALIDO";
			}
			LOGGER.info(mensaje);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.severe("Error :"+e.getMessage());
		}
		return mensaje;
	}
}
