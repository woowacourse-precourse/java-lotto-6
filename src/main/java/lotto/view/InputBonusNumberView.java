package lotto.view;

import static lotto.message.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

import java.util.regex.Pattern;

public class InputBonusNumberView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("\\d+");    
    private static final String INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Integer getValue() {
        System.out.println(INPUT_MESSAGE);
        String result = inputValue();
        System.out.println();
        validate(result);
        return Integer.parseInt(result);
    }

    private void validate(String inputValue) {
        validateFormat(inputValue);
    }

    private void validateFormat(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
