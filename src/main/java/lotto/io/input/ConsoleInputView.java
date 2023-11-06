package lotto.io.input;

import static lotto.exception.ExceptionMessage.INVALID_INPUT;
import static lotto.exception.ExceptionMessage.LOTTO_MONEY_NOT_INTEGER;
import static lotto.utils.constant.IOConstant.INPUT_DELIMITER;
import static lotto.utils.string.StringUtils.splitStringByDelimiter;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConsoleInputView implements InputView {

    private static final String DELIMITER = INPUT_DELIMITER.getValue();

    @Override
    public String getLottoMoney() {
        String inputValue = Console.readLine();
        validateSimpleNumber(inputValue);
        return inputValue;
    }

    @Override
    public List<String> getWinningNumbers() {
        String inputValue = Console.readLine();
        checkIsValidInput(inputValue);

        Arrays.stream(inputValue.split(DELIMITER))
                .forEach(this::validateSimpleNumber);

        return splitStringByDelimiter(inputValue, DELIMITER);
    }

    @Override
    public String getBonusNumber() {
        String inputValue = Console.readLine();
        validateSimpleNumber(inputValue);
        return inputValue;
    }

    private void validateSimpleNumber(String inputValue) {
        checkIsValidInput(inputValue);
        checkIsDigit(inputValue);
    }

    private void checkIsDigit(String inputValue) {
        if (!inputValue.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(LOTTO_MONEY_NOT_INTEGER.getMessage());
        }
    }

    private void checkIsValidInput(String inputValue) {
        if ( Objects.isNull(inputValue) || inputValue.isBlank() || inputValue.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}
