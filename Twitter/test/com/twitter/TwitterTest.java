package com.twitter;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	private Twitter tw;
	private LinkedList<TwitterPoruka> poruke;
	private TwitterPoruka twp;
	private TwitterPoruka[] tagPoruke;

	@Before
	public void setUp() throws Exception {
		tw = new Twitter();
		poruke = new LinkedList<>();
		twp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVratiSvePoruke() {
		twp.setKorisnik("Borivoje");
		twp.setPoruka("Sve je na mestu");
		poruke.add(twp);
		tw.unesi("Borivoje", "Sve je na mestu");
		assertEquals(poruke.toString(), tw.vratiSvePoruke().toString());
	}

	@Test
	public void testUnesi() {
		twp.setKorisnik("Borivoje");
		twp.setPoruka("Sve je na mestu");
		poruke.add(twp);
		tw.unesi("Borivoje", "Sve je na mestu");
		assertEquals(poruke.getLast().toString(), tw.vratiSvePoruke().getLast().toString());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiKorisnikN() {
		tw.unesi(null, "Sve je na mestu");
		
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiKorisnikP() {
		tw.unesi("", "Sve je na mestu");
		
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPorukaN() {
		tw.unesi("Borivoje",null);
		
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPorukaP() {
		tw.unesi("Borivoje","");
		
	}

	@Test
	public void testVratiPoruke() {
		tagPoruke = new TwitterPoruka[2];
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		tp1.setKorisnik("Marko");
		tp1.setPoruka("Sve je na mestu");
		tp2.setKorisnik("David");
		tp2.setPoruka("Sve nije na mestuu");
		tagPoruke[0] = tp1;
		tagPoruke[1] = tp2;
		tw.unesi("Marko", "Sve je na mestu");
		tw.unesi("David", "Sve nije na mestuu");
		assertEquals(Arrays.toString(tagPoruke), Arrays.toString(tw.vratiPoruke(2, "Sve")));
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull(){
		tw.vratiPoruke(16, null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazan(){
		tw.vratiPoruke(16, "");
	}
	
	@Test
	public void testVratiPorukeNemaTaga() {
		tagPoruke = new TwitterPoruka[2];
		tw.unesi("Marko", "Sve je na mestu");
		tw.unesi("David", "Sve nije na mestuu");
		assertEquals(Arrays.toString(tagPoruke), Arrays.toString(tw.vratiPoruke(2, "Bozidar")));
	}
	
	@Test
	public void testVratiPorukeImaVisePoruka() {
		tagPoruke = new TwitterPoruka[2];
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		tp1.setKorisnik("Marko");
		tp1.setPoruka("Sve je na mestu");
		tp2.setKorisnik("David");
		tp2.setPoruka("Sve nije na mestuu");
		tagPoruke[0] = tp1;
		tagPoruke[1] = tp2;
		tw.unesi("Marko", "Sve je na mestu");
		tw.unesi("David", "Sve nije na mestuu");
		tw.unesi("Slavko", "Sve je tako a mozda i nije");
		assertEquals(Arrays.toString(tagPoruke), Arrays.toString(tw.vratiPoruke(2, "Sve")));
	}
	
}
