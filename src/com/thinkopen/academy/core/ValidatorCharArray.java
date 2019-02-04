package com.thinkopen.academy.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ValidatorCharArray {


        private static String[][] parziale = new String[3][4];
        private static int match = 0;
        private static String combinazioneSegreta = new String();

        //private boolean isANumber(){ }
        //todo Costruttore
        ValidatorCharArray() {
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

        //todo VALIDATE CHAR[] from Generic
        public static boolean validaVettoreChar(Object input) {
            char[] vettoreChar = (char[]) input;
            boolean controllo = (vettoreChar.length == 3);
            if (controllo) {
                return ValidatorCharArray.controllaCombinazione(vettoreChar);
            }
            return false;
        }

        //todo CONTROLLACOMBINAZION    CHAR[]
        private static boolean controllaCombinazione(char[] vettoreChar) {
            return false;
        }


        //todo RETURN MATCH
        public static int getMatch() {
            return match;
        }



    }

   /* public Object[] getPartialSolution() {
        return new Object[0];
    }*/

