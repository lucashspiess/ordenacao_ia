import java.util.Arrays;

public class Ordenacao {

    private static final String[][] REGRAS = {
            {"PV2", "PV1"},     //regra 1
            {"PV3", "PV2"},     //regra 2
            {"PV3", "PV1"},     //regra 3
            {"PV1", "PV1a"},    //regra 4
            {"PV2", "PV1a"},    //regra 5
            {"PV3", "PV1a"},    //regra 6
            {"PV2a", "PV1a"},   //regra 7
            {"PV2a", "PV1"},    //regra 8
            {"PV3a", "PV1a"},   //regra 9
            {"PV2", "PV2a"},    //regra 10
            {"PV3", "PV2a"},    //regra 11
            {"PV3a", "PV2a"},   //regra 12
            {"PV3", "PV3a"},    //regra 13
            {"PV3a", "PV1"},    //regra 14
            {"PV3a", "PV2"},    //regra 15
            {"PV2", "PV2b"},    //regra 16
            {"PV3", "PV2b"},    //regra 17
            {"PV3a", "PV2b"},   //regra 18
            {"PV2b","PV2b1"},   //regra 19
            {"PV2", "PV2b1"},   //regra 20
            {"PV3a", "PV2b1"},  //regra 21
            {"PV3", "PV2b1"},   //regra 22
            {"PV4","PV3"},      //regra 23
            {"PV4","PV3a"},     //regra 24
            {"PV4","PV2"},      //regra 25
            {"PV4", "PV2a"},    //regra 26
            {"PV4","PV2b"},     //regra 27
            {"PV4", "PV2b1"},   //regra 28
            {"PV4", "PV1"},     //regra 29
            {"PV4", "PV1a"}     //regra 30
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
        boolean regraEcontrada = true;

        while(regraEcontrada){
            regraEcontrada  = encontraRegra(entrada);
        }

        return Arrays.toString(entrada);
    }
}


