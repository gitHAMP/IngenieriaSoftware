package pe.com.test;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import pe.com.core.business.CategoriaBusiness;
import pe.com.core.entity.Categoria;
import pe.com.test.bean.CategoriaBean;


public class CategoriaTest {

	private final CategoriaBusiness categoriaBusiness = new CategoriaBusiness();
	private static Categoria categoria;
	
	@BeforeClass
	public void inicioClase() {
		System.out.println("**********************Inicio Clase CategoriaTest**********************");
	}

	@AfterClass
	public void finClase() {
		System.out.println("**********************Fin Clase CategoriaTest**********************");
	}
	
	@BeforeTest
	public void inicioMetodo() {
		System.out.println("**********************Inicio Metodo CategoriaTest**********************");
	}

	@AfterTest
	public void finMetodo() {
		System.out.println("Id Categoria: " + categoria.getIdCategoria());
		System.out.println("Nombre: " + categoria.getNombre());
		System.out.println("**********************Fin Metodo CategoriaTest**********************\n\n");
	}
	
	@DataProvider(name = "datosEntrada")
	public static Object[][] datosPoblados() {
		return new Object[][] { { new CategoriaBean("Chocolates")}, {new CategoriaBean("Lacteos") } };
	}
	

	@Test
	@Parameters("nombreInsertar")
	//@Parameters({"nombreActualizar", "nombreInsertar"})
	public void insertar(String nombreInsertar) {
		try{
			System.out.println("Metodo Insertar");
			categoria = new Categoria();
			categoria.setNombre(nombreInsertar);
			categoriaBusiness.insertar(categoria);
			Assert.assertTrue(categoria.getIdCategoria()>0);
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dataProvider = "datosEntrada")
	public void insertarDataProvider(CategoriaBean categoriaBean) {
		try {
			System.out.println("Metodo Insertar");
			categoria = new Categoria();
			categoria.setNombre(categoriaBean.getNombre());
			categoriaBusiness.insertar(categoria);
			Assert.assertTrue(categoria.getIdCategoria() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test(dependsOnMethods={"insertar"})
	@Parameters("nombreActualizar")
	public void actualizar(String nombreActualizar) {
		try{
			System.out.println("Metodo Actualizar");
			
			categoria.setNombre(nombreActualizar);
			categoriaBusiness.actualizar(categoria);
			Assert.assertTrue(categoria.getIdCategoria()>0);
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods={"actualizar"})
	public void obtener(){
		try{
			System.out.println("Metodo Obtener");
			Categoria categoriaBuscada = categoriaBusiness.obtener(categoria.getIdCategoria());
			Assert.assertEquals(categoria, categoriaBuscada);
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(dependsOnMethods={"obtener"})
	public void eliminar(){
		try{
			System.out.println("Metodo Eliminar");
			categoriaBusiness.eliminar(categoria);
			Assert.assertTrue(true);
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(timeOut=1000)
	public void timeOut(){
		try {
			System.out.println("Metodo timeOut");
			Thread.sleep(900);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
