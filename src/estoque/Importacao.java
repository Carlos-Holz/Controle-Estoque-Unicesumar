package estoque;

import java.util.Scanner;

class Importacao {

	public static void main(String[] args) {
		boolean holz = true;
		Estoque estoque = new Estoque();
		Scanner tec = new Scanner(System.in);
		while (holz) {
			System.out.println("\nIND�STRIAS HOLZ EMPRESA DE IMPORTA��O DE PRODUTOS LTDA");
			System.out.println("SISTEMA DE CONTROLE DE ESTOQUE\n");
			switch (menuPrincipal()) {
			case 0:
				holz = false;
				break;
			case 1:
				Cadastro.inicial(estoque);
				break;
			case 2:
				Movimento.inicial(estoque);
				break;
			case 3:
				reajuste(estoque);
				break;
			case 4:
				if (estoque.size() > 0) {
					System.out.println(estoque.imprimir());
					tec.nextLine();
				} else {
					System.out.println("N�o h�! produtos no estoque.");
					tec.nextLine();
				}
				break;
			default:
				System.out.println("Op��o Inv�lida!!!");
				break;
			}
		}
	}

	public static int menuPrincipal() {
		Scanner tec = new Scanner(System.in);
		System.out.println("|----- MENU PRINCIPAL -----|");
		System.out.println("|1 - CADASTRO DE PRODUTO   |");
		System.out.println("|2 - MOVIMENTA��O          |");
		System.out.println("|3 - REAJUSTE DE PRE�O     |");
		System.out.println("|4 - RELATORIOS            |");
		System.out.println("|0 - FINALIZAR             |");
		System.out.println("|--------------------------|");
		System.out.println("\n");
		System.out.print("Informe a op��o desejada: ");
		try {
			return tec.nextInt();
		} catch (Exception e) {
			return -1;
		}
	}

	public static void reajuste(Estoque estoque) {
		System.out.println("\n");
		Scanner tec = new Scanner(System.in);
		System.out.println("\n\nREAJUSTE DE PRE�O");
		System.out.println("Qual produto tera reajuste?");
		System.out.print("Nome: ");
		String nomeProduto = tec.nextLine();
		if (estoque.existeProduto(nomeProduto)) {
			Produto p = estoque.getProduto(nomeProduto);
			System.out.println("Pre�o atual R$ " + p.getPrecoUnitario());
			System.out.print("Porcentagem de reajuste: ");
			double porcentagem = Integer.parseInt(tec.nextLine());
			p.setPrecoUnitario(p.getPrecoUnitario() * (1 + porcentagem / 100));
			System.out.println("Novo pre�o R$ " + p.getPrecoUnitario());
			System.out.println("Confirmar Reajuste [S/N] -> ");
			if (tec.next().equals("S")) {
				estoque.atualizarProduto(estoque.getProduto(nomeProduto), p);
			}
			tec.nextLine();
		} else {
			System.out.println("Produto n�o encontrado!!");
			tec.nextLine();
		}
	}

}
