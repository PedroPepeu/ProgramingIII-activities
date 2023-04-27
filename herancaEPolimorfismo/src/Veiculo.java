public class Veiculo {

    private String marca;    
    private boolean estado;    
    private double tanque;
    private double consumo;
    private double velocidadeAtual;
    private double litragemDoTanque;
    private double velocidadeMaxima;

    public Veiculo() {
    
    }

    public Veiculo(String marca, boolean estado, double tanque, double consumo, double velocidadeAtual, double litragemDoTanque, double velocidadeMaxima) {
        this.marca = marca;
        this.estado = false;
        this.tanque = tanque;
        this.consumo = consumo;
        this.velocidadeAtual = velocidadeAtual;
        this.litragemDoTanque = litragemDoTanque;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void Chavear() {
        if(isEstado()) setEstado(false);
        else setEstado(true);
    }

    public void Acelerar() {
        if(getVelocidadeAtual() < getVelocidadeMaxima()) setVelocidadeAtual(getVelocidadeAtual() + 1);
    }

    public void Frear() {
        if(getVelocidadeAtual() > 0) setVelocidadeAtual(getVelocidadeAtual() - 1);
    }

    public void Corrida(double distancia) {
        double distanciaMaximaAPercorrer = getTanque() * getConsumo();
        if(distancia > distanciaMaximaAPercorrer) {
            setVelocidadeAtual(0);
            setLitragemDoTanque(0);
            System.out.printf("%d quilometros\n", (distancia - distanciaMaximaAPercorrer));
        } else setLitragemDoTanque(getLitragemDoTanque() - (getConsumo() * distancia)); 
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getTanque() {
        return tanque;
    }

    public void setTanque(double tanque) {
        this.tanque = tanque;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public double getLitragemDoTanque() {
        return litragemDoTanque;
    }

    public void setLitragemDoTanque(double litragemDoTanque) {
        this.litragemDoTanque = litragemDoTanque;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    
    
}
