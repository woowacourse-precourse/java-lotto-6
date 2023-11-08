package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;
import lotto.constant.GameMessage;
import lotto.utils.StringUtils;
import java.util.List;

public class InputView {

    public int readPurchaseAmount() {
        System.out.println(GameMessage.ASK_PAY_AMOUNT);
        String purchaseAmountInput = Console.readLine();

        try {
            return StringUtils.stringToInt(purchaseAmountInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + ErrorMessage.NOT_NUMBER);
            return readPurchaseAmount();
        }
    }

    public List<Integer> readWinnerNumbers() {
        System.out.println(GameMessage.ASK_WINNING_NUMBER);

        String winnerNumberInput = Console.readLine();

        try {
            List<String> winnerNumbers = StringUtils.splitString(winnerNumberInput);
            return StringUtils.convertToIntegerList(winnerNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + ErrorMessage.REQUIRED_FOR_WINNING_NUMBERS);
            return readWinnerNumbers();
        }
    }

    public int readBonusNumber() {
        printBlank();
        System.out.println(GameMessage.ASK_BONUS_NUMBER);

        String bonusNumber = Console.readLine();
        return StringUtils.stringToInt(bonusNumber);
    }

    private void printBlank() {
        System.out.println();
    }
}
