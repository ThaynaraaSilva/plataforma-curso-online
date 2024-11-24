package view;

import java.util.Scanner;
import java.util.UUID;
import java.util.InputMismatchException;  
import java.util.List;

import entidades.Curso;
import entidades.CursoOnline;
import entidades.CursoPresencial;
import enums.TipoCurso;
import repositorio.CursoRepositorio;
import servicos.CursoService;

public class MainCurso {
    private static CursoService cursoService = new CursoService(null); 
    private static CursoRepositorio cursoRepo = new CursoRepositorio(); // Garantir instância correta
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\nPlataforma de Cursos Online");
                System.out.println("1. Gerenciar Cursos");
                System.out.println("2. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (opcao) {
                    case 1:
                        menuCursos();
                        break;
                    case 2:
                        System.out.println("Saindo da plataforma...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Consumir entrada inválida
            }
        }
    }

    private static void menuCursos() {
        while (true) {
            try {
                System.out.println("\nMenu Cursos");
                System.out.println("1. Adicionar Curso");
                System.out.println("2. Atualizar Curso");
                System.out.println("3. Remover Curso");
                System.out.println("4. Listar Cursos");
                System.out.println("5. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        adicionarCurso();
                        break;
                    case 2:
                        atualizarCurso();
                        break;
                    case 3:
                        removerCurso();
                        break;
                    case 4:
                        listarCursos();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); 
            }
        }
    }

    private static void adicionarCurso() {
        try {
            System.out.print("Digite o título do curso: ");
            String titulo = scanner.nextLine();

            System.out.print("Digite o ano de criação do curso: ");
            int anoCriacao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            TipoCurso tipoCurso;
            while (true) {
                try {
                    System.out.print("Digite o tipo do curso (PRESENCIAL/ONLINE): ");
                    String tipoCursoStr = scanner.nextLine().toUpperCase();
                    tipoCurso = TipoCurso.valueOf(tipoCursoStr);
                    break; 
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo de curso inválido! Tente novamente.");
                }
            }

            Curso novoCurso;

            if (tipoCurso == TipoCurso.PRESENCIAL) {
                System.out.print("Digite o local da aula: ");
                String localAula = scanner.nextLine();
                System.out.print("Digite a capacidade de alunos: ");
                int capacidade = scanner.nextInt();
                scanner.nextLine(); 

                novoCurso = new CursoPresencial(
                    UUID.randomUUID().toString(),
                    titulo,
                    "Descrição padrão",
                    anoCriacao,
                    60,
                    300.0,
                    tipoCurso,
                    localAula,
                    capacidade
                );
            } else {
                novoCurso = new CursoOnline(
                    UUID.randomUUID().toString(),
                    titulo,
                    "Descrição padrão",
                    anoCriacao,
                    60,
                    300.0,
                    tipoCurso
                );
            }

        
            cursoRepo.adicionarCurso(novoCurso);
            System.out.println("Curso adicionado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Certifique-se de inserir os dados corretamente.");
            scanner.nextLine(); 
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    private static void atualizarCurso() {
        System.out.print("Digite o ID do curso a ser atualizado: ");
        String id = scanner.nextLine();
        Curso cursoExistente = cursoRepo.buscarCursoPorId(id);

        if (cursoExistente != null) {
            System.out.println("Curso encontrado: " + cursoExistente);

            System.out.print("Digite o novo título do curso: ");
            String novoTitulo = scanner.nextLine();

            System.out.print("Digite o novo ano de criação do curso: ");
            int novoAnoCriacao = scanner.nextInt();
            scanner.nextLine();  

            cursoExistente.setTitulo(novoTitulo);
            cursoExistente.setAnoCriacao(novoAnoCriacao);

            cursoRepo.atualizar(cursoExistente);
            System.out.println("Curso atualizado com sucesso!");
        } else {
            System.out.println("Curso não encontrado com o ID fornecido.");
        }
    }

    private static void removerCurso() {
        System.out.print("Digite o ID do curso a ser removido: ");
        String id = scanner.nextLine();
        Curso cursoExistente = cursoRepo.buscarCursoPorId(id); 

        if (cursoExistente != null) {
            cursoRepo.removerCurso(id);
            System.out.println("Curso removido com sucesso!");
        } else {
            System.out.println("Curso não encontrado com o ID fornecido.");
        }
    }

    private static void listarCursos() {
        System.out.println("Lista de Cursos:");

        List<Curso> cursos = cursoRepo.listarCursos(); 
        if (cursos == null || cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
        } else {
            for (Curso curso : cursos) {
                System.out.println(curso);
            }
        }
    }
}
