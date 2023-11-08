package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constant.ViewMessage;
import lotto.util.StringHandler;

public class InputView {

    private static final String STRING_DELIMITER = ",";

    public int inputPurchaseAmount() {
        System.out.println(ViewMessage.AMOUNT_MESSAGE.getMessage());
        String input = Console.readLine();

        return StringHandler.stringToInt(input);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(ViewMessage.WINNING_NUMBER_MESSAGE.getMessage());
        String input = Console.readLine();
        return StringHandler.separatedWith(input, STRING_DELIMITER);
    }

    public int inputBonusNumber() {
        System.out.println(ViewMessage.BONUS_NUMBER_MESSAGE.getMessage());
        String input = Console.readLine();
        return StringHandler.stringToInt(input);
    }

}
