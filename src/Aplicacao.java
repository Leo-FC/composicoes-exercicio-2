import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Informe os dados do cliente:");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Data de nascimento: ");
        LocalDate dataNascimento = LocalDate.parse(sc.nextLine(), fmt1);
        //String dataNascimento = sc.nextLine();
        //LocalDate datNasc = LocalDate.parse(dataNascimento, fmt1);

        System.out.println("Informe os dados do pedido:");

        System.out.print("Status: ");
        String statusPedido = sc.nextLine();

        Pedido pedido1 = new Pedido(
                LocalDateTime.now(),
                new Cliente(nome, email, dataNascimento),
                StatusPedido.valueOf(statusPedido)
        );

        System.out.print("Quantos items nesse pedido?: ");
        int qtd = sc.nextInt();

        for(int i = 0; i < qtd ; i++){
            sc.nextLine();

            System.out.printf("Entre com dados do #%d item:\n", i + 1);
            System.out.print("Nome do produto: ");
            String nomeProduto = sc.nextLine();

            System.out.print("Preco do produto: ");
            double precoProduto = sc.nextDouble();

            System.out.print("Quantidade: ");
            int qtdProduto = sc.nextInt();

            pedido1.addItem(new ItemPedido(qtdProduto, precoProduto,
                    new Produto(nomeProduto, precoProduto)));
        }

        System.out.print(pedido1);
    }
}
