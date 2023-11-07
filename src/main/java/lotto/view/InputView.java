package lotto.view;

import static lotto.exception.InvalidInputException.InvalidInputError.INPUT_NOT_BLANK;
import static lotto.exception.InvalidInputException.InvalidInputError.INVALID_AMOUNT;
import static lotto.exception.InvalidInputException.InvalidInputError.NUMBER_NEED;
import static lotto.exception.InvalidInputException.InvalidInputError.POSITIVE_NUMBER_NEED;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.InvalidInputException;
import org.junit.platform.commons.util.StringUtils;

public class InputView {
    private static final String DELIMITER = ",";
    private static final int DIVIDE_NUMBER = 1000;

    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public Integer inputAmount() {
        while (true) {
            try {
                System.out.println(INPUT_AMOUNT_MESSAGE);
                int amount = inputPositiveNumber();
                validateAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer inputPositiveNumber() {
        String input = Console.readLine();
        validateNumberInput(input);
        return Integer.parseInt(input);
    }

    private void validateNumberInput(String input) {
        validateBlank(input);
        validateNumber(input);
        validatePositiveNumber(input);
    }

    private void validateBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new InvalidInputException(INPUT_NOT_BLANK);
        }
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(NUMBER_NEED);
        }
    }

    private void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new InvalidInputException(POSITIVE_NUMBER_NEED);
        }
    }

    private void validateAmount(int amount) {
        if (amount % DIVIDE_NUMBER != 0) {
            throw new InvalidInputException(INVALID_AMOUNT);
        }
    }

    public Integer inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return inputPositiveNumber();
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String input = Console.readLine();
        validateNumbersInput(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNumbersInput(String input) {
        Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .forEach(this::validateNumberInput);
    }
}
