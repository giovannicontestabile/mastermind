package com.thinkopen.academy.util.Validator;

public class ValidatorStringInput {
    static int lunghezza=3;
    //Controlla le l'input è lungo 3 caratteri ed è un numero

    public static boolean validaStringaInput(String input){

        boolean b = false;
        if(input.length()==3) {
            for (int i = 0; i < lunghezza; i++) {
                    b = false;
                    for (int j = 0; j < lunghezza; j++) {
                        char charr = input.charAt(j);
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
        ValidatorStringInput.lunghezza = lunghezza;
    }

    public static int getLunghezza() {
        return lunghezza;
    }
}
