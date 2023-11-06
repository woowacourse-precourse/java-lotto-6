package lotto.model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    static private final int NUMBERS_SIZE = 6;
    static private final int MIN_NUMBER = 1;
    static private final int MAX_NUMBER = 45;
    static private final int AVAILABLE_NUMBER = 46;
    static private final String PROMPT_ERROR = "[ERROR]";
    static private final String PROMPT_EXCEPTION_SIZE = PROMPT_ERROR + " 로또 번호는 " + NUMBERS_SIZE + "개여야 합니다.";
    static private final String PROMPT_EXCEPTION_OUT_OF_RANGE =
            PROMPT_ERROR + " 로또 번호는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이의 수여야 합니다.";
    static private final String PROMPT_EXCEPTION_DUPLICATE = PROMPT_ERROR + " 로또 번호는 서로 다른 수여야 합니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkForEachNumber(numbers);
    }

    private void checkForEachNumber(List<Integer> numbers) {
        final boolean[] checkDuplicateNumber = new boolean[AVAILABLE_NUMBER];
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(PROMPT_EXCEPTION_OUT_OF_RANGE);
            }
            if (checkDuplicateNumber[number]) {
                throw new IllegalArgumentException(PROMPT_EXCEPTION_DUPLICATE);
            }
            checkDuplicateNumber[number] = true;
        }
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(PROMPT_EXCEPTION_SIZE);
        }
    }
}
