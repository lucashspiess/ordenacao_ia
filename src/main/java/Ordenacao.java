import java.util.Arrays;

public class Ordenacao {

    private static final String[][] REGRAS = {
            {"2", "1"},     //regra 1
            {"3", "2"},     //regra 2
            {"3", "1"},     //regra 3
            {"1", "1a"},    //regra 4
            {"2", "1a"},    //regra 5
            {"3", "1a"},    //regra 6
            {"2a", "1a"},   //regra 7
            {"2a", "1"},    //regra 8
            {"3a", "1a"},   //regra 9
            {"2", "2a"},    //regra 10
            {"3", "2a"},    //regra 11
            {"3a", "2a"},   //regra 12
            {"3", "3a"},    //regra 13
            {"3a", "1"},    //regra 14
            {"3a", "2"},    //regra 15
            {"1", "1ab"},   //regra 16
            {"1a", "1ab"},  //regra 17
            {"2a", "1ab"},  //regra 18
            {"2", "1ab"},   //regra 19
            {"3a", "1ab"},  //regra 20
            {"3", "1ab"}    //regra 21
    };

    private static String[] separaString(String entrada) {
        return entrada.split(";");
    }

    private static boolean encontraRegra(String[] entrada) {
        String aux;
        for (int i = 0; i < entrada.length; i++){
            for (int j = 0; j < REGRAS.length; j++) {
                if (REGRAS[j][0].equals(entrada[i])) {
                    if(entrada.length != i+1){
                        if (REGRAS[j][1].equals(entrada[i + 1])){
                            System.out.println("regra: "+(j+1));
                            aux = entrada[i];
                            entrada[i] = entrada[i+1];
                            entrada[i+1] = aux;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static String ordena(String input) {
        String[] entrada = separaString(input);
        boolean ordenado = true;

        while(ordenado){
            ordenado  = encontraRegra(entrada);
        }
        return Arrays.toString(entrada);
    }
}


