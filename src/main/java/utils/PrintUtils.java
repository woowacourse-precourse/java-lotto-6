package utils;

import constants.ErrorCodeConstant;

public class PrintUtils {

    public static void println(String message){
        System.out.println(message);
    }
    public static void printf(String formatMessage, Object args){
        System.out.printf("%n"+formatMessage+"%n",args);
    }
    public static void errorPrint(String message){
        System.out.println(ErrorCodeConstant.DEFAULT_ERROR + message);
    }

}
