package lotto.view;

import java.util.regex.Pattern;

public class InputBuyLottoView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자여야 합니다.";
    public Integer getValue() {
        System.out.println(INPUT_MESSAGE);
        String userInput = inputValue();
        System.out.println();
        validate(userInput);
        return Integer.parseInt(userInput);
    }

    private void validate(String userInput) throws IllegalArgumentException {
        if(!PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
