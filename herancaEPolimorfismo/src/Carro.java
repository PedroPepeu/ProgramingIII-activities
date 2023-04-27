public class Carro extends Veiculo {

    private String placa;
    private final String e = "Ao adicionar a gasolina especial a capacidade do tanque foi excedida";
    
    public Carro(String marca, boolean estado, double tanque, double consumo, double velocidadeAtual, double litragemDoTanque, double velocidadeMaxima, String placa) {
        super(marca, estado, tanque, consumo, velocidadeAtual, litragemDoTanque, velocidadeMaxima);
        this.placa = placa;
    }

    @Override
    public void Chavear() {
        if(isEstado()) {
            while(super.getVelocidadeAtual() > 0) Frear();
            setEstado(false);
        } else setEstado(true);
    }

    @Override
    public void Acelerar() {
        if(super.getVelocidadeAtual() < super.getVelocidadeMaxima()) super.setVelocidadeAtual(super.getVelocidadeAtual() + 10);
    }

    @Override
    public void Frear() {
        if(super.getVelocidadeAtual() > 0) super.setVelocidadeAtual(super.getVelocidadeAtual() - 5);
    }

    public void Corrida(double distancia, double gasolinaEspecial) {
        if(!(gasolinaEspecial + super.getLitragemDoTanque() > super.getTanque())) {
            double distanciaAPercorrerComAGasolinaEspecial = gasolinaEspecial * (super.getConsumo() / 2);
            if(distanciaAPercorrerComAGasolinaEspecial > distancia) super.setLitragemDoTanque(super.getLitragemDoTanque() + (super.getConsumo() * 2 * distancia));
            else {
                double distanciaAPercorrerComAGasolinaNormal = super.getTanque() * super.getConsumo() - distanciaAPercorrerComAGasolinaEspecial;
                if(distanciaAPercorrerComAGasolinaNormal > distancia - distanciaAPercorrerComAGasolinaEspecial) {
                    super.setLitragemDoTanque(super.getLitragemDoTanque() - (super.getConsumo() * distanciaAPercorrerComAGasolinaNormal));
                } else {
                    super.setVelocidadeAtual(0);
                    super.setLitragemDoTanque(0);
                    System.out.printf("%d quilometros\n", (distancia - distanciaAPercorrerComAGasolinaEspecial + distanciaAPercorrerComAGasolinaNormal));
                }
            }
        } else System.out.println(e);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
}
