package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.messages.InputMessage;
import lotto.utils.Util;
import lotto.validates.InputValidate;

public class Input {

    public static int getPurchaseAmount() {
        InputMessage inputMessage = InputMessage.ENTER_PURCHASE_AMOUNT;
        System.out.println(inputMessage.getInputView());
        String input = Console.readLine();
        InputValidate.numberValidate(input);
        return Util.stringToIntger(input);
    }

    public static List<Integer> getWinningLotto() {
        InputMessage inputMessage = InputMessage.ENTER_WINNING_NUMBER;
        System.out.println(inputMessage.getInputView());
        String input = Console.readLine();
        InputValidate.numbersValidate(input);
        return Util.stringToSortedIntegerList(input);
    }

    public static int getBonusNumber() {
        InputMessage inputMessage = InputMessage.ENTER_BONUS_NUMBER;
        System.out.println(inputMessage.getInputView());
        String input = Console.readLine();
        InputValidate.numberValidate(input);
        return Util.stringToIntger(input);
    }

}
