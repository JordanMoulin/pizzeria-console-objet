package fr.pizzeria.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import fr.pizzeria.dao.PizzaDaoMem;

public class PizzaMemDaoTest {
	private PizzaDaoMem dao = new PizzaDaoMem();
	private Pizza pizza = new Pizza("TES", "TEST", 0, CategoriePizza.SANS_VIANDE);
	private Pizza find;

	@Test
	public void testPizzaMemDao() {
		assertEquals(8, dao.getPizzas().size());
	}

	@Test
	public void testFindAllPizzas() {
		List<Pizza> list = dao.findAllPizzas();
		assertEquals(8, list.size());
	}

	@Test
	public void testSaveNewPizza() {
		assertEquals(8, dao.findAllPizzas().size());
		dao.saveNewPizza(pizza);
		assertEquals(9, dao.findAllPizzas().size());
	}

	@Test
	public void testUpdatePizza() {
		assertNotNull(dao.findPizzaByCode("SAV"));
		dao.updatePizza("SAV", pizza);
		find = dao.findPizzaByCode("TES");
		assertEquals("TES", find.getCode());
	}

	@Test
	public void testFindPizzaByCode() {
		find = dao.findPizzaByCode("SAV");
		assertEquals("SAV", find.getCode());
	}

	@Test
	public void testDeletePizza() {
		assertNotNull(dao.findPizzaByCode("SAV"));
		dao.deletePizza("SAV");
		List<Pizza> list = dao.findAllPizzas();
		assertEquals(7, list.size());
		assertEquals(null, dao.findPizzaByCode("SAV"));
	}

	@Test
	public void testPizzaExists() {
		assertTrue(dao.pizzaExists("PEP"));
	}

}
