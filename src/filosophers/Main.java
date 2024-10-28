package filosophers;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Semaphore s12,s23,s34,s45,s51;
		
		s12= new Semaphore(1);
		s23= new Semaphore(1);
		s34= new Semaphore(1);
		s45= new Semaphore(1);
		s51= new Semaphore(1);
		
		Filosofo f1= new Filosofo(1,s12,s51);
		Filosofo f2= new Filosofo(2,s23,s12);
		Filosofo f3= new Filosofo(3,s34,s23);
		Filosofo f4= new Filosofo(4,s45,s34);
		Filosofo f5= new Filosofo(5,s51,s45);
		
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();
	}

}
