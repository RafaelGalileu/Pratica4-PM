import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);

        ArrayList<Pedido> pedidos = new ArrayList<>();

        int escolha = 0;

        while (escolha != 7) {

            System.out.println("1 - Cadastrar pedido\r\n" + //
                    "2 - Alterar o status de um pedido\r\n" + //
                    "3 - Processar pedido: deve usar Iterator para processar todos os pedidos cadastrados\r\n" + //
                    "4 - Remover cancelados: deve usar Iterator para remover todos os pedidos cancelados da lista\r\n" + //
                    "5 - Exibir lista de pedidos: n˜ao deve exibir os cancelados\r\n" + //
                    "6 - Exibir pedidos entreg´aveis\r\n" + //
                    "7 - Encerrar");

            escolha = entrada.nextInt();
            entrada.nextLine();

            if (escolha == 1) {

                System.out.println("Digite o ID do pedido");
                String id = entrada.nextLine();

                System.out.println("Digite o nome do pedido");
                String nome = entrada.nextLine();

                System.out.println("Digite o valor do pedido");
                double valor = entrada.nextDouble();

                int categ = 0;
                Categoria categoria;
                do {
                    System.out.println("Digite a categoria do pedido");
                    System.out.println(" 1 - Alimento");
                    System.out.println("2 - Eletronico");
                    System.out.println("3 - Roupa");
                    categ = entrada.nextInt();
                    entrada.nextLine();

                    if (categ == 1) {
                        categoria = Categoria.ALIMENTO;

                        Pedido novoPedido = new PedidoAlimento(id, nome, valor, StatusPedido.PENDENTE, categoria);

                        pedidos.add(novoPedido);

                        System.out.println("Pedido cadastrado");

                    } else if (categ == 2) {
                        categoria = Categoria.ELETRONICO;

                        Pedido novoPedido = new PedidoEletronico(id, nome, valor, StatusPedido.PENDENTE, categoria);

                        pedidos.add(novoPedido);

                        System.out.println("Pedido cadastrado");
                    } else if (categ == 3) {
                        categoria = Categoria.ROUPA;

                        Pedido novoPedido = new PedidoRoupa(id, nome, valor, StatusPedido.PENDENTE, categoria);

                        pedidos.add(novoPedido);

                        System.out.println("Pedido cadastrado");
                    } else {
                        System.out.println("Escolha inválida, digite novamente");
                    }
                } while (categ < 1 || categ > 3);

            }

            else if (escolha == 2) {

                System.out.println("Digite o ID do pedido que deseja alterar o status");
                String id = entrada.nextLine();

                Iterator<Pedido> it = pedidos.iterator();

                while (it.hasNext()) {
                    Pedido pedido = it.next();

                    if (pedido.getId().equals(id)) {

                        int stat = 0;

                        do {

                            System.out.println(" 1 - Processando");
                            System.out.println("2 - Enviado");
                            System.out.println("3 - Entregue");
                            System.out.println("4 - Cancelado");
                            System.out.println("Digite o status desejado");

                            stat = entrada.nextInt();
                            entrada.nextLine();

                            if (stat == 1) {
                                StatusPedido status = StatusPedido.PROCESSANDO;

                                pedido.setStatus(status);

                            }

                            else if (stat == 2) {
                                StatusPedido status = StatusPedido.ENVIADO;

                                pedido.setStatus(status);
                            } else if (stat == 3) {
                                StatusPedido status = StatusPedido.ENTREGUE;

                                pedido.setStatus(status);
                            } else if (stat == 4) {
                                StatusPedido status = StatusPedido.CANCELADO;

                                pedido.setStatus(status);
                            } else {
                                System.out.println("Opção inválida");
                            }

                        } while (stat < 1 || stat > 4);

                        break;
                    }

                }

                System.out.println("ID não encontrado");
            }

            else if (escolha == 3) {

                Iterator<Pedido> it = pedidos.iterator();

                while (it.hasNext()) {

                    Pedido pedido = it.next();

                    System.out.println("ID: " + pedido.getId());
                    pedido.processarPedido();
                    System.out.println("------------");

                }

            }

            else if (escolha == 4) {

                Iterator<Pedido> it = pedidos.iterator();

                while (it.hasNext()) {
                    Pedido pedido = it.next();

                    if (pedido.getStatus().equals(StatusPedido.CANCELADO)) {

                        System.out.println("ID: " + pedido.getId());
                        System.out.println("Removido");
                        System.out.println("------------");

                        it.remove();

                    }
                }
            }

            else if (escolha == 5) {

                Iterator<Pedido> it = pedidos.iterator();

                while (it.hasNext()) {
                    Pedido pedido = it.next();

                    if (!pedido.getStatus().equals(StatusPedido.CANCELADO)) {

                        System.out.println(pedido.toString());

                        System.out.println("------------");
                    }

                }
            }

            else if (escolha == 6) {

                Iterator<Pedido> it = pedidos.iterator();

                while (it.hasNext()) {
                    Pedido pedido = it.next();

                    if (pedido instanceof Entregavel) {

                        System.out.println(pedido.toString());

                        System.out.println("------------");
                    }

                }
            }

            else if (escolha == 7) {
                System.out.println("Encerrando programa");
            }

            else {
                System.out.println("Escolha inválida");
            }
        }

        entrada.close();
    }

}
