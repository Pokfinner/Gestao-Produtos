import java.util.ArrayList;

public class TipoProduto {

    static ArrayList<TipoProduto> tiposProduto;
    {
        tiposProduto.add(new TipoProduto(1, "Bolos", true, 0.23));
        tiposProduto.add(new TipoProduto(2, "Pão", false, 0.13));
        tiposProduto.add(new TipoProduto(3, "Fruta", false, 0.06));
        tiposProduto.add(new TipoProduto(4, "Leite", true, 0.06));
    }

    static TipoProduto ObterTipoProdutoPorId(int id){

        for (int i = 0; i < tiposProduto.size(); i++)
        {
            if (tiposProduto.get(i).id == id) return tiposProduto.get(i);
        }
        return null;

    }


    int id;
    String tipo;
    boolean porUnidade;
    double IVA;

    public TipoProduto(int id, String tipo, boolean porUnidade, double IVA) {
        this.id = id;
        this.tipo = tipo;
        this.porUnidade = porUnidade;
        this.IVA = IVA;
    }
}
