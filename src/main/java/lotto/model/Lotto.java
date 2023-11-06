package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Lotto(List<Integer> numbers) {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    public LottoResult calculateResult(WinningLotto winningLotto) {
        return LottoResult.compareLottoNums(numbers, winningLotto);
    }

    private void validate(List<Integer> numbers) {
        isCorrectSize(numbers);
        isDuplicate(numbers);
        isInRangeNumbers(numbers);
    }

    private void isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_SIZE + "개의 숫자를 입력하세요.");
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> noDupBucket = new HashSet<>(numbers);
        if (noDupBucket.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복하지 않는 숫자만 입력해주세요.");
        }
    }

    private void isInRangeNumbers(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number) {
                throw new IllegalArgumentException(
                        "[ERROR] " + LOTTO_MIN_NUMBER + "이상" + LOTTO_MAX_NUMBER + "이하인 값만 입력하세요");
            }
        });
    }
}
