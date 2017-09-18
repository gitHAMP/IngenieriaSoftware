package pe.com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pe.com.core.business.Calculadora;

public class CalculadoraTest {
	
	static Calculadora calculadora;
	
	//Carga un objeto complicado de construir, quizas tiene muchas dependencias
	//instanciarlo una unica vez y reutilizarlo
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Antes de todo ( BeforeClass) ");
		calculadora = new Calculadora();
	}
	
	@AfterClass
	public static void afterCLass() {
		System.out.println("Finalizar todo ( AfterClass) ");
	}
	
	@Before
	public void before() {
		System.out.println("Antes de cada test ( Before) ");
		//calculadora = new Calculadora();
		calculadora.clear();//Colocar luego de agregar beforeClass
	}
	
	@After
	public void after() {
		System.out.println("Finalizar de cada test ( After) ");
		calculadora.clear();
	}

	@Test
	public void testSuma() {
		System.out.println("testSuma");
		assertEquals(5, calculadora.add(3, 2));
		//assert:afirmar
		
	}
	
	
	@Test
	public void testResta() {
		System.out.println("testResta");
		assertEquals(1, calculadora.sub(3, 2));
		
		
	}
	
	@Test
	public void testDividir() {
		System.out.println("testDividir");
		assertEquals(3, calculadora.div(6, 2));

	}
	
	@Test(expected=ArithmeticException.class)//Prueba que espera que surja un error
	public void testDividirPorCero() {
		System.out.println("testDividirPorCero");
		calculadora.div(5, 0);
		//calculadora.div(5, 1);// La prueba no sera exitosa porque se espera una division e ntre cero
	}

	@Test(timeout=1000)//No deberia demorarse mas de 1000
	public void testAlgoritmo() {
		System.out.println("testAlgoritmo");
		calculadora.operacionOptima();
		//calculadora.div(5, 1);// La prueba no sera exitosa porque se espera una division e ntre cero
	}

}
