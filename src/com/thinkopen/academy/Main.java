package com.thinkopen.academy;

import java.util.Scanner;

public class Main {
//todo togliere static ai metodi validator e inizializzare l'oggetto e vede eventuaeincapsulamento.

    /*
    Stringhe Costanti per titolo applicazione/UI
     */
    private static final String _TITLE="##############\n" + "# MASTERMIND #\n"+"##############\n";
    private static final String _START_MESSAGE="\nInserisci la combinazione : ";

    //MAIN method

    public static void main(String[] args) {

        Config.configurazione();//Inizializza,aggiorna e legge il file conf per la generazione del codice segreto

        boolean validazione=false;//inzializza la variabile di validazione per check inserimento input todo : ed eventuale factorized engine del core del controllo del programma
        int tentativi=0;

        Scanner inputDaTastiera= new Scanner(System.in);
        System.out.println(_TITLE);
        System.out.println(_START_MESSAGE);
        String combinazione=inputDaTastiera.nextLine();
        SelectValidator selettoreValidatori= new SelectValidator(combinazione);
        do {
            if(tentativi++!=0) System.out.println("Tentativo n."+tentativi+"\nInput non valido e/o combinazione errata.\nRiprova.\n");
            System.out.println(_START_MESSAGE);
            combinazione= inputDaTastiera.nextLine();
        }while (selettoreValidatori.validateInput());
        //Controllo CodiceSegreto
    }
}
