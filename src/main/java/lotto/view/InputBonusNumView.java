package lotto.view;

import java.util.regex.Pattern;

public class InputBonusNumView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("\\d+");
    private static final String INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다.";

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
