package com.thinkopen.academy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ValidatorString {
    private static String[][] parziale = new String[3][4];
    private static int match = 0;
    private static String combinazioneSegreta = new String();

    //private boolean isANumber(){ }
    //todo Costruttore
    ValidatorString() {
        leggiConfigurazioneCodice();
    }

    private void leggiConfigurazioneCodice() {
        Properties prop = new Properties();
        InputStream inputstream = null;
        try {
            inputstream = new FileInputStream("config.properties");
            prop.load(inputstream);
            combinazioneSegreta = ((prop.getProperty("CODICE")));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputstream != null) {
                try {
                    inputstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //todo VALIDATE STRING from Generic
    public static boolean validaString(String input) {
        boolean controllo = (input.length() == 3);
        if (controllo) {
            return ValidatorString.controllaCombinazione(input);
        }
        return false;
    }
    //todo  CONTROLLACOMBINAZIONE STRING
    private static boolean controllaCombinazione(String input) {


        if (!ValidatorString.combinazioneSegreta.equals(input)) {
            return ValidatorString.controllaCombinazione(input, combinazioneSegreta);
        } else {
            return true;
        }
    }


    //todo CONTROLLACOMBINAZIONE STRING/STRING
    private static boolean controllaCombinazione(String input, String combinazionSegreta) {
        char matcher[] = combinazionSegreta.toCharArray();
        char temp[] = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
           // if (match >= 3) break;
            parziale[i][0] = String.valueOf(temp[i]);
            for (int j = 0; j < combinazionSegreta.length(); j++) {
                match = +((temp[i] == matcher[j]) ? 1 : 0);
                if (temp[i] == matcher[j]) {
                    parziale[i][j + 1] = String.valueOf(temp[i]);
                } else {
                    parziale[i][j + 1] = null;
                }
            }
        }
        return false;
    }

}
