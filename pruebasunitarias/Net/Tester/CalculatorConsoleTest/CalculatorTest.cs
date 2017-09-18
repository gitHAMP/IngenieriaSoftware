using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using CalculatorConsole;

namespace CalculatorConsoleTest
{
    [TestClass]
    public class CalculatorTest
    {
        [TestMethod]
        public void SumTest()
        {
            var c = new Calculator();
            var exp = c.Suma(1, 1);
            Assert.AreEqual(exp, 2);
        }

        [TestMethod]
        public void DivideTest()
        {
            var c = new Calculator();
            var exp = c.Dividir(1, 1);
            Assert.AreEqual(exp, 1);
        }

        [TestMethod]
        [ExpectedException(typeof(InvalidOperationException))]
        public void DivideInvalidOperationExceptionTest()
        {
            var c = new Calculator();
            var exp = c.Dividir(1, 2);
            
        }

        [TestMethod]
        
        public void DivideSiBCeroTest()
        {
            var c = new Calculator();
            var exp = c.Dividir(1, 0);
            Assert.AreEqual(exp, 1);
        }

    }
}
