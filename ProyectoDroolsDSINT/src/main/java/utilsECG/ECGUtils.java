package utilsECG;

import java.util.List;

import dominioECG.Ciclo;

public class ECGUtils {
	public static double getRRInterval(Ciclo c1, Ciclo c2) {
        // Suponemos que cada onda tiene un método getPeak() que devuelve el tiempo en ms
        double R1 = c1.getWaveR().getPeak_amplitude();
        double R2 = c2.getWaveR().getPeak_amplitude();

        // Intervalo RR en segundos
        return (R2 - R1) / 1000.0;
    }
	
	public static double getHeartRate(List<Ciclo> ciclos) {
        if (ciclos == null || ciclos.size() < 2) {
            throw new IllegalArgumentException("Se necesitan al menos 2 ciclos para calcular el ritmo cardíaco");
        }

        double totalRR = 0.0;
        int count = 0;

        // Iterar sobre ciclos consecutivos
        for (int i = 0; i < ciclos.size() - 1; i++) {
            double rr = getRRInterval(ciclos.get(i), ciclos.get(i + 1));
            totalRR += rr;
            count++;
        }

        double rrPromedio = totalRR / count;

        // Heart rate promedio en lpm
        return 60.0 / rrPromedio;
    }
}
