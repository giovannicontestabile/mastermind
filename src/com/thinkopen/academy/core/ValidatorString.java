package com.thinkopen.academy.core;

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
    ValidatorString(Object input) {
        leggiConfigurazioneCodice();
        String inputToTest=input.toString();
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
    public boolean validaString(String input) {
        boolean controllo = (input.length() == 3);
        if (controllo) {
            return this.controllaCombinazione(input);
        }
        return false;
    }
    //todo  CONTROLLACOMBINAZIONE STRING
    private boolean controllaCombinazione(String input) {


        if (!ValidatorString.combinazioneSegreta.equals(input)) {
            return this.controllaCombinazione(input, combinazioneSegreta);
        } else {
            return true;
        }
    }


    //todo CONTROLLACOMBINAZIONE STRING/STRING
    private boolean controllaCombinazione(String input, String combinazionSegreta) {
        char matcher[] = combinazionSegreta.toCharArray();
        char temp[] = input.toCharArray();
        //Genero una matrice input+input*secret
        for (int i = 0; i < input.length(); i++) {
            parziale[i][0] = String.valueOf(temp[i]);

            if (temp[i] != matcher[i]) {
                for (int j = 0; j < combinazionSegreta.length(); j++) {
                    /***
                     * Replaced version String/String
                     */
                    if ((i!=j)&&temp[i] == matcher[j]) {
                        parziale[i][j + 1] = String.valueOf(temp[i]);
                        match++;
                    } else {
                        parziale[i][j+1] = null;
                    }
                }
            }
        }
        return false;
    }

}


/**** old version of control string/string
 {
 match = +((temp[i] == matcher[j]) ? 1 : 0);
 if (temp[i] == matcher[j]) {
 parziale[i][j + 1] = String.valueOf(temp[i]);
 } else {
 parziale[i][j + 1] = null;
 }
 }
 */


/***version switch i WRONG EDITION

 switch((i==j)){

 case 2 : if (temp[i] == matcher[j]) {
 parziale[i][j+1] = String.valueOf(temp[i]);
 match++;
 }else if (temp[i] == matcher[j]) {
 parziale[i][j] = String.valueOf(temp[i]);
 }
 else {
 parziale[i][j] = null;
 }

 case 1 :if (temp[i] == matcher[j-1]) {
 parziale[i][j-1] = String.valueOf(temp[i]);
 match++;
 }else if (temp[i+1] == matcher[j]) {
 parziale[i][j + 1] = String.valueOf(temp[i]);
 match++;

 }
 else {
 parziale[i][j + 1] = null;
 }
 default: if (temp[i] == matcher[j]) {
 parziale[i][j] = String.valueOf(temp[i]);
 match++;

 } else {
 parziale[i][j + 1] = null;
 }
 break;
 }



 */