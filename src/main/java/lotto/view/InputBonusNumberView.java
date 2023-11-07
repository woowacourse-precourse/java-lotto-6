package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class InputBonusNumberView {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String BLANK = " ";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_NOT_VALIDATE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final Pattern PATTERN = Pattern.compile("\\d+");

    public Integer getBonusNumber(List<Integer> winningNumbers) {
        System.out.println(REQUEST_BONUS_NUMBER);
        String input = Console.readLine();
        System.out.println();
        try {
            validate(input);
            int bonus = Integer.parseInt(input);
            validateRangeNumber(bonus);
            validateDuplicate(winningNumbers, bonus);
            return bonus;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + ERROR_NOT_VALIDATE);
            return getBonusNumber(winningNumbers);
        }
    }

    private void validate(String input) {
        validateNumeric(input);
        validateBlank(input);
    }

    private void validateNumeric(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRangeNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}
