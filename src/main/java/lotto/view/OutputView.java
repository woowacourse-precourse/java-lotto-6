package lotto.view;

public class OutputView {
    private static void printMessage(String message){
        System.out.println(message);
    }
    public static void printPaymentMessage(){
        printMessage(OutputViewMessage.PAYMENT.getMessage());
    }
    public static void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }
}