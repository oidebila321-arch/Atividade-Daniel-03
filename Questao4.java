import java.util.Scanner;

public class Questao4 {

    static Scanner sc = new Scanner(System.in);

    static class Aluno {
        int codigo;
        String nome;

        Aluno(int c, String n) {
            codigo = c;
            nome = n;
        }
    }

    static class Disciplina {
        int codigo;
        String nome;

        Disciplina(int c, String n) {
            codigo = c;
            nome = n;
        }
    }

    static class Matricula {
        Aluno aluno;
        Disciplina disciplina;
        double[] notas = new double[4];

        Matricula(Aluno a, Disciplina d) {
            aluno = a;
            disciplina = d;
        }

        double media() {
            return (notas[0] + notas[1] +
                    notas[2] + notas[3]) / 4;
        }
    }

    static Aluno[] alunos = new Aluno[10];
    static Disciplina[] disciplinas = new Disciplina[5];
    static Matricula[] matriculas = new Matricula[30];

    static int qtdAluno = 0;
    static int qtdDisciplina = 0;
    static int qtdMatricula = 0;

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar disciplina");
            System.out.println("3 - Matricular aluno");
            System.out.println("4 - Lancar notas");
            System.out.println("5 - Relatorio");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> cadastrarDisciplina();
                case 3 -> matricular();
                case 4 -> lancarNotas();
                case 5 -> relatorio();
            }

        } while (opcao != 0);
    }

    static void cadastrarAluno() {
        System.out.print("Codigo: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        alunos[qtdAluno++] = new Aluno(codigo, nome);
        System.out.println("Aluno cadastrado!");
    }

    static void cadastrarDisciplina() {
        System.out.print("Codigo: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        disciplinas[qtdDisciplina++] =
                new Disciplina(codigo, nome);

        System.out.println("Disciplina cadastrada!");
    }

    static void matricular() {
        System.out.print("Codigo do aluno: ");
        int ca = sc.nextInt();

        System.out.print("Codigo da disciplina: ");
        int cd = sc.nextInt();

        Aluno aluno = null;
        Disciplina disciplina = null;

        for (int i = 0; i < qtdAluno; i++)
            if (alunos[i].codigo == ca)
                aluno = alunos[i];

        for (int i = 0; i < qtdDisciplina; i++)
            if (disciplinas[i].codigo == cd)
                disciplina = disciplinas[i];

        if (aluno != null && disciplina != null) {
            matriculas[qtdMatricula++] =
                    new Matricula(aluno, disciplina);

            System.out.println("Matricula realizada!");
        } else {
            System.out.println("Dados nao encontrados.");
        }
    }

    static void lancarNotas() {
        System.out.print("Codigo do aluno: ");
        int ca = sc.nextInt();

        for (int i = 0; i < qtdMatricula; i++) {

            if (matriculas[i].aluno.codigo == ca) {

                for (int j = 0; j < 4; j++) {
                    System.out.print("Nota " + (j + 1) + ": ");
                    matriculas[i].notas[j] = sc.nextDouble();
                }

                System.out.println("Notas lancadas!");
                return;
            }
        }

        System.out.println("Matricula nao encontrada.");
    }

    static void relatorio() {

        System.out.print("Codigo do aluno: ");
        int codigo = sc.nextInt();

        for (int i = 0; i < qtdMatricula; i++) {

            Matricula m = matriculas[i];

            if (m.aluno.codigo == codigo) {

                System.out.println("\nAluno: " + m.aluno.nome);
                System.out.println(
                    "Disciplina: " + m.disciplina.nome
                );
                System.out.println(
                    "Media: " + m.media()
                );
            }
        }
    }
}