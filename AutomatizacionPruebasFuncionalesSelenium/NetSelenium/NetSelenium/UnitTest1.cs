using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

using System.Threading;

namespace NetSelenium
{
    [TestClass]
    public class UnitTest1
    {
        IWebDriver driver = new ChromeDriver();

        [TestMethod]
        public void TestMethod1()
        {
        //    driver.Navigate().GoToUrl("http://www.swtestacademy.com/");
        //    Assert.AreEqual("Software Test Academy | Software Testing Academy", driver.Title);
        //    driver.Close();
        //    driver.Quit();
        }

        [TestMethod]
        public void insertarCategoria_FlujoBasico()
        {
            try
            {
                string mensajeEsperado = "Se guardó de manera correcta la Categoría";
                driver.Navigate().GoToUrl("http://localhost:8180/TuBodeguitaWeb/");

                IWebElement input1 = driver.FindElement(By.Id("txtUsuario"));
                input1.Clear();
                input1.SendKeys("admin");
                IWebElement input2 = driver.FindElement(By.Id("txtClave"));
                input2.Clear();
                input2.SendKeys("clave");
                IWebElement btnIniciaSesion = driver.FindElement(By.Id("btnIniciarSesion"));
                btnIniciaSesion.Click();
                Thread.Sleep(2000);

                IWebElement opcion = driver.FindElement(By.XPath("//*[@id=\"frmMenu:j_idt18\"]/ul/li[2]/a"));
                opcion.Click();
                Thread.Sleep(2000);


                IWebElement btnNuevo = driver.FindElement(By.Id("btnNuevo"));
                btnNuevo.Click();

                IWebElement input3 = driver.FindElement(By.Id("txtNombre"));
                input3.Clear();
                input3.SendKeys("Categoria Prueba");
                Thread.Sleep(2000);

                IWebElement btnGuardar = driver.FindElement(By.Id("btnGuardar"));
                btnGuardar.Click();
                Thread.Sleep(2000);

                string mensajeObtenido = driver.FindElement(By.Id("messages")).Text;
                Assert.AreEqual(mensajeEsperado, mensajeObtenido);
                driver.Close();
            }
            catch (Exception e)
            {
                Assert.Fail();

            }
        }

        [TestMethod]
        public void insertarCategoria_FlujoAlternativo()
        {
            try
            {
                string mensajeEsperado = "Nombre: Error de validación: se necesita un valor.";
                driver.Navigate().GoToUrl("http://localhost:8180/TuBodeguitaWeb/");

                IWebElement input1 = driver.FindElement(By.Id("txtUsuario"));
                input1.Clear();
                input1.SendKeys("admin");
                IWebElement input2 = driver.FindElement(By.Id("txtClave"));
                input2.Clear();
                input2.SendKeys("clave");
                IWebElement btnIniciaSesion = driver.FindElement(By.Id("btnIniciarSesion"));
                btnIniciaSesion.Click();
                Thread.Sleep(2000);

                IWebElement opcion = driver.FindElement(By.XPath("//*[@id=\"frmMenu:j_idt18\"]/ul/li[2]/a"));
                opcion.Click();
                Thread.Sleep(2000);


                IWebElement btnNuevo = driver.FindElement(By.Id("btnNuevo"));
                btnNuevo.Click();

                IWebElement input3 = driver.FindElement(By.Id("txtNombre"));
                input3.Clear();
                input3.SendKeys("");
                Thread.Sleep(2000);

                IWebElement btnGuardar = driver.FindElement(By.Id("btnGuardar"));
                btnGuardar.Click();
                Thread.Sleep(2000);

                string mensajeObtenido = driver.FindElement(By.Id("messages")).Text;
                Assert.AreEqual(mensajeEsperado, mensajeObtenido);
                driver.Close();
            }
            catch (Exception e)
            {
                Assert.Fail();

            }



        }
    }
}
