package lotto.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.LottoPurchaseMoney;

public class InputView {

    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.%n";
    private static final String ASK_WINNING_NUMBERS = "%n당첨 번호를 입력해 주세요.%n";
    private static final String DELIMITER_COMMA = ",";
    private static final String ASK_BONUS_NUMBER = "%n보너스 번호를 입력해 주세요.%n";

    private final InputValidator validator;

    public InputView(final InputValidator validator) {
        this.validator = validator;
    }

    public LottoPurchaseMoney askPurchaseMoney() {
        System.out.printf(ASK_PURCHASE_AMOUNT);
        String purchaseMoney = readLine();
        validator.validateInteger(purchaseMoney);
        int amount = Integer.parseInt(purchaseMoney);
        return LottoPurchaseMoney.from(amount);
    }

    public Lotto askWinningNumbers() {
        System.out.printf(ASK_WINNING_NUMBERS);
        String[] splitNumbers = readLine().split(DELIMITER_COMMA);
        validator.validateIntegerArray(splitNumbers);
        List<Integer> numbers = Arrays.stream(splitNumbers).map(Integer::parseInt).sorted().toList();
        return new Lotto(numbers);
    }

    public int askBonusNumber() {
        System.out.printf(ASK_BONUS_NUMBER);
        String bonusNumber = readLine();
        validator.validateInteger(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private String readLine() {
        String input = Console.readLine();
        validator.validateEmpty(input);
        return input;
    }
}
