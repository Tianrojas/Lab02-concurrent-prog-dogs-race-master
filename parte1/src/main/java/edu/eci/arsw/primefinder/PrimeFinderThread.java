package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread {

	private int a, b;
	private List<Integer> primes = new LinkedList<Integer>();
	private boolean paused = false;

	public PrimeFinderThread(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public void run() {
		for (int i = a; i <= b; i++) {
			if (isPrime(i)) {
				synchronized (this) {
					while (paused) {
						try {
							wait(); // Esperar hasta que se reanude
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				primes.add(i);
				System.out.println(i);
			}
		}
	}

	boolean isPrime(int n) {
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public List<Integer> getPrimes() {
		return primes;
	}

	public synchronized void pauseThread() {
		paused = true;
	}

	public synchronized void resumeThread() {
		paused = false;
		notify(); // Notificar para reanudar
	}
}
