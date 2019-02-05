package com.thinkopen.academy.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class checkString {
    String inputToTest;
    private String checkOut[]=new String[2];
    private static String[][] parziale ;
    private static int match = 0;
    private static String combinazioneSegreta = new String();

    public checkString(Object input) {
        leggiConfigurazioneCodice();
        inputToTest=input.toString();
        String parziale[][]=new String [inputToTest.length()][inputToTest.length()+1];

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

/*** old version
    //todo VALIDATE STRING from Generic
    public boolean validaString(String input) {
        boolean controllo = (input.length() == 3);
        if (controllo) {
            return this.controllaCombinazione(input);
        }
        return false;
    }

    **/

    private boolean controllaCombinazione(String input) {
        if (!checkString.combinazioneSegreta.equals(input)) {
            return this.controllaCombinazione(input, combinazioneSegreta);
        } else {
            return true;
        }
    }

    private boolean controllaCombinazione(String input, String combinazionSegreta) {
        String[][] matrixData=matrixGenerator(input,combinazionSegreta);
        int fullMatch=0,partialMatch=0;
        for (int i=0;i<input.length();i++){
            int j=1;
            if (matrixData[i][0]==matrixData[i][1]){
                fullMatch++;
                break;
            }
            if(matrixData[i][0]==matrixData[i][j++]&&(i!=(j-1)))partialMatch++;
        }
        this.setCheckOut(fullMatch,partialMatch);
        return false;
    }

    private String[][] matrixGenerator(String input, String combinazionSegreta)
    {
        char matcher[] = combinazionSegreta.toCharArray();
        char temp[] = input.toCharArray();
        //Genero una matrice input+input*secret
        for (int i = 0; i < input.length(); i++) {
            parziale[i][0] = String.valueOf(temp[i]);
            if (temp[i] != matcher[i]) {
                for (int j = 0; j < combinazionSegreta.length(); j++) {
                    /*** Replaced version String/String*/
                    if ( ( i!=j)  && ( temp[i] == matcher[j] ) )
                    {
                        parziale[i][j + 1] = String.valueOf(temp[i]);
                        match++;
                    } else {
                        parziale[i][j+1] = null;
                    }
                }
            }else{
                parziale[i][i+ 1] = String.valueOf(temp[i]);
                match++;
            }
        }
        return parziale;
    }

    private void setCheckOut(int fullMatch,int partialMatch) {
        this.checkOut[0]= String.valueOf(fullMatch);
        this.checkOut[1]= String.valueOf(partialMatch);
    }

    public String[] getCheckOut() {
        return checkOut;
    }
    
    public boolean check()
    {
        return controllaCombinazione(inputToTest);
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