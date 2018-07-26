package fr.Pizzeria.Model;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.util.Scanner;

public class AjouterPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	@Test
	public void testExecuteUC() {
		systemInMock.provideLines("TES","TEST","10","viande");
		AjouterPizzaService serv = new AjouterPizzaService();
		int value = serv.executeUC(new Scanner(System.in), pizzas);
	}

}
