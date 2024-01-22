package Ilyass;

public class MoyenneMobile {
	private float[] buffer;
	private int index;
	
	
	public MoyenneMobile(int tailleFenetre) {
		buffer = new float[tailleFenetre];
		index = 0;
	}
	
	public float filtre(float nouvelleValeur) {
		buffer[index] = nouvelleValeur;
        index = (index + 1) % buffer.length;

        float somme = 0;
        for (float valeur : buffer) {
            somme += valeur;
        }

        return somme / buffer.length;
	}
	
}
