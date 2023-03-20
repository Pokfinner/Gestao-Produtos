import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Produto {

    static int id_referência = 1;
    static ArrayList<Produto> lista = new ArrayList<Produto>();

    // Ficheiro para guardar localmente os produtos
    static File produtosFicheiro = new File("produtos.txt");

    int referência;
    double preço;
    String nome;
    String validade;
    TipoProduto tipo;

    public static void InicializarFicheiro(){
        try {
            if (Produto.produtosFicheiro.createNewFile())
            {
                System.out.println("Ficheiro criado: " + Produto.produtosFicheiro.getName());
            }
            else
            {
                System.out.println("Ficheiro já existente");
            }
        }
        catch(IOException e){
            System.out.println("Erro.");
            e.printStackTrace();
        }
    }

    public void setReferência(){
        this.referência = id_referência;
        id_referência++;
    }

    public Produto(){
        nome = "undefined";
        setReferência();
    }

    public Produto(String nome, double preço){
        this.nome = nome;
        this.preço = preço;
        setReferência();
    }

    @Override
    public String toString(){
        return referência + " | " + nome + " - " + preço + "€";
    }

}
