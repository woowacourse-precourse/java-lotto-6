package view;

import camp.nextstep.edu.missionutils.Console;
import type.TextType;
import utils.Parser;

public class InputMessage {
    public static int printMoneyInputMessage() {
        System.out.println(TextType.START);
        String input = Console.readLine();
        return Parser.convertNumberInput(input);
    }
}
