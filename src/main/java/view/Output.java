package view;

import contant.ErrorMessage;

public class Output {

    public static void printErrorNullMessage(){
        System.out.println(ErrorMessage.NULL_MESSAGE);
    }

    public static void printErrorNumbericMessage(){
        System.out.println(ErrorMessage.NUMBERIC_MESSAGE);
    }
}
