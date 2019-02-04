package com.thinkopen.academy;

import com.thinkopen.academy.core.ValidatorCharArray;
import com.thinkopen.academy.util.Validator.ValidatorCharArrayInput;
import com.thinkopen.academy.util.Validator.ValidatorStringInput;

public class SelectValidator implements Validatori{
//todo Costruttore

SelectValidator(Object input) {

    ValidatorStringInput.validaStringaInput((String) input);
        //todo cercare factory e factory builder
        //un factory che restituisce uno strategy object
    }
        //IMPLEMENTO INTERFACCIA
        //todo GENERIC STRATEGY
        //todo VALIDATE PUBLIC GENERIC

        @Override
        public  boolean validate(Object input) {
            if (input instanceof String) {
                return ValidatorStringInput.validaStringaInput((String) input);
            } else if (input instanceof char[]) {
                return ValidatorCharArrayInput.validaCharArrayInput((char[]) input);
            }else {
                return false;
            }
        }
}