package pe.com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pe.com.core.business.DocumentoBusiness;

public class DocumentoTest {

	@Test
	public void buscarPersonaCP1() {
		assertTrue(DocumentoBusiness.buscarPersona("DNI", "72301309").equalsIgnoreCase("OK"));
	}
	
	@Test
	public void buscarPersonaCP2() {
		assertTrue(DocumentoBusiness.buscarPersona("RUC", "0").equalsIgnoreCase("ERROR"));
	}

	@Test
	public void buscarPersonaCP3() {
		assertTrue(DocumentoBusiness.buscarPersona("DNI", "100000000").equalsIgnoreCase("ERROR"));
	}
}
