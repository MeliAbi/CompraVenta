package compraVenta;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void queSeCreeUnSistemaYUnaListaDeUsuarios() {
		Sistema sistema = new Sistema("NombreGenerico");
		Usuario usuario1 = new Usuario(42592630,"Martin P.", 100000.0, TIPODEARTICULO.Invaluable);
		Usuario usuario2 = new Usuario(42592631,"Laura P.", 1000000.0, TIPODEARTICULO.Antiguedad);
		Usuario usuario3 = new Usuario(42592632,"Sofia P.", 10000.0, TIPODEARTICULO.DeLujo);
		Usuario usuario4 = new Usuario(42592633,"Lucas P.", 5000.0, TIPODEARTICULO.Exoticos);
		//-//
		sistema.registrarUsuario(usuario1);
		sistema.registrarUsuario(usuario2);
		sistema.registrarUsuario(usuario3);
		sistema.registrarUsuario(usuario4);
		//-//
		assertNotNull(sistema.getNombre());
		assertEquals(TIPODEARTICULO.Exoticos, sistema.buscarUsuario(42592633).getArticuloPreferido());
		assertEquals(TIPODEARTICULO.Exoticos, sistema.buscarArticulo(2006).getTipoDeArticulo());
		assertEquals(sistema.buscarCombo(TIPODEARTICULO.Exoticos).getTipo(),sistema.buscarArticulo(2006).getTipoDeArticulo());
	}
	
	@org.junit.Test
	public void queElSistemaRecomiendeArticulosYCombos() {
		Sistema sistema = new Sistema("NombreGenerico");
		Usuario usuario1 = new Usuario(42592630,"Martin P.", 100000.0, TIPODEARTICULO.Invaluable);
		
		//-//
		sistema.registrarUsuario(usuario1);
		
		//-//
		Integer resultadoEsperado = 2002;
		assertNotNull(sistema.buscarUsuario(42592630));
		assertEquals(resultadoEsperado,sistema.recomendarArticulo(usuario1).getId());
	}
	
	@org.junit.Test
	public void queUnUsuarioGenereUnaCompra() throws CreditosInsuficientesException, SinStockException {
		Sistema sistema = new Sistema("NombreGenerico");
		Usuario usuario1 = new Usuario(42592630,"Martin P.", 100000.0, TIPODEARTICULO.Invaluable);
		
		//-//
		sistema.registrarUsuario(usuario1);
		try {
			sistema.procesarCompra(42592630,2001);
		} catch (CreditosInsuficientesException e) {
			throw new CreditosInsuficientesException(e.getMessage());
		} catch (SinStockException e) {
			throw new SinStockException(e.getMessage());
		}
		//-//
		assertEquals((Double)95500.0,sistema.buscarUsuario(42592630).getPresupuesto());
		assertEquals((Integer)4,sistema.buscarArticulo(2001).getCantidad());
	}
	
	@org.junit.Test
	public void queAUsuarioSeLeRecomiendeUnArticuloDeSuPreferencia(){
		Sistema sistema = new Sistema("NombreGenerico");
		Usuario usuario1 = new Usuario(42592630,"Martin P.", 1000000.0, TIPODEARTICULO.Invaluable);
		
		//-//
		sistema.registrarUsuario(usuario1);

		//-//
		assertNotNull(sistema.recomendarArticulo(usuario1));
		assertEquals(usuario1.getArticuloPreferido(),sistema.recomendarArticulo(usuario1).getTipoDeArticulo());
	}
	
	@org.junit.Test
	public void queAUsuarioSeLeRecomiendeUnArticuloNoDeSuPreferencia(){
		Sistema sistema = new Sistema("NombreGenerico");
		Usuario usuario1 = new Usuario(42592630,"Martin P.", 14000.0, TIPODEARTICULO.Invaluable);
		
		//-//
		sistema.registrarUsuario(usuario1);

		//-//
		assertNotNull(sistema.recomendarArticulo(usuario1));
		assertNotEquals(usuario1.getArticuloPreferido(),sistema.recomendarArticulo(usuario1).getTipoDeArticulo());
	}
	
	@org.junit.Test
	public void queAUsuarioSeLeRecomiendeUnComboDeSuPreferencia(){
		Sistema sistema = new Sistema("NombreGenerico");
		Usuario usuario1 = new Usuario(42592630,"Martin P.", 1000000.0, TIPODEARTICULO.Invaluable);
		
		//-//
		sistema.registrarUsuario(usuario1);

		//-//
		assertNotNull(sistema.recomendarCombo(usuario1));
		assertEquals(usuario1.getArticuloPreferido(),sistema.recomendarCombo(usuario1).getTipo());
	}
	
	@org.junit.Test
	public void queAUsuarioSeLeRecomiendeUnComboNoDeSuPreferencia(){
		Sistema sistema = new Sistema("NombreGenerico");
		Usuario usuario1 = new Usuario(42592630,"Martin P.", 28000.0, TIPODEARTICULO.Invaluable);
		
		//-//
		sistema.registrarUsuario(usuario1);

		//-//
		assertNotNull(sistema.recomendarArticulo(usuario1));
		assertNotEquals(usuario1.getArticuloPreferido(),sistema.recomendarCombo(usuario1).getTipo());
	}


}
