package utilsECG;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dominioECG.*;

public class ParserECG {
	private static final Pattern ONDA_PATTERN =
            Pattern.compile("(P|Q|R|S|T)\\((\\d+),(\\d+),([\\d.-]+)\\)");
	
	public static List<Ciclo> parsearLineas(List<String> lineas) {
	    List<Ciclo> ciclos = new ArrayList<>();
	    int numeroCiclo = 1;
	    
        OndaP p = null;
        OndaQ q = null;
        OndaR r = null;
        OndaS s = null;
        OndaT t = null;
        
	    for (String linea : lineas) {
	        Matcher matcher = ONDA_PATTERN.matcher(linea);

	        while (matcher.find()) {
	            String tipo = matcher.group(1);
	            int start = Integer.parseInt(matcher.group(2));
	            int end = Integer.parseInt(matcher.group(3));
	            double peak = Double.parseDouble(matcher.group(4));

	            switch (tipo) {
	                case "P":
	                	p = new OndaP(start, end, peak);
	                	break;
	                case "Q":
	                	q = new OndaQ(start, end, peak);
	                	break;
	                case "R":
	                	r = new OndaR(start, end, peak);
	                	break;
	                case "S":
	                	s = new OndaS(start, end, peak);
	                	break;
	                case "T":
	                	t = new OndaT(start, end, peak);
	                    Ciclo ciclo = new Ciclo(numeroCiclo++, p, q, r, s, t);
	                    ciclos.add(ciclo);
	                    p = null; q = null; r = null; s = null; t = null;
	                    break;  
	            }
	        }
	    }

	    if (p != null || q != null || r != null || s != null || t != null) {
	        ciclos.add(new Ciclo(numeroCiclo, p, q, r, s, t));
	    }
	    
	    return ciclos;
	}
}
