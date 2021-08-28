package estoque;

import java.util.Scanner;

public class Movimento {

    public static void inicial(Estoque estoque){
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
                    entrada(estoque);
                    break;
                case 2:
                    saida(estoque);
                    break;
                default:
                    System.out.println("Opção Inválida!!");
                    break;
            }
        }
    }

    public static int menuCadastro() {
        Scanner tec = new Scanner(System.in);
        System.out.println("|----- MOVIMENTAÇÃO -----|");
        System.out.println("|1- ENTRADA              |");
        System.out.println("|2- SAIDA                |");
        System.out.println("|0- RETORNAR             |");
        System.out.println("|------------------------|");
        System.out.println("\n");
        System.out.print("Informe a opção desejada: ");
        try {
            return tec.nextInt();
        } catch (Exception e) {
            return -1;
        }
    }

    public static void entrada(Estoque estoque){
        Scanner tec = new Scanner(System.in);
        System.out.println("\nINDÚSTRIAS HOLZ EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("SISTEMA DE CONTROLE DE ESTOQUE\n");
        System.out.println("MOVIMENTAÇÃO");
        System.out.println("ENTRADA DE PRODUTO\n");
        System.out.print("PRODUTO: ");
        Produto p = estoque.getProduto(tec.next());
        if (p == null) {
            System.out.println("Produto não cadastrado!!");
            return;
        } else {
            System.out.println("Quantidade Atual: " + p.getQuantidade());
            System.out.print("Quantidade Entrada: ");
            int q = tec.nextInt();
            System.out.println("Quantidade Final: " + (p.getQuantidade() + q));
            p.setQuantidade(p.getQuantidade() + q);
            System.out.print("\nDeseja realmente efetuar está entrada [S/N] -> ");
            if (tec.next().equals("S")) {
                estoque.atualizarProduto(estoque.getProduto(p.getNome()), p);
            }
        }
    }

    public static void saida(Estoque estoque){
        Scanner tec = new Scanner(System.in);
        System.out.println("\nINDÚSTRIAS HOLZ EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA");
        System.out.println("SISTEMA DE CONTROLE DE ESTOQUE\n");
        System.out.println("MOVIMENTAÇÃO");
        System.out.println("SAÍDA DE PRODUTO\n");
        System.out.print("PRODUTO: ");
        Produto p = estoque.getProduto(tec.next());
        if (p == null) {
            System.out.println("Produto não cadastrado!");
            return;
        } else {
            System.out.println("Quantidade Atual: " + p.getQuantidade());
            System.out.print("Quantidade Saida: ");
            int q = tec.nextInt();
            System.out.println("Quantidade Final: " + (p.getQuantidade() - q));
            p.setQuantidade(p.getQuantidade() - q);
            System.out.print("\nDeseja realmente efetuar está saída [S/N] -> ");
            if (tec.next().equals("S")) {
                estoque.atualizarProduto(estoque.getProduto(p.getNome()), p);
            }
        }
    }
}
