import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private LocalDateTime momento;
    private StatusPedido status;
    private List<ItemPedido> itensPedidos = new ArrayList<>();
    private Cliente cliente;

    DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Pedido(LocalDateTime momento, Cliente cliente, StatusPedido status) {
        this.momento = momento;
        this.cliente = cliente;
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public void setMomento(LocalDateTime momento) {
        this.momento = momento;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void addItem(ItemPedido itemPedido){
        itensPedidos.add(itemPedido);
    }

    public void removerItem(ItemPedido itemPedido){
        itensPedidos.remove(itemPedido);
    }

    public double total(){
        double valorTotal = 0.0;
        for(ItemPedido itemPedido : itensPedidos){
            valorTotal += itemPedido.subTotal();
        }
        return valorTotal;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nRESUMO DO PEDIDO:\n");
        sb.append("Momento do pedido: " + momento.format(fmt2));
        sb.append("\nStatus do pedido: " + status);
        sb.append("\nCliente: " + cliente.getNome() + " (" + cliente.getDataNascimento() + ") - " + cliente.getEmail());
        sb.append("\nItens pedidos:\n");
        for(ItemPedido itemPedido : itensPedidos){
            sb.append(
                    itemPedido.getProduto().getNome()
                    + ", $" + itemPedido.getPreco()
                    + ", Quantidade: " + itemPedido.getQuantidade()
                    + ", Subtotal: " + itemPedido.subTotal() + "\n"
            );
        }
        sb.append("\nPreco total: $" + total());
        return sb.toString();
    }

}
