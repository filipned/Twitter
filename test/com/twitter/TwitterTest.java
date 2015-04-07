/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author FILIP
 *
 */
public class TwitterTest {

	Twitter t;
	
	/**
	 * @throws java.lang.Exception
	 */
	
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		LinkedList<TwitterPoruka> poruke = t.vratiSvePoruke();
		
		assertEquals(poruke, t.vratiSvePoruke());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		
		t.unesi("Filip", "Ja sam Filip");
		
		TwitterPoruka poruka = new TwitterPoruka();
		
		poruka.setKorisnik("Filip");
		poruka.setPoruka("Ja sam Filip");
		
		assertEquals(poruka.toString(), t.vratiSvePoruke().get(t.vratiSvePoruke().size()-1).toString());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {		
		for (int i = 0; i < 10; i++) {
			t.unesi("Filip", "Ja sam Filip");
		}
		
		TwitterPoruka[] niz = new TwitterPoruka[5];
		
		niz=t.vratiPoruke(5, "Ja");
		
		TwitterPoruka[] nizPomocni = {t.vratiSvePoruke().get(0),t.vratiSvePoruke().get(1),
											t.vratiSvePoruke().get(2),t.vratiSvePoruke().get(3),
																	t.vratiSvePoruke().get(4)};
		assertArrayEquals(nizPomocni,niz);
	}

}
