package com.twitter.poruke;

/**
 * Klasa predstavlja twitter poruku korisnika
 * 
 * @author Nikola Carovic
 * @version 1.0
 */
public class TwitterPoruka {
	
	/**
	 * Atribut koji predstavlja ime korisnika
	 */
	private String korisnik;
	
	/**
	 * Atribut koji predstavlja sadrzaj poruke koja se salje
	 */
	private String poruka;
	
	/**
	 * Metoda vraca ime korisnika
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda koja postavlja ime korisnika
	 * @param korisnik parametar koji unosimo
	 * 
	 * @throws java.lang.RuntimeException Uneto ime ne sme biti null ili prazan string	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Metoda koja nam vraca sam sadrzaj poruke
	 * @return sadrzaj poruke
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * Metoda koja postavlja sadrzaj poruke
	 * @param poruka koju zelimo da postavimo
	 * 
	 * @throws java.lang.RuntimeException poruka ne sme biti prazna, niti null i mora imati vise od 140 karaktera
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.isEmpty() || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Metoda formatira i vraca vrednosti za korisnika i poruku 
	 * @return Vrednosti:
	 * <ul>
	 * <li>korisnik</li>
	 * <li>poruka</li>
	 * </ul>
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
