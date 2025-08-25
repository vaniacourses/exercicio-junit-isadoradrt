package carrinho;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

	private Carrinho carrinho;
    private Produto p1;
    private Produto p2;
	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
		p1 = new Produto("Camiseta", 50.0);
        p2 = new Produto("Tênis", 200.0);
        carrinho.addItem(p1);
        carrinho.addItem(p2);
	}
	
	@DisplayName("Testa a quantidade de itens no carrinho")
	@Test
	public void testGetQtdeItems() {
		int qtdeItems = carrinho.getQtdeItems();		
		Assertions.assertEquals(2, qtdeItems);		
	}
	
	@DisplayName("Testa adicionar um item no carrinho")
	@Test
	public void testAddItem() {
		Produto produto = new Produto("Boné", 30.0);
		carrinho.addItem(produto);		
		Assertions.assertEquals(3, carrinho.getQtdeItems());		
	}
	
	@DisplayName("Testa esvaziar um carrinho")
	@Test
	public void testEsvazia() {
		carrinho.esvazia();		
		Assertions.assertEquals(0, carrinho.getQtdeItems());		
	}
	
	@DisplayName("Testa o valor total do carrinho")
	@Test
	public void testGetValorTotal() {
		double total = carrinho.getValorTotal();		
		Assertions.assertEquals(250.0, total);		
	}
	
	@DisplayName("Testa remover item do carrinho")
	@Test
	public void testRemoveItem() throws Exception{
		carrinho.removeItem(p1);		
		Assertions.assertEquals(1, carrinho.getQtdeItems());		
	}
	
	@DisplayName("Testa remover item do carrinho vazio")
	@Test
	public void testRemoveItemCarrinhoVazio() {
		Carrinho carrinhoVazio = new Carrinho();
		assertThrows(produto.ProdutoNaoEncontradoException.class,
				() -> carrinhoVazio.removeItem(p1));	
	}
	
}
