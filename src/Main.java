import controller.EstoqueController;
import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> estoque = new ArrayList<>();
        Produto produto;
        EstoqueController estoqueController = new EstoqueController();

        System.out.println("Digite o nome do mercado: ");
        String nomeMercado  = scanner.nextLine();

        boolean loop = true;

        while (loop){
            System.out.println("Digite o numero da opção desejada:");
            System.out.println("1 - Cadastrar produto" +
                               "\n2 - Listar produtos" +
                               "\n3 - Sair");
            int opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("======== CADASTRO DE PRODUTO ========");
                    produto = CadastrarProduto();
                    estoque.add(produto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("======== PRODUTOS ========");
                    estoqueController.listarProdutos(estoque);
                    break;
                case 3:
                    System.out.println("======== Saindo do programa ========");
                    System.out.println("Obrigado por usar o sistema de estoque do " + nomeMercado + "!");
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static Produto CadastrarProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();
        return new Produto(nome, preco, quantidade);
    }
}