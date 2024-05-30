import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("empregados.txt", true))) {
            do {
                try {
                    System.out.println("Informe o primeiro nome do empregado:");
                    String primeiroNome = input.nextLine();

                    System.out.println("Informe o sobrenome do empregado:");
                    String sobrenome = input.nextLine();

                    float salarioMensal = 0;
                    boolean salarioValido = false;

                    while (!salarioValido) {
                        try {
                            System.out.println("Informe o salário mensal do empregado: R$ ");
                            salarioMensal = input.nextFloat();
                            input.nextLine(); 

                            if (salarioMensal <= 0) {
                                throw new IllegalArgumentException("O salário mensal deve ser um valor positivo.");
                            }

                            salarioValido = true; 

                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: " + e.getMessage());
                            System.out.println("Por favor, insira um valor válido.");
                            input.nextLine(); 
                        }
                    }

                    Empregado empregado = new Empregado(primeiroNome, sobrenome, salarioMensal);

                    System.out.println("Salário anual do empregado: R$ " + empregado.calcularSalarioAnual());
                    empregado.aumentarSalario();
                    System.out.println("\nApós aumento de salário:");
                    System.out.println("Novo salário anual do empregado: R$ " + empregado.calcularSalarioAnual());

                   
                    writer.write("Primeiro nome: " + empregado.getPrimeiroNome());
                    writer.newLine();
                    writer.write("Sobrenome: " + empregado.getSobrenome());
                    writer.newLine();
                    writer.write("Salário mensal: R$ " + empregado.getSalarioMensal());
                    writer.newLine();
                    writer.write("Salário anual: R$ " + empregado.calcularSalarioAnual());
                    writer.newLine();
                    writer.write("---------------------------------------");
                    writer.newLine();

                } catch (Exception e) {
                    System.out.println("Erro inesperado: " + e.getMessage());
                } finally {
                    System.out.println("\nDeseja informar sobre outro empregado? (S/N)");
                    choice = input.nextLine();
                }
            } while (choice.equalsIgnoreCase("S"));
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}
