package pe.com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pe.com.core.business.NotaBusiness;

public class NotaTest {

	@Test
	public void mostrarNotaCP1() {
		assertTrue(NotaBusiness.evaluarNota("0").equalsIgnoreCase("DESAPROBADO"));
	}
	@Test
	public void mostrarNotaCP2() {
		assertTrue(NotaBusiness.evaluarNota("11").equalsIgnoreCase("APROBADO"));
	}
	@Test
	public void mostrarNotaCP3() {
		assertTrue(NotaBusiness.evaluarNota("21").equalsIgnoreCase("NO VALIDO"));
	}
	@Test
	public void mostrarNotaCP4() {
		assertTrue(NotaBusiness.evaluarNota("-1").equalsIgnoreCase("NO VALIDO"));
	}
	@Test
	public void mostrarNotaCP5() {
		assertTrue(NotaBusiness.evaluarNota("CERO").equalsIgnoreCase("NO VALIDO"));
	}
	@Test
	public void mostrarNotaCP6() {
		assertTrue(NotaBusiness.evaluarNota("CU4TRO").equalsIgnoreCase("NO VALIDO"));
	}
	@Test
	public void mostrarNotaCP7() {
		assertTrue(NotaBusiness.evaluarNota(null).equalsIgnoreCase("NO VALIDO"));
	}

}
