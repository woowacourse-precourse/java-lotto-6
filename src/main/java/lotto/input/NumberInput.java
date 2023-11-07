package lotto.input;


import java.util.Set;

public class NumberInput {
    private static final String FORMAT_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 1과 45 사이의 숫자를 입력해주세요";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 숫자가 존재합니다. 다시 입력해주세요.";

    protected static int validateNumberFormat(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println();
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }

    protected static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            System.out.println();
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    protected static void validateDuplicate(int number, Set<Integer> winningNumbers) {
        if (!winningNumbers.add(number)) {
            System.out.println();
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
