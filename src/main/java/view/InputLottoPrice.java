package view;

import message.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public final class InputLottoPrice {
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public Integer inputLottoPrice() {
        System.out.println(INPUT_MESSAGE);
        String result = Console.readLine();
        System.out.println();
        validate(result);
        return Integer.parseInt(result);
    }

    private void validate(String inputValue) {
        validateFormat(inputValue);
    }

    private void validateFormat(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_ERROR);
        }
    }
}