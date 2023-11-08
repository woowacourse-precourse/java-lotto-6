package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final String ERROR_MESSAGE_NUMBER_SIZE = "[ERROR] 로또 번호는 6자리여야 합니다.";
    private static final String ERROR_MESSAGE_LOTTO_DUPLICATION = "[ERROR] 로또 번호는 중복이 없어야 합니다.";
    private static final String ERROR_MESSAGE_LOTTO_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getMatchNumberCnt(Lotto otherLotto) {
        return (int) this.numbers.stream()
                .filter(otherLotto.numbers::contains)
                .count();
    }

    public boolean hasNumber(int num) {
        return numbers.contains(num);
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplication(numbers);
        validateAllInRange(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_SIZE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_DUPLICATION);
        }
    }


    private void validateAllInRange(List<Integer> numbers) {
        for (int num : numbers) {
            validateInRange(num);
        }
    }

    private void validateInRange(int num) {
        if (num < MIN_RANGE || num > MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_RANGE);
        }
    }
}
