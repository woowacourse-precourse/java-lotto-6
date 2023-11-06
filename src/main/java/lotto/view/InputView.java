package lotto.view;

import static lotto.view.InputValidator.validateEmpty;
import static lotto.view.InputValidator.validateInteger;
import static lotto.view.InputValidator.validateIntegerArray;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.%n";

    private static final String ASK_WINNING_NUMBERS = "%n당첨 번호를 입력해 주세요.%n";
    private static final String DELIMITER_COMMA = ",";

    private static final String ASK_BONUS_NUMBER = "%n보너스 번호를 입력해 주세요.%n";

    public int askPurchaseAmount() {
        System.out.printf(ASK_PURCHASE_AMOUNT);
        String purchaseAmount = readLine();
        validateInteger(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> askWinningNumbers() {
        System.out.printf(ASK_WINNING_NUMBERS);
        String[] numbers = readLine().split(DELIMITER_COMMA);
        validateIntegerArray(numbers);
        return Arrays.stream(numbers).map(Integer::parseInt).sorted().toList();
    }

    public int askBonusNumber() {
        System.out.printf(ASK_BONUS_NUMBER);
        String bonusNumber = readLine();
        validateInteger(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private String readLine() {
        String input = Console.readLine();
        validateEmpty(input);
        return input;
    }
}
