package dominioECG;

public class RitmoCardiaco {
 	private double valor; // en latidos por minuto (bpm)
    private RegistroECG registroAsignado;

    public RitmoCardiaco(double valor,  RegistroECG registroAsignado) {
        this.valor = valor;
        this.registroAsignado = registroAsignado;
    }

    public double getValor() {
        return valor;
    }

    public RegistroECG getRegistroAsignado() {
        return registroAsignado;
    }

    @Override
    public String toString() {
        return "Ritmo card�aco del registro " + registroAsignado.getIdRegistro() + ": " + valor + " bpm";
    }
}
