package lotto.view.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.validator.NumberValidator;
import lotto.validator.StringValidator;
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
        return readPositiveNumber();
    }

    @Override
    public List<Integer> readWinningNumbers() {
        System.out.println();
        System.out.println(ENTER_WINNING_NUMBERS);
        return readIntegerList();
    }

    @Override
    public int readBonusNumber() {
        System.out.println();
        System.out.println(ENTER_BONUS_NUMBER);
        return readPositiveNumber();
    }

    private String readNonEmptyInput() {
        String input = Console.readLine();
        StringValidator.of(input).shouldNotEmpty(ErrorMessage.INPUT_IS_EMPTY);
        return input;
    }

    private int readPositiveNumber() {
        String input = readNonEmptyInput();
        int number = InputUtil.parseInputToInt(input);
        NumberValidator.of(number).shouldPositive(ErrorMessage.INPUT_NOT_POSITIVE_NUMBER);
        return number;
    }

    private List<Integer> readIntegerList() {
        String input = readNonEmptyInput();
        return InputUtil.parseInputToIntegers(input, DELIMITER);
    }
}
