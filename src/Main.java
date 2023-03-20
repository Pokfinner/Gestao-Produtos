import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {

            String listaString = "";

            // Para ler Ficheiros e importá-los para novo Produto

            Scanner leitorProduto = new Scanner(Produto.produtosFicheiro);
            while(leitorProduto.hasNextLine())
            {
                String produtoString = leitorProduto.nextLine();
                listaString += produtoString;

                String[] elementosProduto = produtoString.split(" | ");
                String nome = elementosProduto[2];
                String preço = elementosProduto[4].substring(0, elementosProduto[4].length() - 1);

                Produto.lista.add(new Produto(nome, Double.parseDouble(preço)));
            }

            // Aqui, a lista já está preenchida!

            // Para Escrever Ficheiros
            /*

            Produto.lista.add(new Produto("Maçã", 2.00));
            Produto.lista.add(new Produto("Pêra", 3.00));
            Produto.lista.add(new Produto("Abacate", 4.00));

            String produtosString = "";

            for (int i = 0; i < Produto.lista.size(); i++)
            {
                produtosString += Produto.lista.get(i).toString();
                produtosString += "\n";
            }

            FileWriter escreverFicheiro = new FileWriter("produtos.txt");
            escreverFicheiro.write(produtosString);
            escreverFicheiro.close();

            */

        }
        catch(IOException e)
        {
            System.out.println("erro");
            e.printStackTrace();
        }

        Produto.InicializarFicheiro();


        // Menu.display();

    }
}