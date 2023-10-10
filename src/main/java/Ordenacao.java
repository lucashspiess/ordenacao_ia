import java.util.Arrays;

public class Ordenacao {

    private static final String[][] REGRAS = {
            {"PV2a", "PV1"},   //regra 1
            {"PV2b1","PV1"},   //regra 2
            {"PV2b","PV1"},    //regra 3
            {"PV2", "PV1"},    //regra 4
            {"PV3a","PV1"},    //regra 5
            {"PV3", "PV1"},    //regra 6
            {"PV4", "PV1"},    //regra 7
            {"PV2b1","PV2a"},  //regra 8
            {"PV2b","PV2a"},   //regra 9
            {"PV2", "PV2a"},   //regra 10
            {"PV3a","PV2a"},   //regra 11
            {"PV3", "PV2a"},   //regra 12
            {"PV4", "PV2a"},   //regra 13
            {"PV2b","PV2b1"},  //regra 14
            {"PV2", "PV2b1"},  //regra 15
            {"PV3a","PV2b1"},  //regra 16
            {"PV3", "PV2b1"},  //regra 17
            {"PV4", "PV2b1"},  //regra 18
            {"PV2", "PV2b"},   //regra 19
            {"PV3a","PV2b"},   //regra 20
            {"PV3", "PV2b"},   //regra 21
            {"PV4", "PV2b"},   //regra 22
            {"PV3a","PV2"},    //regra 23
            {"PV3", "PV2"},    //regra 24
            {"PV4", "PV2"},    //regra 25
            {"PV3", "PV3a"},   //regra 26
            {"PV4", "PV3a"},   //regra 27
            {"PV4", "PV3"},    //regra 28
    };

    private static String[] separaString(String entrada) {
        return entrada.split(";");
    }

    private static boolean encontraRegra(String[] entrada, StringBuilder regras) {
        String aux;
        for (int i = 0; i < entrada.length; i++){
            for (int j = 0; j < REGRAS.length; j++) {
                if (REGRAS[j][0].equals(entrada[i])) {
                    if(entrada.length != i+1){
                        if (REGRAS[j][1].equals(entrada[i + 1])){
                            if(!regras.toString().equals("Regras encontradas: ")){
                                regras.append(", ");
                            }
                            regras.append(j+1);
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

    public static String ordena(String input, StringBuilder regras) {
        String[] entrada = separaString(input);
        regras.append("Regras encontradas: ");
        boolean regraEcontrada = true;

        while(regraEcontrada){
            regraEcontrada  = encontraRegra(entrada, regras);
        }

        return Arrays.toString(entrada);
    }
}


