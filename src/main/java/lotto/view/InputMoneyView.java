package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputMoneyView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String ERROR_NOT_NUMBER = "숫자 형태의 값만 입력할 수 있습니다.";
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public String getInputMoney() {
        System.out.println(REQUEST_INPUT_MONEY);
        String input = Console.readLine();
        System.out.println();
        try {
            validateNumeric(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + ERROR_NOT_NUMBER);
            input = getInputMoney();
        }
        return input;
    }

    private void validateNumeric(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
