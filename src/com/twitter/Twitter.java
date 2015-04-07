package com.twitter;

import java.util.LinkedList;

import com.twitter.poruke.TwitterPoruka;

public class Twitter {

	/**
	 * Lista tviter poruka. Svaka tviter poruka sadrzi ime korisnika i teks poruke.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	/**
	 * Vraca listu tviter poruka.
	 * @return poruke (lista poruka klase TwitterPoruka)
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	
	/**
	 * Metoda unosi novu tviter poruku u listu tviter poruka.
	 * @param korisnik predstavlja ime korisnika
	 * @param poruka predstavlja tekst poruke
	 */
	public void unesi(String korisnik, String poruka) {
		
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
	
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda pretrazuje listu tviter poruka i trazi poruke sa zadatim tagom.
	 * Te poruke puni u niz poruka, a zatim vraca niz sa rezultatima pretrage.
	 * @param maxBroj predstavlja maksimalan broj rezultata pretrage
	 * @param tag predstavlja kljucnu rijec prema kojoj se traze rezultati
	 * @return rezultat predstavlja niz koji sadrzi poruke pronadjene na osnovu zadatog taga
	 * @throws java.lang.RuntimeException kada je parametar tag null, ili prazan string.
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
	
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac+1]=poruke.get(i);
					brojac++;
				} else
					break;
		
		return rezultat;
	}
}
