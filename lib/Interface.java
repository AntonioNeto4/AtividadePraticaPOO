import java.util.Scanner;
public class Interface {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int numeroFormasCalcular, formaSelecionada;

        ControleFormasGeometricas controle = new ControleFormasGeometricas();

        while(true){
            System.out.println("-----CALCULADORA DE FORMAS GEOMETRICAS-----");
            System.out.printf("Quantas formas serão calculadas?");
            numeroFormasCalcular = ler.nextInt();

            if(numeroFormasCalcular <= 0)
                System.out.println("Número inválido, tente novamente!");
                continue;

            for(int i = 0; i < numeroFormasCalcular; i++){
                System.out.println("Qual forma você deseja calcular?");
                System.out.println("1 - Circulo");
                System.out.println("2 - Retângulo");
                System.out.println("3 - Triangulo"); 

                formaSelecionada = ler.nextInt();

                switch(formaSelecionada){
                    case 1:
                        System.out.println("Digite o raio do círculo: ");
                        double raio = ler.nextDouble();
                        controle.adicionaForma(new adicionarCirculoirculo(raio));
                        break;
                    case 2:
                        System.out.println("Digite a base do retângulo: ");
                        double base = ler.nextDouble();
                        System.out.println("Digite a altura do retângulo: ");
                        double altura = ler.nextDouble();
                        controle.adicionaForma(new Retangulo(base, altura));
                        break;
                    case 3:
                        System.out.println("Digite a base do triângulo: ");
                        double baseTriangulo = ler.nextDouble();
                        System.out.println("Digite a altura do triângulo: ");
                        double alturaTriangulo = ler.nextDouble();
                        controle.adicionaForma(new Triangulo(baseTriangulo, alturaTriangulo));
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente!");
                

                for(FormaGeo forma : controle.getArray()) {
                    System.out.println("Calculo do" + controle.exibirForma(forma));
                    System.out.println("Calcular Área - 1");
                    System.out.println("Calcular Perímetro - 2");
                    int opcaoCalculo = ler.nextInt();

                    switch(opcaoCalculo) {
                        case 1:
                            System.out.println("Área: " + forma.calcularArea());
                            break;
                        case 2:
                            System.out.println("Perímetro: " + forma.calcularPerimetro());
                            break;
                        default:
                            System.out.println("Opção inválida, tente novamente!");
                    }
                }
            }
        }

        ler.close();
    }
}

