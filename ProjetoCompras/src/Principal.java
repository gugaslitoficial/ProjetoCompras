import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Favor, digitar o limite do seu cartão! ");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Favor, digitar a descrição de sua compra: ");
            String descricao = leitura.next();

            System.out.println("Favor, digitar o valor de sua compra: ");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada com sucesso!");
                System.out.println("Favor, digite 0 para sair ou 1 para continuar!");
                sair = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }

        System.out.println("**********");
        System.out.println("Ótimo! Sua compra foi realizada com sucesso:\n");

        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }
        System.out.println("\n**********");

        System.out.println("\nSaldo do cartão: " + cartao.getSaldo());
    }
}
