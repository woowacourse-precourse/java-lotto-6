package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;
    private LottoResult result;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    public void calculateResult(WinningLotto winningLotto) {
        result = LottoResult.compareLottoNums(numbers, winningLotto);
    }

    private void validate() {
        isCorrectSize();
        isDuplicate();
        isInRangeNumbers();
    }

    private void isCorrectSize() {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_SIZE + "개의 숫자를 입력하세요.");
        }
    }

    private void isDuplicate() {
        Set<Integer> noDupBucket = new HashSet<>(numbers);
        if (noDupBucket.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복하지 않는 숫자만 입력해주세요.");
        }
    }

    private void isInRangeNumbers() {
        numbers.forEach(number -> {
            if (number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number) {
                throw new IllegalArgumentException("[ERROR] " + LOTTO_MIN_NUMBER + "이상" + LOTTO_MAX_NUMBER + "이하인 값만 입력하세요");
            }
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoResult getResult() {
        return result;
    }
}
