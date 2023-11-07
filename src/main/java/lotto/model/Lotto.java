package lotto.model;

import java.util.*;

public class Lotto {

    // 필드(인스턴스 변수) 추가 불가능!
    // 패키지 변경은 가능!

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String DELIMITER_OF_PURCHASE_LOTTO = ", ";
    private static final String FORMAT_OF_PURCHASE_LOTTO = "[%s]";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public String getNumbersToString() {
        List<String> numbers = integerListToStringList(this.numbers);
        String numbersLine = String.join(DELIMITER_OF_PURCHASE_LOTTO, numbers);
        return String.format(FORMAT_OF_PURCHASE_LOTTO, numbersLine);
    }

    public int countSameNumbers(Lotto lotto) {
        int correctCount = 0;
        for (int number : lotto.numbers) {
            if (isContains(number)) {
                correctCount += 1;
            }
        }
        return correctCount;
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList(); // TODO: check convention!
    }

    private List<String> integerListToStringList(List<Integer> beforeType) {
        return beforeType.stream()
                .map(number -> Integer.toString(number))
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplication(numbers);
    }

    private void validateNumbersDuplication(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            Error.NOT_UNIQUE_WINNING_NUMBER.throwError();
        }
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBER_COUNT) {
            Error.NOT_VALID_WINNING_NUMBER_COUNT.throwError();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (isOutOfLottoNumbersRange(number)) {
                Error.NOT_VALID_WINNING_NUMBER_RANGE.throwError();
            }
        }
    }

    private boolean isOutOfLottoNumbersRange(int number) {
        return number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER;
    }
}
