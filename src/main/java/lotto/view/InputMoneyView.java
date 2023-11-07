package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputMoneyView {
    private static final int MIN_VALUE = 1;
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private static final String ERROR_MESSAGE = "[ERROR] 1,000원 단위의 숫자만 입력할 수 있습니다.";
    private static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public String getInputMoney() {
        System.out.println(REQUEST_INPUT_MONEY);
        String input = Console.readLine();
        System.out.println();
        try {
            validate(input);
            validateNumeric(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
            input = getInputMoney();
        }
        return input;
    }

    private void validate(String input) {
        int number = Integer.parseInt(input);
        validateRange(number);
        validateRemainder(number);
    }

    private void validateNumeric(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(int number) {
        if (number < MIN_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRemainder(int number) {
        if (number % THOUSAND != ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
