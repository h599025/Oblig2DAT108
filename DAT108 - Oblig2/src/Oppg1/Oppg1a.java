package Oppg1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Oppg1a {

	public static void main(String[] args) {
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");
		
		Collections.sort(listen, (a,b) -> Integer.compare(Integer.parseInt(a), Integer.parseInt(b)));
		
		System.out.println(listen);

	}

}
