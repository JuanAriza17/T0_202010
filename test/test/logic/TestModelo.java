package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() {
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.agregar(""+i);
		}
	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		// TODO
		assertEquals(0, modelo.darTamano());
		
		setUp2();
		assertNotNull("El arreglo debería existir",modelo);
		assertEquals(100, modelo.darTamano());
		
	}

	@Test
	public void testAgregar() {
		// TODO Completar la prueba
		assertEquals(0, modelo.darTamano());
		
		modelo.agregar("0");
		assertEquals(1,modelo.darTamano());
		assertTrue("Debería retornar 0 pero retorna "+modelo.buscar("0")+".",modelo.buscar("0").equals("0"));

		for (int i = 1; i < 200; i++) 
		{
			modelo.agregar(""+i);
			assertEquals(i+1,modelo.darTamano());
			assertTrue("Debería retornar "+i+ " pero retorna "+modelo.buscar(""+i)+".",modelo.buscar(""+i).equals(""+i));
		}
		
	}

	@Test
	public void testBuscar() {
		setUp2();
		// TODO Completar la prueba
		assertNotNull("El arreglo debería existir",modelo);
		assertEquals(100, modelo.darTamano());
		
		assertNull("Debería ser null", modelo.buscar("x"));
		
		assertTrue("Debería retornar 1 pero retorna "+modelo.buscar("1")+".",modelo.buscar("1").equals("1"));

		
		for (int i = 0; i < modelo.darTamano(); i++) 
		{
			assertTrue("Debería retornar "+i+ " pero retorna "+modelo.buscar(""+i)+".",modelo.buscar(""+i).equals(""+i));
		}

	}

	@Test
	public void testEliminar() {
		setUp2();
		// TODO Completar la prueba
		assertNotNull("El arreglo debería existir",modelo);
		assertEquals(100, modelo.darTamano());
		
		String eliminar = modelo.eliminar("x");
		assertNull("Debería ser null", eliminar);
		assertEquals(100, modelo.darTamano());
		
		String dato = modelo.buscar("1");
		eliminar = modelo.eliminar("1");
		assertTrue("Deberían ser el mismo dato",dato.equals(eliminar));
		assertEquals(99, modelo.darTamano());
		assertNull("Debeía ser null", modelo.buscar("1"));
		
		int numero = 0;
		for (int i = 0; i < modelo.darTamano(); i++) 
		{
			numero++;
		}
		assertEquals(modelo.darTamano(), numero);

		
	}

}
