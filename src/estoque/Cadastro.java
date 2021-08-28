package estoque;

import java.util.Scanner;

public class Cadastro {

	public static void inicial(Estoque estoque) {
		boolean holz = true;
		Scanner tec = new Scanner(System.in);
		while (holz) {
			System.out.println("\nINDÚSTRIAS HOLZ EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE\n");
			switch (menuCadastro()) {
			case 0:
				holz = false;
				break;
			case 1:
				incluir(estoque);
				break;
			case 2:
				alterar(estoque);
				break;
			case 3:
				consultar(estoque);
				break;
			case 4:
				excluir(estoque);
				break;
			default:
				System.out.println("Opção Inválida!!!");
				break;
			}
		}
	}

	public static int menuCadastro() {
		Scanner tec = new Scanner(System.in);
		System.out.println("|----- CADASTRO DE PRODUTO -----|");
		System.out.println("|1 - INCLUSÃO                   |");
		System.out.println("|2 - ALTERAÇÃO                  |");
		System.out.println("|3 - CONSULTA                   |");
		System.out.println("|4 - EXCLUSÃO                   |");
		System.out.println("|0 - RETORNAR                   |");
		System.out.println("|-------------------------------|");
		System.out.println("\n");
		System.out.print("Informe a opção desejada: ");
		try {
			return tec.nextInt();
		} catch (Exception e) {
			return -1;
		}
	}

	public static void alterar(Estoque estoque) {
		boolean holz = true;
		Scanner tec = new Scanner(System.in);
		String nomeProduto = "";
		String unidade;
		int quantidade;
		double precoUnitario;
		Produto produto;
		while (holz) {
			System.out.println("\nINDÚSTRIAS HOLZ EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE\n");
			System.out.println("ALTERAÇÃO DE PRODUTO\n");
			System.out.print("Nome: ");
			nomeProduto = tec.nextLine();
			produto = estoque.getProduto(nomeProduto);
			if (produto == null) {
				System.out.print("Produto não cadastrado!!");
				holz = false;
				tec.nextLine();
			} else {
				System.out.println("Preço: " + produto.getPrecoUnitario());
				System.out.print("Novo Preço: ");
				try {
					precoUnitario = Double.valueOf(tec.nextLine()).doubleValue();
				} catch (Exception e) {
					System.out.println("\nPreço Inválido!!!\n");
					System.out.println("Inserir apenas números com ponto [Ex: 1.50]");
					tec.nextLine();
					return;
				}
				System.out.println("Unidade: " + produto.getUnidade());
				System.out.print("Nova Unidade: ");
				unidade = String.valueOf(tec.nextLine());
				System.out.println("Quantidade: " + produto.getQuantidade());
				System.out.print("Nova Quantidade: ");
				try {
					quantidade = Integer.parseInt(tec.nextLine());
				} catch (Exception e) {
					System.out.println("\nQuantidade inválido!!!\n");
					System.out.println("Inserir apenas números com ponto [Ex: 1.50]");
					tec.nextLine();
					return;
				}
				if (precoUnitario <= 0) {
					System.out.println("\nPreço Inválido!!!\n");
					System.out.println("Insira um preço maior que zero: ");
					tec.nextLine();
				} else if (quantidade <= 0) {
					System.out.println("\nQuantidade inválida!!!\n");
					System.out.println("Insira uma quantidade maior que zero: ");
					tec.nextLine();
				} else {
					Produto p = new Produto(nomeProduto, precoUnitario, unidade, quantidade);
					System.out.print("\nConfirmar Alteração [S/N] -> ");
					if (tec.nextLine().equalsIgnoreCase("S")) {
						estoque.atualizarProduto(estoque.getProduto(p.getNome()), p);
						System.out.println("\nProduto Alterado com sucesso!!!\n");
					}
					System.out.print("REPETIR OPERAÇÃO [S/N] -> ");
					if (tec.nextLine().equalsIgnoreCase("N")) {
						holz = false;
					}
				}
			}
		}
	}

	public static void incluir(Estoque estoque) {
		boolean holz = true;
		Scanner tec = new Scanner(System.in);
		String nomeProduto = "";
		String unidade;
		int quantidade;
		double precoUnitario;
		while (holz) {
			System.out.println("\nINDÚSTRIAS HOLZ EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE\n");
			System.out.println("INCLUSÃO DE PRODUTO\n");
			System.out.print("Nome: ");
			nomeProduto = tec.nextLine();
			System.out.print("Preço: ");
			try {
				precoUnitario = Double.valueOf(tec.nextLine()).doubleValue();
			} catch (Exception e) {
				System.out.println("\nPreço Inválido!!\n");
				System.out.print("Inserir apenas números com ponto [Ex: 1.50]");
				tec.nextLine();
				return;
			}
			System.out.print("Unidade: ");
			unidade = String.valueOf(tec.nextLine());
			System.out.print("Quantidade: ");
			try {
				quantidade = Integer.parseInt(tec.nextLine());
			} catch (Exception e) {
				System.out.println("\nQuantidade inválida!!\n");
				System.out.print("Inserir apenas números com ponto [Ex: 1.50]");
				tec.nextLine();
				return;
			}
			if (estoque.existeProduto(nomeProduto)) {
				System.out.println("\nProduto já cadastrado no estoque!!\n");
				System.out.print("Insira com outro nome ou atualize o produto existente: ");
				tec.nextLine();
			} else if (precoUnitario <= 0) {
				System.out.println("\nPreço inválido!!\n");
				System.out.print("Insira um preço maior que zero: ");
				tec.nextLine();
			} else if (quantidade <= 0) {
				System.out.println("\nQuantidade inválida!!\n");
				System.out.print("Insira uma quantidade maior que zero: ");
				tec.nextLine();
			} else {
				Produto p = new Produto(nomeProduto, precoUnitario, unidade, quantidade);
				System.out.print("\nConfirmar inclusão [S/N] -> ");
				if (tec.nextLine().equalsIgnoreCase("S")) {
					estoque.incluirProduto(p);
					System.out.println("\nProduto incluído com sucesso!!\n");
				}
				System.out.print("REPETIR OPERAÇÃO [S/N] -> ");
				if (tec.nextLine().equalsIgnoreCase("N")) {
					holz = false;
				}
			}

		}
	}

	public static void consultar(Estoque estoque) {
		boolean holz = true;
		Scanner tec = new Scanner(System.in);
		String nomeProduto = "";
		while (holz) {
			System.out.println("\nINDÚSTRIAS HOLZ EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE\n");
			System.out.println("CONSULTAR PRODUTO\n");
			System.out.print("Nome: ");
			nomeProduto = tec.nextLine();
			Produto produto = estoque.getProduto(nomeProduto);
			if (produto == null) {
				System.out.println("\nProduto não encontrado");
				System.out.println("Insira um produto existente no estoque!!");
				System.out.print("(Digite 'S' para sair) -> ");
				if (tec.nextLine().equalsIgnoreCase("S")) {
					holz = false;
				}
			} else {
				System.out.println("Preço: " + produto.getPrecoUnitario());
				System.out.println("Unidade: " + produto.getUnidade());
				System.out.println("Quantidade: " + produto.getQuantidade());
				System.out.print("\nREPETIR OPERAÇÃO [S/N] -> ");
				if (tec.nextLine().equalsIgnoreCase("N")) {
					holz = false;
				}
			}
		}
	}

	public static void excluir(Estoque estoque) {
		boolean holz = true;
		Scanner tec = new Scanner(System.in);
		String nomeProduto = "";
		while (holz) {
			System.out.println("\nINDÚSTRIAS HOLZ EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE\n");
			System.out.println("EXCLUSÃO DE PRODUTO\n");
			System.out.print("Nome: ");
			nomeProduto = tec.nextLine();
			if (estoque.existeProduto(nomeProduto)) {
				Produto p = estoque.getProduto(nomeProduto);
				System.out.println("Preço: " + p.getPrecoUnitario());
				System.out.println("Unidade " + p.getUnidade());
				System.out.println("Quantidade " + p.getQuantidade());
				System.out.print("\nConfirmar exclusão [S/N] -> ");
				if (tec.nextLine().equalsIgnoreCase("S")) {
					estoque.removeProduto(estoque.getProduto(p.getNome()));
					System.out.println("\nProduto excluído com sucesso!!!\n");
				}
				System.out.print("REPETIR OPERAÇÃO [S/N] -> ");
				if (tec.nextLine().equalsIgnoreCase("N")) {
					holz = false;
				}
			} else {
				System.out.println("\nProduto não encontrado!!!\n");
				System.out.println("Insira um produto existente: ");
				System.out.print("(Digite 'S' para sair) -> ");
				if (tec.nextLine().equalsIgnoreCase("S")) {
					holz = false;
				}
			}
		}
	}

}
