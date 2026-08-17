import java.util.Scanner;

public class Questao2 {
    static class Pessoa {
        String nome;
        int idade;

        Pessoa(String n, int i) {
            nome = n;
            idade = i;
        }

        int meses() {
            return idade * 12;
        }

        int idade2050(int anoAtual) {
            return idade + 2050 - anoAtual;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();

        System.out.print("Ano atual: ");
        int ano = sc.nextInt();

        Pessoa p = new Pessoa(nome, idade);

        System.out.println("Idade em meses: " + p.meses());
        System.out.println("Idade em 2050: " + p.idade2050(ano));
    }
}