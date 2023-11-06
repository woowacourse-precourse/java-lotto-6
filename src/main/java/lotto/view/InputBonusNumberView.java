package lotto.view;

import java.util.regex.Pattern;

public class InputBonusNumberView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Integer getValue() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
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
