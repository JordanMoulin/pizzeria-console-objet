package fr.pizzeria.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.PizzaBddDao;
import fr.pizzeria.exception.SavePizzaException;

public class AjouterPizzaServiceTest {
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void testExecuteUC() {
		PizzaBddDao dao = new PizzaBddDao();
		assertEquals(8, dao.findAllPizzas().size());
		systemInMock.provideLines("TES", "TEST", "10", "viande");
		AjouterPizzaService ajout = new AjouterPizzaService();
		try {
			ajout.executeUC(new Scanner(System.in), dao);
			assertEquals(9, dao.findAllPizzas().size());
		} catch (SavePizzaException e) {
			fail(" !!!!!!! Echec !!!!!!! ");
		}

	}

}
