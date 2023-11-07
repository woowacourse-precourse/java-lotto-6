package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final String LOTTO_WRONG_SIZE_ERROR = "[ERROR] " + LOTTO_SIZE + "개의 숫자를 입력하세요.";
    public static final String LOTTO_DUPLICATE_ERROR = "[ERROR] 중복하지 않는 숫자만 입력해주세요.";
    public static final String LOTTO_RANGE_ERROR =
            "[ERROR] 로또 숫자는 " + LOTTO_MIN_NUMBER + "이상 " + LOTTO_MAX_NUMBER + "이하인 값만 입력하세요";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public LottoResult calculateResult(WinningLotto winningLotto) {
        return LottoResult.compareLottoNums(numbers, winningLotto);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        isCorrectSize(numbers);
        isDuplicate(numbers);
        isInRangeNumbers(numbers);
    }

    private void isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_WRONG_SIZE_ERROR);
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> noDupBucket = new HashSet<>(numbers);
        if (noDupBucket.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR);
        }
    }

    private void isInRangeNumbers(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number) {
                throw new IllegalArgumentException(LOTTO_RANGE_ERROR);
            }
        });
    }
}
