package com.thinkopen.academy;

import com.thinkopen.academy.core.checkString;

import java.util.Scanner;

public class Main {
    /***
     * Stringhe Costanti per titolo applicazione/UI
     */
    private static final String _TITLE="##############\n" + "# MASTERMIND #\n"+"##############\n";
    private static final String _START_MESSAGE="\nInserisci la combinazione : ";
    private static final String _WIN="##############\n" + "# YOU WIN!!! #\n"+"##############\n";
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
        checkString checker/*=new checkString(combinazione)*/;//TODO FARE IL SET COMBINAZIONE SENNO NN SI AGGIORNA
        do {
            do {
                if(tentativi++!=0) System.out.println("Tentativo n."+tentativi+"\nInput non valido e/o combinazione errata.\nRiprova.\n");
                System.out.println(_START_MESSAGE);
                combinazione= inputDaTastiera.nextLine();
                //TODO MODIFICARE LA FUNZIONE CHE SEGUE PER OTTIMIZZARE.
                checker=new checkString(combinazione);
            }while (selettoreValidatori.validateInput());
                if(!checker.check()){
                    viewCheckOut(checker.getCheckOut());
                }else {
                    WIN(combinazione,tentativi);
                    tentativi=0;
                }

        }while(true);

        //Controllo CodiceSegreto

    }

    private static void WIN(String combinazione,int tentativi) {
        System.out.println(_WIN+"\nNUMERO TENTATIVI "+tentativi);

    }

    private static void viewCheckOut(String[] checkOut) {
        System.out.println("N. "+checkOut[0]+" elementi corretti | N. "+checkOut[1]+" elementi in posizione errata.");
    }
}
