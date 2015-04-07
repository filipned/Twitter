/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author FILIP
 *
 */
public class TwitterPorukaTest {
	
	private TwitterPoruka tp;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPorukaTest#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		tp.setKorisnik("Filip");
		
		assertEquals("Filip", tp.getKorisnik());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPorukaTest#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPorukaTest#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikIsEmpty() {
		tp.setKorisnik("");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPorukaTest#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		tp.setPoruka("Ovo je twitter poruka.");
		
		assertEquals("Ovo je twitter poruka.", tp.getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPorukaTest#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPorukaTest#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzaOd140() {
		String s = "";
		for (int i = 0; i < 15; i++) {
			s += "desetslova";
		}
		tp.setPoruka(s);
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPorukaTest#toString()}.
	 */
	@Test
	public void testToString() {
		
		String k = "Filip";
		String p = "Ja sam Filip Nedovic.";
		tp.setKorisnik(k);
		tp.setPoruka(p);
		
		assertEquals("KORISNIK:"+k+" PORUKA:"+p, tp.toString());
	}

}
