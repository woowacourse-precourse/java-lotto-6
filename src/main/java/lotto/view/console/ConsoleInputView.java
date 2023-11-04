package lotto.view.console;

import java.util.List;
import lotto.view.InputView;
import lotto.view.console.util.InputUtil;

public class ConsoleInputView implements InputView {
    private static final String ENTER_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";

    @Override
    public int readPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT_MESSAGE);
        return InputUtil.readNaturalInt();
    }

    @Override
    public List<Integer> readWinningNumbers() {
        System.out.println();
        System.out.println(ENTER_WINNING_NUMBERS);
        String input = InputUtil.readNonEmptyLineInput();
        return InputUtil.parseInputToIntegers(input, DELIMITER);
    }

    @Override
    public int readBonusNumber() {
        System.out.println();
        System.out.println(ENTER_BONUS_NUMBER);
        return InputUtil.readNaturalInt();
    }
}
