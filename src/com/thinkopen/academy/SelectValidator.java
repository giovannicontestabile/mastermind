package com.thinkopen.academy;

import javax.xml.validation.Validator;

public class SelectValidator implements Validatori{
//todo Costruttore

SelectValidator(Object input) {
        //todo cercare factory e factory builder
    //un factory che restituisce uno strategy object
    }
           //IMPLEMENTO INTERFACCIA
        //todo GENERIC STRATEGY


        //todo VALIDATE PUBLIC GENERIC
        @Override
        public  boolean validate(Object input) {
            if (input instanceof String) {
                String inputCombinazione = (String) input;

                return validaStringa.validaString(inputCombinazione);
            } else if (input instanceof char[]) {
                ValidatorCharArray validaCharArray=new ValidatorCharArray();
                return validaCharArray.validaVettoreChar(input);
            }else {
                return false;
            }
        }
}