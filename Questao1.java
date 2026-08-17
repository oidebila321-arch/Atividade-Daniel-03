import java.util.Scanner;

public class Questao1 {
    static class Carro {
        String placa;
        int ano;

        Carro(String p, int a) {
            placa = p;
            ano = a;
        }

        double imposto(int atual) {
            int idade = atual - ano;
            if (idade >= 9) return 0;
            return Math.max(100, 500 - idade * 100);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carro[] carros = new Carro[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Placa: ");
            String placa = sc.next();
            System.out.print("Ano: ");
            int ano = sc.nextInt();
            carros[i] = new Carro(placa, ano);
        }

        System.out.print("Ano atual: ");
        int atual = sc.nextInt();

        double total = 0;
        int semImposto = 0;

        for (Carro c : carros) {
            double imposto = c.imposto(atual);
            System.out.println(c.placa + " - R$ " + imposto);
            total += imposto;
            if (imposto == 0) semImposto++;
        }

        System.out.println("Total: R$ " + total);
        System.out.println("Sem imposto: " + semImposto);
    }
}