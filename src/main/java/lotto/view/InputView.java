package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    protected String inputValue() {
        return Console.readLine();
    }

    public Integer getValue() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String result = inputValue();
        System.out.println();
        validateFormat(result);
        return Integer.parseInt(result);
    }

    private void validateFormat(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
