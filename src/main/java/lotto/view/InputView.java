package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class InputView {
    private static final String DELIMITER = ",";

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
            throw new IllegalArgumentException("공백 입력은 안됩니다.");
        }
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자가 아닌 숫자 입력 해주세요.");
        }
    }

    private void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("양의 자연수를 입력 해주세요.");
        }
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1000으로 나누어떨어져야 합니다.");
        }
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

    public Integer inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return inputPositiveNumber();
    }
}
