public class PedidoEletronico extends Pedido implements Entregavel {

    public PedidoEletronico(String id, String nomeCliente, double valor, StatusPedido status, Categoria categoria)
            throws ValorInvalidoException {
        super(id, nomeCliente, valor, status, categoria);

    }

    public double calcularFrete() {
        double frete = 20 + (getValor() * 0.1);
        return frete;
    }

    public double calcularValorFinal() {

        double frete = calcularFrete();

        if (this.getValor() > 100) {

            double desconto = getValor() * 0.1;

            return getValor() - desconto + frete;

        }

        else {

            return getValor() + frete;
        }
    }

}
