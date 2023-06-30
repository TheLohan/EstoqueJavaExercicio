public class Produto implements Comparable{
    private String nome;
    private String codigo;
    private double preco;
    private int quantidade;

    public Produto(String nome, String codigo, double preco, int quantidade) {
        setNome(nome);
        setCodigo(codigo);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome){
        if(nome.isEmpty() || nome.isBlank()){
            throw new IllegalArgumentException("Nome inserido é vazio.");
        }
        this.nome = nome;
        return true;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean setCodigo(String codigo){
        if(codigo.isEmpty() || codigo.isBlank()){
            throw new IllegalArgumentException("codigo inserido é vazio.");
        }
        this.codigo = codigo;
        return true;
    }

    public double getPreco() {
        return preco;
    }

    public boolean setPreco(double preco){
        if(preco < 0){
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.preco = preco;
        return true;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade < 0){
            throw new IllegalArgumentException("Quantidade não pode ser negativo");
        }
        this.quantidade = quantidade;
    }

    @Override
    public int compareTo(Object o) {
        Produto produtoComparado = (Produto) o;
        if(this.quantidade < produtoComparado.quantidade){
            return -1;
        } else if (this.quantidade > produtoComparado.quantidade) {
            return 1;
        }
        else if(this.preco < produtoComparado.preco){
            return -1;
        } else if (this.preco > produtoComparado.preco) {
            return 1;
        }
        return 0;
    }
}

