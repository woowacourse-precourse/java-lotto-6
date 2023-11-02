package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;

public class InputView {

    private static String input() {
        return Console.readLine();
    }

    public static int AmountInput() {
        String inputValue = input();
        
        InputValidator.nullCheck(inputValue);
        InputValidator.blankCheck(inputValue);
        return InputValidator.numberTypeCheck(inputValue);
    }

}
