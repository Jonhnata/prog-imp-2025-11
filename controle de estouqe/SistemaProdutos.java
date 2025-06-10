import java.util.Scanner;

public class SistemaProdutos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Produto[] produtos = new Produto[50];
        int total = 0;
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Filtrar por categoria");
            System.out.println("4 - Ordenar por nome");
            System.out.println("5 - Remover produto");
            System.out.println("6 - Atualizar preço");
            System.out.println("7 - Subtotal por categoria");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = input.nextInt();
            input.nextLine(); // limpa buffer

            switch (opcao) {
                case 1:
                    Produto p = new Produto();
                    System.out.print("Nome: ");
                    p.nome = input.nextLine();
                    System.out.print("Quantidade em estoque: ");
                    p.quantidade = input.nextInt();
                    System.out.print("Preço unitário: ");
                    p.preco = input.nextDouble();
                    input.nextLine();
                    System.out.print("Categoria: ");
                    p.categoria = input.nextLine();
                    System.out.print("Quantidade mínima: ");
                    p.qtdMinima = input.nextInt();
                    input.nextLine();

                    produtos[total] = p;
                    total++;
                    break;

                case 2:
                    for (int i = 0; i < total; i++) {
                        mostrar(produtos[i]);
                    }
                    break;

                case 3:
                    System.out.print("Categoria para filtrar: ");
                    String cat = input.nextLine();
                    for (int i = 0; i < total; i++) {
                        if (produtos[i].categoria.equalsIgnoreCase(cat)) {
                            mostrar(produtos[i]);
                        }
                    }
                    break;

                case 4:
                    for (int i = 0; i < total - 1; i++) {
                        for (int j = i + 1; j < total; j++) {
                            if (produtos[i].nome.compareToIgnoreCase(produtos[j].nome) > 0) {
                                Produto aux = produtos[i];
                                produtos[i] = produtos[j];
                                produtos[j] = aux;
                            }
                        }
                    }
                    System.out.println("Produtos ordenados por nome.");
                    break;

                case 5:
                    System.out.print("Nome do produto a remover: ");
                    String nomeRemover = input.nextLine();
                    boolean achou = false;
                    for (int i = 0; i < total; i++) {
                        if (produtos[i].nome.equalsIgnoreCase(nomeRemover)) {
                            for (int j = i; j < total - 1; j++) {
                                produtos[j] = produtos[j + 1];
                            }
                            produtos[total - 1] = null;
                            total--;
                            achou = true;
                            break;
                        }
                    }
                    if (achou) {
                        System.out.println("Produto removido.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("Nome do produto para atualizar o preço: ");
                    String nomeAtualizar = input.nextLine();
                    boolean atualizado = false;
                    for (int i = 0; i < total; i++) {
                        if (produtos[i].nome.equalsIgnoreCase(nomeAtualizar)) {
                            System.out.print("Novo preço: ");
                            produtos[i].preco = input.nextDouble();
                            input.nextLine();
                            atualizado = true;
                            System.out.println("Preço atualizado.");
                            break;
                        }
                    }
                    if (!atualizado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 7:
                    System.out.print("Categoria para subtotal: ");
                    String catSubtotal = input.nextLine();
                    double subtotal = 0;
                    for (int i = 0; i < total; i++) {
                        if (produtos[i].categoria.equalsIgnoreCase(catSubtotal)) {
                            subtotal += produtos[i].quantidade * produtos[i].preco;
                        }
                    }
                    System.out.println("Subtotal em estoque da categoria '" + catSubtotal + "': R$" + subtotal);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static void mostrar(Produto p) {
        System.out.println("\nNome: " + p.nome);
        System.out.println("Qtd em estoque: " + p.quantidade);
        System.out.println("Preço: R$" + p.preco);
        System.out.println("Categoria: " + p.categoria);
        System.out.println("Qtd mínima: " + p.qtdMinima);
    }
}
