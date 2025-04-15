import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int numeroFormasCalcular = 0;

        ControladorFormasGeometricas controle = new ControladorFormasGeometricas();

        while (true) {
            System.out.println("-----CALCULADORA DE FORMAS GEOMÉTRICAS-----");

            // Lê o número de formas com verificação
            while (true) {
                System.out.print("Quantas formas serão calculadas? ");
                try {
                    numeroFormasCalcular = ler.nextInt();
                    if (numeroFormasCalcular <= 0) {
                        System.out.println("Número inválido. Digite um número positivo.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um número inteiro.");
                    ler.next(); // limpar buffer
                }
            }

            // Loop para cada forma
            for (int i = 0; i < numeroFormasCalcular; i++) {
                int formaSelecionada = 0;

                // Seleção da forma com verificação
                while (true) {
                    System.out.println("\nQual forma você deseja calcular?");
                    System.out.println("1 - Círculo");
                    System.out.println("2 - Retângulo");
                    System.out.println("3 - Triângulo");

                    try {
                        formaSelecionada = ler.nextInt();
                        if (formaSelecionada < 1 || formaSelecionada > 3) {
                            System.out.println("Opção inválida, tente novamente.");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Digite um número de 1 a 3.");
                        ler.next();
                    }
                }

                // Coleta dos dados conforme forma selecionada
                try {
                    switch (formaSelecionada) {
                        case 1: // Círculo
                            System.out.print("Digite o raio do círculo: ");
                            double raio = ler.nextDouble();
                            if (raio <= 0) throw new IllegalArgumentException("Raio deve ser positivo.");
                            controle.addForma(new Circulo(raio));
                            break;

                        case 2: // Retângulo
                            System.out.print("Digite a base do retângulo: ");
                            double base = ler.nextDouble();
                            System.out.print("Digite a altura do retângulo: ");
                            double altura = ler.nextDouble();
                            if (base <= 0 || altura <= 0)
                                throw new IllegalArgumentException("Base e altura devem ser positivas.");
                            controle.addForma(new Retangulo(base, altura));
                            break;

                        case 3: // Triângulo
                            System.out.print("Digite o lado 1 do triângulo: ");
                            double lado1 = ler.nextDouble();
                            System.out.print("Digite o lado 2 do triângulo: ");
                            double lado2 = ler.nextDouble();
                            System.out.print("Digite o lado 3 do triângulo: ");
                            double lado3 = ler.nextDouble();
                            if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0)
                                throw new IllegalArgumentException("Todos os lados devem ser positivos.");
                            if (!validaTriangulo(lado1, lado2, lado3))
                                throw new IllegalArgumentException("Os lados não formam um triângulo válido.");
                            controle.addForma(new Triangulo(lado1, lado2, lado3));
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Use apenas números válidos.");
                    ler.next(); // limpar o buffer
                    i--; // repetir esta iteração
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                    i--; // repetir esta iteração
                }
            }

            // Cálculos
            for (FormasGeo forma : controle.getArray()) {
                System.out.println("\nCálculo da " + controle.exibirForma(forma));
                int opcaoCalculo = 0;

                while (true) {
                    System.out.println("1 - Calcular Área");
                    System.out.println("2 - Calcular Perímetro");
                    System.out.print("Escolha uma opção: ");

                    try {
                        opcaoCalculo = ler.nextInt();
                        if (opcaoCalculo == 1) {
                            System.out.println("Área: " + forma.calculaArea());
                        } else if (opcaoCalculo == 2) {
                            System.out.println("Perímetro: " + forma.calculaPerimetro());
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Use apenas números.");
                        ler.next();
                    }
                }
            }

            break; // encerra a aplicação após uma execução
        }

        ler.close();
    }

    // Validação do triângulo
    public static boolean validaTriangulo(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }
}
