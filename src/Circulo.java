public class Circulo implements FormasGeo{
    
    private double raio;
    private static final double PI = 3.14159;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double calculaArea() {
        return PI * raio * raio;
    }

    @Override
    public double calculaPerimetro() {
        return 2 * PI * raio;
    }
}
