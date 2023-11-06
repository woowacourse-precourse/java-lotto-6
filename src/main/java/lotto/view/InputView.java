package lotto.view;

import static lotto.util.Utils.convertStringToInt;
import static lotto.util.Utils.removeSpace;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.PurchaseAmountValidator;
import lotto.util.WinningNumbersValidator;

public class InputView {

    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PROMPT_WINNING_TICKET = "당첨 번호를 입력해 주세요.";

    public int readPurchaseAmount() {
        try {
            System.out.println(PROMPT_PURCHASE_AMOUNT);
            String userInput = Console.readLine();
            new PurchaseAmountValidator().validate(userInput);

            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount();
        }
    }

    public List<Integer> readWinningNumbers() {
        try {
            System.out.println(PROMPT_WINNING_TICKET);
            String userInput = Console.readLine();
            new WinningNumbersValidator().validate(userInput);

            return convertStringToInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumbers();
        }
    }
}
