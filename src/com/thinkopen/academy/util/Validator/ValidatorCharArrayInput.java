package com.thinkopen.academy.util.Validator;

import com.sun.xml.internal.fastinfoset.util.CharArray;

public class ValidatorCharArrayInput {
    static int lunghezza=3;
    //Controlla le l'input è lungo 3 caratteri ed è un numero
    public static boolean validaCharArrayInput(char input[]){
        boolean b = false;
        if(input.length==3) {
            for (int i = 0; i < lunghezza; i++) {
                    b = false;
                    for (int j = 0; j < lunghezza; j++) {
                        char charr = input[j];
                        b = '0' <= charr && charr <= '9';
                        if (!b) {
                            return false;
                        }
                    }

            }
        }
        return b;
    }

    public static void setLunghezza(int lunghezza) {
        ValidatorCharArrayInput.lunghezza = lunghezza;
    }

    public static int getLunghezza() {
        return lunghezza;
    }
}
