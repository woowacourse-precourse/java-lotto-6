package view;

import camp.nextstep.edu.missionutils.Console;
import type.TextType;
import utils.Parser;
import utils.Validator;

import java.util.List;

public class InputMessage {

    public static final String ENTER = "\n";

    public static int printMoneyInputMessage() {
        System.out.println(TextType.START.getText());
        String input = Console.readLine();
        int convertNum = Parser.convertNumberInput(input);
        Validator.checkMoney(convertNum);
        return convertNum;
    }

    public static List<Integer> printWinNumberInputMessage() {
        System.out.println(TextType.LOTTO_WIN_NUMBER.getText());
        String input = Console.readLine();
        return Parser.convertWinningNumberInput(input);
    }

    public static int printBonusNumberInputMessage() {
        System.out.println(ENTER + TextType.LOTTO_BONUS.getText());
        String input = Console.readLine();
        return Parser.convertNumberInput(input);
    }
}
