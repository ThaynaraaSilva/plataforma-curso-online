package util;
import java.util.Random;


public class GeradorDadosCurso {
	public static String gerarNomeCurso(int tamanho) {
        int leftLimit = 97;
        int rightLimit = 122; 
        int targetStringLength = tamanho;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String nomeCurso = buffer.toString();
        return "Curso " + nomeCurso.substring(0, 1).toUpperCase() + nomeCurso.substring(1);
    }

	
    public static String gerarID(int tamanho) {
        int leftLimit = 48; 
        int rightLimit = 57; 
        int targetStringLength = tamanho;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

  
    public static String gerarTituloModulo(int tamanho) {
        int leftLimit = 97; 
        int rightLimit = 122; 
        int targetStringLength = tamanho;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String tituloModulo = buffer.toString();
        return "Módulo " + tituloModulo.substring(0, 1).toUpperCase() + tituloModulo.substring(1);
    }
}
