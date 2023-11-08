package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_GAME_NUMBERS_SIZE = 6;
    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;
    private static final String IS_SIX_NUMBERS_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String IS_BETWEEN_LOTTO_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String IS_NOT_DUPPLICATE_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSixNumbers(numbers)) {
            throw new IllegalArgumentException(IS_SIX_NUMBERS_EXCEPTION_MESSAGE);
        }
        if (!isBetweenLottoRange(numbers)) {
            throw new IllegalArgumentException(IS_BETWEEN_LOTTO_RANGE_EXCEPTION_MESSAGE);
        }
        if (!isNotDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(IS_NOT_DUPPLICATE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private boolean isSixNumbers(List<Integer> numbers) {
        return numbers.size() == LOTTO_GAME_NUMBERS_SIZE;
    }

    private boolean isBetweenLottoRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number ->
                number >= LOTTO_GAME_START_NUMBER && number <= LOTTO_GAME_END_NUMBER);
    }

    private boolean isNotDuplicateNumber(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }
}