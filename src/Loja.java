import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileReader;

public class Loja {
    private String nome;
    private ArrayList<Produto> estoque = new ArrayList<>();

    public Loja(String nome) {
        setNome(nome);
    }

    public Loja(String nome, ArrayList<Produto> estoque) {
        this.nome = nome;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        if(nome.isEmpty() || nome.isBlank()){
            throw new IllegalArgumentException("Nome inserido é vazio.");
        }
        this.nome = nome;
        return true;
    }

    public ArrayList<Produto> getEstoque() {
        return estoque;
    }

    public void definirEstoque(){
        try (Scanner arquivo = new Scanner(new FileReader("items.csv"))) {
            arquivo.nextLine();
            while (arquivo.hasNext()){
                String[] produtoInfo = arquivo.nextLine().split(";");
                String codigo = produtoInfo[0];
                String nome = produtoInfo[1];
                double preco = Double.parseDouble(produtoInfo[2]);
                int quantidade = Integer.parseInt(produtoInfo[3]);
                estoque.add(new Produto(nome,codigo,preco, quantidade));
                organizarEstoque();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void exibirEstoque(){
        for (Produto produto: estoque
             ) {
            System.out.println("Produto:"+produto.getNome()+"- Quantidade:"+produto.getQuantidade()+ "- Preço"+produto.getPreco());
        }
    }

    public void organizarEstoque(){
        Collections.sort(estoque);
    }

    public void mostrarItensFaltando(){
        System.out.println("\n\nEsses são os 10 produtos com menos quantidade e devem ser repostos");
        estoque.stream().limit(10).forEach(e -> System.out.println(e.getNome() + " - Quantidade: " + e.getQuantidade()));

    }

}
