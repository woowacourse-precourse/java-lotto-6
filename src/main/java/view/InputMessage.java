package view;

import camp.nextstep.edu.missionutils.Console;
import type.TextType;
import utils.Parser;

import java.util.List;

public class InputMessage {
    public static int printMoneyInputMessage() {
        System.out.println(TextType.START.getText());
        String input = Console.readLine();
        return Parser.convertNumberInput(input);
    }

    public static List<Integer> printWinNumberInputMessage() {
        System.out.println(TextType.LOTTO_WIN_NUMBER.getText());
        String input = Console.readLine();
        return Parser.convertWinningNumberInput(input);
    }

    public static int printBonusNumberInputMessage() {
        System.out.println(TextType.LOTTO_BONUS.getText());
        String input = Console.readLine();
        return Parser.convertNumberInput(input);
    }
}
