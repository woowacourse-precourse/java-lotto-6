package lotto.model;

import static lotto.exception.InvalidLottoException.InvalidLottoError.DUPLICATE_LOTTO;
import static lotto.exception.InvalidLottoException.InvalidLottoError.INVALID_LOTTO_COUNT;
import static lotto.exception.InvalidLottoException.InvalidLottoError.INVALID_LOTTO_RANGE;
import static lotto.model.WinningLotto.BONUS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.InvalidLottoException;
import lotto.generator.NumberGenerator;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int BONUS_MATCH = 5;
    static final int LOTTO_MIN_NUMBER = 1;
    static final int LOTTO_MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public static Lotto generateLotto(NumberGenerator numberGenerator) {
        return new Lotto(numberGenerator.generate());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidLottoException(INVALID_LOTTO_COUNT);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number) {
                throw new InvalidLottoException(INVALID_LOTTO_RANGE);
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new InvalidLottoException(DUPLICATE_LOTTO);
        }
    }

    public WinningLotto getWinningLotto(Lotto userLotto, int bonusNumber) {
        int matchCount = getMatchCount(userLotto);
        if (matchCount == BONUS_MATCH) {
            if (numbers.contains(bonusNumber)) {
                return BONUS;
            }
        }
        return WinningLotto.from(matchCount);
    }

    private int getMatchCount(Lotto userLotto) {
        return numbers.stream()
                .filter(userLotto.getNumbers()::contains)
                .toList()
                .size();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
