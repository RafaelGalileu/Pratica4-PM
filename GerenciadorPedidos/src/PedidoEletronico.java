public class PedidoEletronico extends Pedido{

    public PedidoEletronico(String id, String nomeCliente, double valor, StatusPedido status, Categoria categoria)
            throws ValorInvalidoException {
        super(id, nomeCliente, valor, status, categoria);
    
    
    }

    public double calcularValorFinal() {

        if (this.getValor() > 100) {
            
            double valorFinal =  getValor() - (getValor() * 0.1);
        
            return valorFinal + 20 + (valorFinal * 0.1);
        
        }   

        else {
            
            return getValor() + 20;
        }
    }
    


}
