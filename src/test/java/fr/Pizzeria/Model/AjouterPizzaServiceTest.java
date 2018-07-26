package fr.Pizzeria.Model;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.Pizzeria.Exception.SavePizzaException;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.util.Scanner;

public class AjouterPizzaServiceTest {
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testExecuteUC() {
		PizzaMemDao dao = new PizzaMemDao();
		assertEquals(8,dao.findAllPizzas().size());
		systemInMock.provideLines("TES","TEST","10","viande");
		AjouterPizzaService ajout = new AjouterPizzaService();
		try {
			ajout.executeUC(new Scanner(System.in), dao);
			assertEquals(9,dao.findAllPizzas().size());
		} catch (SavePizzaException e) {
			System.out.println("echec");
		}
		
	}

}
