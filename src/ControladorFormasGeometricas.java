import java.util.ArrayList;

public class ControladorFormasGeometricas {
        
        private ArrayList<FormasGeo> formas;

        public ControladorFormasGeometricas() {
                formas = new ArrayList<>();
        }

        public ArrayList<FormasGeo> getArray() {
                return formas;
        }

        public void addForma(FormasGeo forma) {
                formas.add(forma);
        }

        public FormasGeo getForma(int index) {
                return formas.get(index);
        }

        public String exibirForma(FormasGeo forma) {
                if(forma instanceof Circulo) {
                        return "Círculo";
                } else if(forma instanceof Retangulo) {
                        return "Retângulo";
                }

                return "Triângulo";
        }
        // Precisamos verficar quais são os dados (raio, lados, altura) 
        // Precisamos verificar quais são as formas e qual será o tipo de cálculo             
    
}
