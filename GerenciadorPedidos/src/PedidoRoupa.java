public class PedidoRoupa extends Pedido{

    public PedidoRoupa(String id, String nomeCliente, double valor, StatusPedido status, Categoria categoria)
            throws ValorInvalidoException {
        super(id, nomeCliente, valor, status, categoria);
    }


    public double calcularFrete() {
        double frete = 20 + (getValor() * 0.1);
        return frete;
    }

    public double calcularValorFinal () {

        double frete = calcularFrete();

        if (getValor() > 200) {
            
            double desconto =   getValor() * 0.2;

            return getValor() - desconto + frete;
        }

        else {
            return getValor() + frete;
        }

    }
}
