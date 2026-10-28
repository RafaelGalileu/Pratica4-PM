public abstract class Pedido implements Processavel{

    private String id;
    private String nomeCliente;
    private double valor;
    private StatusPedido status;
    private Categoria categoria;

    public Pedido(String id, String nomeCliente, double valor, StatusPedido status, Categoria categoria)
            throws ValorInvalidoException {

        if (valor <= 0) {

            throw new ValorInvalidoException("Valor Invalido");
        }

        this.id = id;
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.status = status;
        this.categoria = categoria;
    }

    public void processarPedido() throws PedidoInvalidoException {

        if (getStatus() == StatusPedido.CANCELADO) {

            throw new PedidoInvalidoException("Pedido cancelado não pode ser processado");
        } else if (getStatus() == StatusPedido.ENTREGUE) {

            throw new PedidoInvalidoException("Pedido entregue não pode mudar de status");
        }

        setStatus(StatusPedido.PROCESSANDO);

        System.out.println("Pedido processado");

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
