package com.luis.clases;

public class Corriente extends Cuenta{

	protected double credito;
	protected double interes;
	
	protected Corriente(String dni, String nombre, String numero, int edad,
			double saldo) {
		super(dni, nombre, numero, edad, saldo);
	
		credito=0;
		interes=0;
	
	}

	public Corriente(String dni, String nombre, String numero, int edad,
			double saldo, double credito, double interes) {
		super(dni, nombre, numero, edad, saldo);
		this.credito = credito;
		this.interes = interes;
	}





	public double retirarFondos(double cantidad) throws Exception {
		if(cantidad<=saldo)
			saldo-=cantidad;
		else{
			if(Math.abs(saldo-cantidad)<=credito){
				saldo-=cantidad;
				saldo=saldo+(saldo*interes/100);
				
			}
			else{
				
				throw 
				new Exception("Saldo insuficiente, tu disponible actual es:"+saldo);
			}
			
			
		}
		return saldo;
	}

	public double ingresarFondos(double cantidad) {
		saldo+=cantidad;
		return saldo;
	}

	public String toString() {
		String res="Cuenta corriente\n";
		res+=super.toString();
		return res;	
	
	}
	
}
