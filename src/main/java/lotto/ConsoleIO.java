package lotto;


import camp.nextstep.edu.missionutils.Console;

public class ConsoleIO {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String getInput(String askMessage) {
        System.out.println(askMessage);
        return Console.readLine();
    }

}
