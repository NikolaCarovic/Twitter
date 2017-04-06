package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {
	
	private TwitterPoruka poruka;

	@Before
	public void setUp() throws Exception {
		poruka = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetKorisnik() {
		poruka.setKorisnik("Bozidar");
		assertEquals("Bozidar", poruka.getKorisnik());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazan() {
		poruka.setKorisnik("");
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		poruka.setKorisnik(null);
	}

	@Test
	public void testSetPoruka() {
		poruka.setPoruka("De si bre?");
		assertEquals("De si bre?", poruka.getPoruka());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		poruka.setPoruka(null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazan() {
		poruka.setPoruka("");
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzina() {
		poruka.setPoruka("popopopopopopopopopopopopopopopopopopopopopopopopopo"
						+"popopopopopopopopopopopopopopopopopopopopopopopopopo"
						+"popopopopopopopopopopopopopopopopopopopopopopopopopo");
	}

	@Test
	public void testToString() {
		poruka.setKorisnik("Slavko");
		poruka.setPoruka("Cao");
		assertEquals("KORISNIK:Slavko PORUKA:Cao",poruka.toString());
	}

}
