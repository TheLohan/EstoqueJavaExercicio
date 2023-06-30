public class Main {
    public static void main(String[] args) {
        Loja IcariShop = new Loja("Icara Shop");
        IcariShop.definirEstoque();
        IcariShop.exibirEstoque();
        IcariShop.mostrarItensFaltando();
    }
}