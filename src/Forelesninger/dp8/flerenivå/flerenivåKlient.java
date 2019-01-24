package Forelesninger.dp8.flerenivå;

import static lib.Out.out;

public class flerenivåKlient {

	public static void main(String[] args) {
		
		Leder l = new Leder("Ola Norman", 1200000, "Adinistrerende Direkt�r");
		l.toString();
		
		Ansatt a = new Leder("Hans Hansen", 1000000, "Dagligleder");
		a.toString();
		
		Person p = new Leder("Birgitt Johansen", 105000, "Kabinettsekret�r");
		p.toString();
	}
}
