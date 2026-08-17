import java.util.Scanner;

public class Questao5 {

    static class Funcionario {
        int numero;
        String nome, cargo;
        double salario;

        Funcionario(int numero, String nome, String cargo, double salario) {
            this.numero = numero;
            this.nome = nome;
            this.cargo = cargo;
            this.salario = salario;
        }
    }

    static class Dependente {
        String nome;
        Funcionario funcionario;

        Dependente(String nome, Funcionario funcionario) {
            this.nome = nome;
            this.funcionario = funcionario;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Numero do funcionario: ");
        int numero = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome do funcionario: ");
        String nome = sc.nextLine();

        System.out.print("Cargo: ");
        String cargo = sc.nextLine();

        System.out.print("Salario: ");
        double salario = sc.nextDouble();
        sc.nextLine();

        Funcionario f =
                new Funcionario(numero, nome, cargo, salario);

        System.out.print("Nome do dependente: ");
        String nomeDep = sc.nextLine();

        Dependente d =
                new Dependente(nomeDep, f);

        System.out.println("\n--- FUNCIONARIO ---");
        System.out.println("Numero: " + f.numero);
        System.out.println("Nome: " + f.nome);
        System.out.println("Cargo: " + f.cargo);
        System.out.println("Salario: R$ " + f.salario);

        System.out.println("\n--- DEPENDENTE ---");
        System.out.println("Nome: " + d.nome);
        System.out.println("Funcionario: " + d.funcionario.nome);

        sc.close();
    }
}