package lotto.view;

import static lotto.view.constants.ConstantMessage.REQUEST_INPUT_PRICE;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constants.ConstantMessage;

public class ConsoleInput {
    public static String askAmountOfMoney() {
        printConstantMessage(REQUEST_INPUT_PRICE);
        return Console.readLine();
    }

    private static void printConstantMessage(ConstantMessage message) {
        System.out.println(message.getMessage());
    }
}
