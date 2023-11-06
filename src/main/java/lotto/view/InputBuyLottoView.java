package lotto.view;

import java.util.regex.Pattern;

public class InputBuyLottoView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

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
