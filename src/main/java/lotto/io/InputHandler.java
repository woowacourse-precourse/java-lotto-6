package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String askAmount() {
        printMessage(Command.ASK_AMOUNT);
        return Console.readLine();
    }

    public static String askWinningNumbers() {
        printMessage(Command.ASK_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String askBonusNumber() {
        printMessage(Command.ASK_BONUS_NUMBER);
        return Console.readLine();
    }

    private static void printMessage(Command command) {
        System.out.println(command.prompt());
    }
}
