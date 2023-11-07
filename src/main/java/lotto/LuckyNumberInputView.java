package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
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
            throw new IllegalArgumentException("[ERROR] 최소 1 자리 이상의 숫자를 입력 해야합니다.");
        }
        if (inputLength > NUMBER_LENGTH_MAX) {
            throw new IllegalArgumentException("[ERROR] : 최대 2 자리의 숫자만 입력 가능합니다.");
        }
    }

    private void validateOnlyOne() {
        try {
            luckyNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 오직 하나의 숫자만 가능합니다.");
        }
    }

    private void validateNumerics() {
        if (!isDigit()) {
            throw new IllegalArgumentException("[ERROR] : 1-45 내 숫자를 입력해주세요.");
        }
    }

    private void validateDupleNumber() {
        boolean isContained = numbers.contains(luckyNumber);
        if (isContained) {
            throw new IllegalArgumentException("[ERROR] : 당첨 번호와 중복 될 수 없습니다.");
        }
    }

    private boolean isDigit() {
        return INPUT_DIGIT_FIRST <= luckyNumber && luckyNumber <= INPUT_DIGIT_LAST;
    }
}