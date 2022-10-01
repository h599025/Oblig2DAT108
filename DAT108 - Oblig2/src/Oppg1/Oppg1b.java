package Oppg1;

import java.util.function.BiFunction;

public class Oppg1b {

	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Integer> summerFunksjon = ((a, b) -> a + b);
		BiFunction<Integer, Integer, Integer> storstFunksjon = ((a, b) -> Math.max(a, b));
		BiFunction<Integer, Integer, Integer> avstandFunksjon = ((a, b) -> Math.abs(a - b));
		
		int sum = beregn(12, 13, summerFunksjon);
		System.out.println("Summert: " + sum);
		
		int storst = beregn(-5, 3, storstFunksjon);
		System.out.println("Størst: " + storst);

		int avstand = beregn(54, 45, avstandFunksjon);
		System.out.println("Avstand: " + avstand);
	}
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> funksjon) { 
		return funksjon.apply(a, b);
	}
}
