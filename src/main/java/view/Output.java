package view;

import constant.ErrorMessage;

public class Output {

    public static void printErrorNullMessage(){
        System.out.println(ErrorMessage.NULL_MESSAGE);
    }

    public static void printErrorNumbericMessage(){
        System.out.println(ErrorMessage.NUMBERIC_MESSAGE);
    }

    public static void printErrorFitLottoCostMessage(){
        System.out.println(ErrorMessage.FIT_LOTTO_COST);
    }
}
