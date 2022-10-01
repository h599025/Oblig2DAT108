package Oppg3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Oppg3 {

	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> funksjon) {
		for(Ansatt ansatt : ansatte) {
			ansatt.setAarslonn(funksjon.apply(ansatt));
		}
		
	}
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for(Ansatt i : ansatte) {
			System.out.println(i.toString());
		}
	}
	
	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Arrays.asList(
			new Ansatt("Per", "Persen", Kjonn.Mann, "CEO", 1_200_000),
			new Ansatt("Anne", "Tveit", Kjonn.Kvinne, "Co-CEO", 1_000_000),
			new Ansatt("Marita", "Dalen", Kjonn.Kvinne, "Sekretær", 500_000),
			new Ansatt("Knut", "Andersen", Kjonn.Mann, "Programør", 700_000),
			new Ansatt("Kjell", "Knutsen", Kjonn.Mann, "IT-ansvarlig", 600_000)
		);
		
		// Ny liste med ansatte sine etternavn
		List<String> ansatteEtternavn = ansatte.stream().map(a -> a.getEtternavn()).toList();
		System.out.println(ansatteEtternavn);
		
		
		// Teller antall kvinner i listen vår
		long antKvinner = ansatte.stream().filter(a -> a.getKjonn() == Kjonn.Kvinne).count();
		System.out.println("\nAntall kvinner: " + antKvinner);
		
		
		//Regner ut gjennomsnittslønnen til kvinnene
		long gjLonnKvinner = ansatte.stream().filter(a -> a.getKjonn() == Kjonn.Kvinne)
				.map(a -> a.getAarslonn()).reduce(0, (sum, Lonn) -> sum + Lonn) / antKvinner;
		System.out.println("\nGjennomsnittslønnen til kvinner: " + gjLonnKvinner);
		
		System.out.println();
		
		
		// Finner ansatte med sjefsstilling, får tak i årslønna deres og gjev dei ei lønnsøkning på 7%
		ansatte.stream().filter(a -> a.getStilling().contains("CEO") || a.getStilling().
				contains("CO-CEO")).forEach(a -> a.setAarslonn(a.getAarslonn()*107/100));
		ansatte.forEach(System.out::println);
		
		
		// Finner ut om noen ansatte tjener meir enn 800k i årslønn
		boolean over800k = ansatte.stream().anyMatch(a -> a.getAarslonn() > 800_000);
		System.out.println("\nTjener noen over 800k i årslønn? " + over800k);
		
		System.out.println();
		
		
		// Skriver ut alle ansatte uten for-løkke
		ansatte.forEach(System.out::println);
		
		System.out.println();
		
		//Finner den/dei ansatte med minste lønn
		List<Ansatt> lavestLonn = ansatte.stream().filter(ansatt -> ansatte.stream()
				.mapToInt(Ansatt::getAarslonn)
				.min().orElse(0) == ansatt.getAarslonn()).toList();
		System.out.println("Den/dei ansatte med minst lønn: " + lavestLonn);
		
		System.out.println();
		
		//Finner summen av alle heiltall i [1, 1000> som er delelig med 3 eller 5
		int totSum = IntStream.range(1, 1000)
				.filter(value -> value % 3 == 0 || value % 5 == 0)
				.reduce(0, Integer::sum);
		System.out.println("Sum = " + totSum);
	}
}
