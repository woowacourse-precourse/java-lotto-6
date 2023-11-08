package lotto;

import static lotto.ErrorMessage.LOTTO_BONUS_ONLY_ONE;
import static lotto.ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR;
import static lotto.ErrorMessage.LOTTO_NUMBER_ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LuckyNumberInputView {
    private static final int INPUT_DIGIT_FIRST = 1;
    private static final int INPUT_DIGIT_LAST = 45;
    private static final int NUMBER_LENGTH_MIN = 1;
    private static final int NUMBER_LENGTH_MAX = 2;
    private String input;
    private int luckyNumber;

    private List<Integer> numbers;

    LuckyNumberInputView(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

    private void validate() {
        input = Console.readLine();
        try {
            validateLength();
            validateOnlyOne();
            validateNumerics();
            validateDupleNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            validate();
        }
    }

    private void validateLength() {
        int inputLength = input.length();
        if (NUMBER_LENGTH_MIN > inputLength) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR);
        }
        if (inputLength > NUMBER_LENGTH_MAX) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR);
        }
    }

    private void validateOnlyOne() {
        try {
            luckyNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_BONUS_ONLY_ONE);
        }
    }

    private void validateNumerics() {
        if (!isDigit()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR);
        }
    }

    private void validateDupleNumber() {
        boolean isContained = numbers.contains(luckyNumber);
        if (isContained) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    private boolean isDigit() {
        return INPUT_DIGIT_FIRST <= luckyNumber && luckyNumber <= INPUT_DIGIT_LAST;
    }
}