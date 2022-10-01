package Oppg2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {

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
		
		System.out.println("Før:");
		List<Ansatt> listeAvAnsatte = Arrays.asList(
			new Ansatt("Per", "Persen", Kjonn.Mann, "CEO", 1_200_000),
			new Ansatt("Anne", "Tveit", Kjonn.Kvinne, "Co-CEO", 1_000_000),
			new Ansatt("Marita", "Dalen", Kjonn.Kvinne, "Sekretær", 500_000),
			new Ansatt("Knut", "Andersen", Kjonn.Mann, "Programør", 700_000),
			new Ansatt("Kjell", "Knutsen", Kjonn.Mann, "IT-ansvarlig", 600_000)
		);
		listeAvAnsatte.forEach(System.out::println);
		
		System.out.println();
		
		/*Function<Ansatt, Integer> fastKroneTillegg = (a) -> a.getAarslonn() + 100000;
		lonnsoppgjor(listeAvAnsatte, fastKroneTillegg);
		skrivUtAlle(listeAvAnsatte);
		
		System.out.println("");
		
		Function<Ansatt, Integer> fastProsentTillegg = (a) -> a.getAarslonn() * 110/100;
		lonnsoppgjor(listeAvAnsatte, fastProsentTillegg);
		skrivUtAlle(listeAvAnsatte);
		
		System.out.println("");*/
		System.out.println("Etter:");
		Function<Ansatt, Integer> fastKroneTilleggLavLonn = (a) -> {
			if(a.getAarslonn() <= 650_000) {
				return a.getAarslonn() + 50000;
			}
			return a.getAarslonn();
		};
		lonnsoppgjor(listeAvAnsatte, fastKroneTilleggLavLonn);
		skrivUtAlle(listeAvAnsatte);
//		
//		System.out.println("");
//
//		Function<Ansatt, Integer> fastProsentTilleggMann = (a) -> {
//			if(a.getKjonn() == Kjonn.Mann) {
//				return a.getAarslonn() * 125/100;
//			}
//			return a.getAarslonn();
//		};
//		lonnsoppgjor(listeAvAnsatte, fastProsentTilleggMann);
//		skrivUtAlle(listeAvAnsatte);
	}
}
