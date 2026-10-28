public class PedidoAlimento extends Pedido{

    public PedidoAlimento(String id, String nomeCliente, double valor, StatusPedido status, Categoria categoria)
            throws ValorInvalidoException {
        super(id, nomeCliente, valor, status, categoria);
    }


    public double calcularValorFinal () {

        double frete = 5;

        return getValor() + frete;
    }

    
}
