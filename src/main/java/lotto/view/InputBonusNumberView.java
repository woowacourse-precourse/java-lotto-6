package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputBonusNumberView {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String SEPARATOR = ",";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_NOT_NUMBER = "숫자 형태의 값만 입력할 수 있습니다.";
    private static final String ERROR_NOT_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public Integer getBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String input = Console.readLine();
        System.out.println();
        try {
            validateNumeric(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + ERROR_NOT_NUMBER);
            return getBonusNumber();
        }
        return Integer.parseInt(input);
    }

    private void validateNumeric(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
