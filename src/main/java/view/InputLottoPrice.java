package view;

import message.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public final class InputLottoPrice {
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public Integer inputLottoPrice() {
        System.out.println(INPUT_MESSAGE);
        String price = Console.readLine();
        System.out.println();
        validate(price);
        return Integer.parseInt(price);
    }

    private void validate(String price) {
        validateFormat(price);
    }

    private void validateFormat(String price) {
        if (!PATTERN.matcher(price).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_ERROR);
        }
    }
}