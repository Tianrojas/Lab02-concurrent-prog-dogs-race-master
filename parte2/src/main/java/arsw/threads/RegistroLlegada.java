package arsw.threads;

public class RegistroLlegada {

	private int ultimaPosicionAlcanzada=1;

	private static boolean pausaCarrera = false;
	private String ganador=null;
	
	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	public int getUltimaPosicionAlcanzada() {
		return ultimaPosicionAlcanzada;
	}

	public void setUltimaPosicionAlcanzada(int ultimaPosicionAlcanzada) {
		this.ultimaPosicionAlcanzada = ultimaPosicionAlcanzada;
	}

	public void togglePausaCarrera() {
		pausaCarrera = !pausaCarrera; // Cambia el valor de miBoolean usando el operador de negación (!)
	}

	public static boolean isPausaCarrera() {
		return pausaCarrera;
	}
}
