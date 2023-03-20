import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {

    static Scanner in = new Scanner(System.in);

    public static void adicionarProduto(){

        String nome;
        double preço;
        TipoProduto tipoProduto;

        System.out.println("Nome:");
        nome = in.nextLine();

        System.out.println("Preço:");
        preço = Double.parseDouble(in.nextLine());

        System.out.println("Tipos de Produto Disponíveis:");
        TipoProduto.tiposProduto.forEach(tipo -> System.out.println(tipo));
        System.out.println("Tipo de Produto Desejado:");
        int id = Integer.parseInt(in.nextLine());

        tipoProduto = TipoProduto.ObterTipoProdutoPorId(id);
        // Perguntar se o Tipo de Produto obtido existe, e se não, avisar



        Produto novoProduto = new Produto(nome, preço);
        Produto.lista.add(novoProduto);

        // Gravar num Ficheiro

        System.out.println("Produto Inserido (Enter para continuar)");
        in.nextLine();
    }

    public static void removerProduto(){
        System.out.println("Introduza o id do produto a remover.");
        int id = Integer.parseInt(in.nextLine());
        boolean removeu = false;

        // Percorrer Lista até encontrar um produto com um id
        for (int i = 0; i < Produto.lista.size(); i++)
        {
            if (Produto.lista.get(i).referência == id)
            {
                // Referência a alterar!
                Produto.lista.remove(i);
                System.out.println("Produto removido.");
                removeu = true;
                // Gravar no Ficheiro
                break;
            }
        }

        if (!removeu)
        {
            System.out.println("Produto não encontrado.");
        }

    }

    public static void obterProdutos(){
        Produto.lista.forEach((produto) -> System.out.println(produto));
    }

    public static void obterProdutosNome(){
        System.out.println("Nome do Produto:");
        String pesquisa = in.nextLine();

        // Sintaxe mais simples
        /*
        ArrayList<Produto> listaFiltrada = new ArrayList<Produto>();
        Produto.lista.forEach((produto) -> {
            if (produto.nome.contains(pesquisa)) {
                listaFiltrada.add(produto);
            }
        });
        */

        List<Produto> listaFiltrada = Produto.lista.stream()
            .filter(produto -> produto.nome.contains(pesquisa))
            .collect(Collectors.toList());

        listaFiltrada.forEach(produto -> System.out.println(produto));

    }

    public static void obterProdutoTipo(){
        System.out.println("A Obter produto por Tipo...");
    }

    public static void display(){

        String opção;

        do
        {
            System.out.println("\n\nSelecione a opção:");
            System.out.println("a) Adicionar Produto");
            System.out.println("b) Remover Produto");
            System.out.println("c) Obter Produtos");
            System.out.println("d) Obter Produtos por Nome");
            System.out.println("e) Obter Produto por TipoProduto");
            System.out.println("s) Sair");

            opção = in.nextLine().toLowerCase();

            switch (opção){

                case "a":
                    adicionarProduto();
                    break;
                case "b":
                    removerProduto();
                    break;
                case "c":
                    obterProdutos();
                    break;
                case "d":
                    obterProdutosNome();
                    break;
                case "e":
                    obterProdutoTipo();
                    break;
                case "s":
                    System.out.println("A sair...");
                    break;

                default:
                    System.out.println("Opção errada.");
                    break;

            }

        } while (!opção.equals("s"));

    }

}
