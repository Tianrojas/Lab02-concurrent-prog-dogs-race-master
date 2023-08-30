package edu.eci.arsw.primefinder;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		PrimeFinderThread thread1 = new PrimeFinderThread(0, 10000000);
		PrimeFinderThread thread2 = new PrimeFinderThread(10000001, 20000000);
		PrimeFinderThread thread3 = new PrimeFinderThread(20000001, 30000000);

		thread1.start();
		thread2.start();
		thread3.start();

		// Esperar 5 segundos antes de detener los hilos
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Detener los hilos
		thread1.pauseThread();
		thread2.pauseThread();
		thread3.pauseThread();

		// Mostrar el número de primos encontrados hasta el momento
		System.out.println("Número de primos encontrados hasta el momento:");
		System.out.println("Hilo 1: " + thread1.getPrimes().size() + " primos");
		System.out.println("Hilo 2: " + thread2.getPrimes().size() + " primos");
		System.out.println("Hilo 3: " + thread3.getPrimes().size() + " primos");

		// Esperar a que el usuario presione ENTER para reanudar los hilos
		System.out.println("Presione ENTER para reanudar la ejecución de los hilos...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Reanudar los hilos
		thread1.resumeThread();
		thread2.resumeThread();
		thread3.resumeThread();
	}
}
