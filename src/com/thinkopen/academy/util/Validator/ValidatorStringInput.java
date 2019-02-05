package com.thinkopen.academy.util.Validator;

public class ValidatorStringInput {
    static int lunghezza=3;
    //Controlla le l'input è lungo 3 caratteri ed è un numero

    public static boolean validaStringaInput(String input){

        boolean b = false;
        if(input.length()==3) {
            System.out.println("inputLenghtTrue");//debug
                    b = false;
                    for (int j = 0; j < lunghezza; j++) {
                        char charr = input.charAt(j);
                        int a;
                        try{
                            a=Integer.parseInt(String.valueOf(charr));
                            b=(0<=a&&a<=9);
                            System.out.println("checkBetwin0-9 and b="+b);//debug
                        }catch (NumberFormatException e){
                            System.out.println(e);
                        }

                        System.out.println("charr="+charr);//debug
                        if (b) {
                            System.out.println("ifDigitTrue");//debug

                        }else {
                            System.out.println("ifDigitFalse");//debug
                            return false;
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
