package com.thinkopen.academy;

import com.thinkopen.academy.util.Validator.ValidatorCharArrayInput;
import com.thinkopen.academy.util.Validator.ValidatorStringInput;
//todo cercare factory e factory builder
//todo Costruttore
//todo GENERIC STRATEGY
//todo VALIDATE PUBLIC GENERIC
//un factory che restituisce uno strategy object

public class SelectValidator /*implements Validatori*/{

    private Object toValidate;

SelectValidator(Object input) {

    toValidate=castedObject(input);

    }

    private String castedObject(Object input) {
        if (input instanceof String) {
            return (String) input;
        } else if (input instanceof char[]) {
            return (String) input;
        }else {
            return null;
        }
    }
    public  boolean validateInput() {
        if (toValidate instanceof String) {
            System.out.println("instanceStringTrue");//debug TODO WORKS!!! GO NEXT
            return ValidatorStringInput.validaStringaInput((String) toValidate);
        } else if (toValidate instanceof char[]) {
            System.out.println("instanceStringFalse");//debug
            return ValidatorCharArrayInput.validaCharArrayInput((char[]) toValidate);
        }else {
            return false;
        }
    }

   /****old version
    *  @Override
        public  boolean validate(Object input) {
            if (input instanceof String) {
                return ValidatorStringInput.validaStringaInput((String) input);
            } else if (input instanceof char[]) {
                return ValidatorCharArrayInput.validaCharArrayInput((char[]) input);
            }else {
                return false;
            }
        }
        */
}