import java.util.Scanner;

public class Questao3 {

    static class Produto {
        int numero;
        double preco;

        Produto(int n, double p) {
            numero = n;
            preco = p;
        }

        double desconto() {
            return preco * (preco > 100 ? 0.15 : 0.05);
        }
    }

    static class Cliente {
        int numero;
        String nome;
        char sexo;

        Cliente(int n, String no, char s) {
            numero = n;
            nome = no;
            sexo = s;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Produto[] p = new Produto[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Numero produto: ");
            int n = sc.nextInt();

            double preco;
            do {
                System.out.print("Preco (20 a 350): ");
                preco = sc.nextDouble();
            } while (preco < 20 || preco > 350);

            p[i] = new Produto(n, preco);
        }

        Cliente[] c = new Cliente[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Numero cliente: ");
            int n = sc.nextInt();
            sc.nextLine();

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            char sexo;
            do {
                System.out.print("Sexo (M/F): ");
                sexo = sc.next().charAt(0);
            } while ("MmFf".indexOf(sexo) == -1);

            c[i] = new Cliente(n, nome, sexo);
        }

        System.out.print("Produto: ");
        int np = sc.nextInt();

        System.out.print("Cliente: ");
        int nc = sc.nextInt();

        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();

        Produto produto = null;
        Cliente cliente = null;

        for (Produto x : p)
            if (x.numero == np) produto = x;

        for (Cliente x : c)
            if (x.numero == nc) cliente = x;

        if (produto != null && cliente != null) {
            double valor = produto.preco - produto.desconto();

            if (cliente.sexo == 'F' || cliente.sexo == 'f')
                valor -= produto.preco * 0.05;

            System.out.println("Valor final: R$ " + valor * qtd);
        } else {
            System.out.println("Produto ou cliente inexistente.");
        }
    }
}