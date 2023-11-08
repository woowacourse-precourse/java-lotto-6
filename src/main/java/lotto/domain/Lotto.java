package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Set;

import static lotto.domain.LottoCondition.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoCondition.MIN_LOTTO_NUMBER;

public class Lotto {

    private static final int LOTTO_LENGTH = 6;
    private static final String ERROR_INVALID_LOTTO_LENGTH = "로또 번호는 %d자리여야 합니다.".formatted(LOTTO_LENGTH);
    private static final String ERROR_DUPLICATE_NUMBER_EXIST = "로또 번호는 중복되지 않아야 합니다.";

    private final List<Integer> numbers;

    public Lotto() {
        this(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_LENGTH));
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
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
        validateIsUnique(numbers);
    }

    private void validateIsSatisfyLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_LENGTH);
        }
    }

    private void validateIsInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            LottoCondition.validateIsInRange(number);
        }
    }

    private void validateIsUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = Set.copyOf(numbers);
        if (uniqueNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER_EXIST);
        }
    }
}
