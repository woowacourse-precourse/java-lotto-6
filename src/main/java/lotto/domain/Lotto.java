package lotto.domain;

import static lotto.exception.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.EMPTY;
import static lotto.exception.ErrorMessage.MISMATCH_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generateRandom() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }

    private void validate(List<Integer> numbers) {

        if (numbers.isEmpty()) {
            throw LottoException.of(EMPTY);
        }

        if (numbers.size() != 6) {
            throw LottoException.of(MISMATCH_LOTTO_NUMBER);
        }

        if (isOutOfRange(numbers)) {
            throw LottoException.of(OUT_OF_RANGE_LOTTO_NUMBER);
        }

        if (isDuplicated(numbers)) {
            throw LottoException.of(DUPLICATED_LOTTO_NUMBER);
        }
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return !numbers.stream()
                .allMatch(number -> number >= 1 && number <= 45);
    }

    private boolean isDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
