package lotto;

import java.util.Collections;
import java.util.List;
import lotto.model.WinningLotto;

public class Lotto {
    private static final String INVALID_LOTTO_SIZE = "[ERROR] 로또는 6개의 숫자로 이루어져야 합니다.";
    private static final String INVALID_NUMBER_RANGE = "[ERROR] 로또 번호의 범위는 1 ~ 45까지 입니다.";
    private static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또의 6개의 수는 중복될 수 없습니다.";
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> get() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MIN_RANGE || number > MAX_RANGE);
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public int countSameNumbers(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContain)
                .count();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }
}
