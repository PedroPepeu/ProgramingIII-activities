public class Aviao extends Veiculo {

    private boolean voando = false;
    private final String decida = "Aviao esta pousando";
    private final String subida = "Aviao esta voando";
    private final String erroChavear = "Aviao em movimento";
    private final String emergencia = "Pouso emergencial";

    public Aviao(String marca, boolean estado, double tanque, double consumo, double velocidadeAtual,
            double litragemDoTanque, double velocidadeMaxima, boolean voando) {
        super(marca, estado, tanque, consumo, velocidadeAtual, litragemDoTanque, velocidadeMaxima);
        this.voando = voando;
    }

    public void Voar() {
        if(super.getVelocidadeAtual() > 200) {
            setVoando(true);
            System.out.println(subida);
        } else {
            setVoando(false);
            System.out.println(decida);
        }
    }

    @Override
    public void Chavear() {
        if(super.getVelocidadeAtual() < 0) super.setEstado(false);
        else System.out.println(erroChavear);
    }

    @Override
    public void Acelerar() {
        if(super.getVelocidadeAtual() < super.getVelocidadeMaxima()) super.setVelocidadeAtual(super.getVelocidadeAtual() + 20);
    }

    @Override
    public void Frear() {
        if(super.getVelocidadeAtual() > 0) super.setVelocidadeAtual(super.getVelocidadeAtual() - 10);
        if(super.getVelocidadeAtual() < 200) {
            Voar();
        }
    }

    @Override
    public void Corrida(double distancia) {
        double distanciaMaximaAPercorrer = super.getLitragemDoTanque() * super.getConsumo();
        if(distancia > distanciaMaximaAPercorrer) {
            super.setVelocidadeAtual(0);
            super.setLitragemDoTanque(0);
            System.out.println(emergencia);
        } else super.setLitragemDoTanque(super.getLitragemDoTanque() - (super.getConsumo() * distancia)); 
    }

    public boolean isVoando() {
        return voando;
    }

    public void setVoando(boolean voando) {
        this.voando = voando;
    }
    
}
