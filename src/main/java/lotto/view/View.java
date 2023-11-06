package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public static void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public static void printMessageWithArgs(Message message, Object... args) {
        System.out.println(message.getMessage(args));
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static String requestMoney(){
        printMessage(Message.REQUEST_MONEY);
        final String request = Console.readLine();
        printNewLine();
        return request;
    }

    public static String requestNumbers(){
        printMessage(Message.REQUEST_NUMBERS);
        final String request = Console.readLine();
        printNewLine();
        return request;
    }

    public static String requestNumberBonus(){
        printMessage(Message.REQUEST_NUMBER_BONUS);
        final String request = Console.readLine();
        printNewLine();
        return request;
    }
}
