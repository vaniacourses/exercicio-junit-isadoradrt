package calculadora;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois numeros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a soma com numero negativo")
	@Test
	public void testSomaComNumeroNegativo() {
		int soma = calc.soma(-4, 5);		
		Assertions.assertEquals(1, soma);		
	}
	
	@DisplayName("Testa a subtração de dois numeros")
	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(10, 6);		
		Assertions.assertEquals(4, subtracao);		
	}
	
	@DisplayName("Testa a subtração com numero negativo")
	@Test
	public void testSubtracaoComNumeroNegativo() {
		int subtracao = calc.subtracao(-10, 6);		
		Assertions.assertEquals(-16, subtracao);		
	}
	
	@DisplayName("Testa a multiplicação de dois numeros")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(10, 6);		
		Assertions.assertEquals(60, multiplicacao);		
	}
	
	@DisplayName("Testa a divisao de dois numeros")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@DisplayName("Testa a divisao de um numero por zero")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testa a somatoria até o numero de entrada")
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(5);
		Assertions.assertEquals(15, somatoria);
	}
	
	@DisplayName("Testa se o numero é positivo")
	@Test
	public void testEhPositivo() {
		boolean ehPositivo = calc.ehPositivo(5);
		assertTrue(ehPositivo);
	}
	
	@DisplayName("Testa se o numero é negativo")
	@Test
	public void testEhPositivoNegativo() {
		boolean ehPositivo = calc.ehPositivo(-5);
		assertFalse(ehPositivo);
	}
	
	@DisplayName("Testa a comparação entre dois numeros iguais")
	@Test
	public void testComparaDoisNumerosIguais() {
		int compara = calc.compara(4, 4);
		Assertions.assertEquals(0, compara);
	}

	@DisplayName("Testa a comparação A > B")
	@Test
	public void testComparaAMaior() {
		int compara = calc.compara(8, 4);
		Assertions.assertEquals(1, compara);
	}
	
	@DisplayName("Testa a comparação B > A")
	@Test
	public void testComparaBMaior() {
		int compara = calc.compara(8, 12);
		Assertions.assertEquals(-1, compara);
	}
	
}
