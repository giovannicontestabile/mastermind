package com.thinkopen.academy;

import java.util.Scanner;

public class Main {
//todo togliere static ai metodi validator e inizializzare l'oggetto e vede eventuaeincapsulamento.
    private static final String _TITLE="##############\n" + "# MASTERMIND #\n"+"##############\n";
    private static final String _START_MESSAGE="\nInserisci la combinazione : ";
    public static void main(String[] args) {
        Config.configurazione();
        boolean validazione=false;
        //String input=new String() ;//if(args.length==1)input=args[1];
        SelectValidator selettore = new SelectValidator() ;

        Scanner inputDaTastiera= new Scanner(System.in);
        System.out.println(_TITLE);
        do {
            System.out.println(_START_MESSAGE);
            String combinazione=inputDaTastiera.nextLine();
            validazione=selettore.validate(combinazione);
            if (validazione==false&&(Validator.getMatch()==0))
            {
                System.out.println("Combinazione Errata");
            }
            else if (Validator.getMatch()>0){
                System.out.println("La combinazione è parzialmente corretta :\n-Riposiziona e/o sostituisci cifre.\n");
            }
        }while (!validazione);

    }
}
