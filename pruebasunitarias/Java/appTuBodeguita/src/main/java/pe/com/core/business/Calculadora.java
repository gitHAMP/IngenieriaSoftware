package pe.com.core.business;

public class Calculadora {
	
	private int ans;
	
	public Calculadora() {
		ans=0;
	}

	public  int add(int a, int b) {
		ans=a+b;
		return ans;
	}
	
	public  int sub(int a, int b) {
		ans=a-b;
		return ans;
	}
	
	public int div(int a, int b) {
		if(b==0)
			throw new ArithmeticException("No puedes dividir por cero");
		ans=a/b;
		return ans;
	}
	
	
	
	public void operacionOptima() {
		//Bucle infinito
		for(;;);
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	public void clear() {
		ans=0;
	}
}
