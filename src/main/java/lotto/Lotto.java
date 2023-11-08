package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_LENGTH = 6;
    private static final String ERROR_INVALID_LOTTO_LENGTH = "[ERROR] 로또 번호는 6자리여야 합니다.";

    private final List<Integer> numbers;

    public Lotto() {
        this(Randoms.pickUniqueNumbersInRange(
                LottoCondition.MIN_LOTTO_NUMBER,
                LottoCondition.MAX_LOTTO_NUMBER,
                LOTTO_LENGTH));
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public int countMatchNumber(Lotto lotto) {
        int matchCount = 0;
        for (Integer number : numbers) {
            if (lotto.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        validateIsSatisfyLottoLength(numbers);
        validateIsInRange(numbers);
    }

    private void validateIsInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            LottoCondition.validateIsInRange(number);
        }
    }

    private void validateIsSatisfyLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_LENGTH);
        }
    }
}
