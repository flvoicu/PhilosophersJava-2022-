package filosophers;

import java.util.concurrent.Semaphore;

public class Filosofo extends Thread{
	
	Semaphore pDer;
	Semaphore pIzq;
	
	public Filosofo(int i, Semaphore pDer, Semaphore pIzq) {
		super("Filosofo "+i);
		this.pDer=pDer;
		this.pIzq=pIzq;
		
	}
	
	public void pensar() {
		try {
			Thread.sleep((long)(5000*Math.random()));
			System.out.println(getName()+" Piensa");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void comer() {
		
		if(pDer.tryAcquire(1)==true) {
			System.out.println(getName()+" coge el palillo derecho");
			if(pIzq.tryAcquire(1)== true) {
				System.out.println(getName()+" coge el palillo izquierdo");
			}else {
				pDer.release();
				System.out.println(getName()+" suelta el palillo derecho ya que no ha podido coger el izquierdo");
			}
			try {
				Thread.sleep((long)(2000*Math.random()));
				System.out.println(getName()+" come");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println(getName()+" no puedo coger el palillo derecho");
		}
	}
	
	public void dejarD() {
		pDer.release();
		System.out.println(getName()+" deja el palillo derecho");
		
	}
	
	public void dejarI() {
		pIzq.release();
		System.out.println(getName()+" deja el palillo iquierdo");
	}
	
	public void run() {
		
		while(true) {
			pensar();
			comer();
			dejarD();
			dejarI();
		}
		
	}
	

}
