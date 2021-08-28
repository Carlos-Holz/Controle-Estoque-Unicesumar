package estoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	List<Produto> produtos;

	public Estoque() {
		this.produtos = new ArrayList<Produto>();
	}

	public int size() {
		return this.produtos.size();
	}

	public void incluirProduto(Produto produto) {
		this.produtos.add(produto);
	}

	public void removeProduto(Produto produto) {
		this.produtos.remove(produto);
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public String imprimir() {
		System.out.println("\n--------------------------");
		String produtosString = "";
		for (Produto produto : this.produtos) {
			produtosString += "Nome: " + produto.getNome() + "\n" + "Preço: " + produto.getPrecoUnitario() + "\n"
					+ "Unidade: " + produto.getUnidade() + "\n" + "Quantidade: " + produto.getQuantidade() + "\n"
					+ "Valor Total: " + produto.getPrecoUnitario() * produto.getQuantidade() + "\n--------------------------\n";
		}
		return produtosString;
	}

	public void atualizarProduto(Produto produto, Produto novoProduto) {
		this.produtos.remove(produto);
		this.produtos.add(novoProduto);
	}

	public boolean existeProduto(String nome) {
		for (Produto produto : this.produtos) {
			if (produto.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}

	public Produto getProduto(String nome) {
		for (Produto produto : this.produtos) {
			if (produto.getNome().equals(nome)) {
				return produto;
			}
		}
		return null;
	}

}
