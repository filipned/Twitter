package com.twitter.poruke;

import java.util.jar.JarException;

public class TwitterPoruka {
	
	/**
	 * Korisnik poruke
	 */
	private String korisnik;
	/**
	 * Tekst poruke
	 */
	private String poruka;
	
	/**
	 * Metoda koja vraca korisnika poruke
	 * @return korisnik 
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Postavlja ime korisnika
	 * @param korisnik
	 * @throws java.lang.RuntimeException ako je prametar korisnik null ili prazan String
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
		
		this.korisnik = korisnik;
	}
	
	/**
	 * Vraca tekst poruke
	 * @return poruka
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * Postavlja tekst poruke
	 * @param poruka
	 * @throws java.lang.RuntimeException ako je parametar poruka null, ili ako sadrzi vise od 140 znakova
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		
		this.poruka = poruka;
	}
	
	/**
	 * Vraca String sa imenom korisnika i tekstom poruke.
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}
