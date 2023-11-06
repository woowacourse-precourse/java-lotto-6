package lotto.domain.lotto;

import static lotto.util.ConstantUtils.LOTTO_SIZE_CRITERION;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ValidationUtils;

public class Lotto {

    protected final List<Integer> numbers;

    protected Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
            .filter(numbers::contains)
            .count();
    }

    public boolean isBonusMatched(BonusNumber bonusNumber) {
        return bonusNumber.isIn(numbers);
    }

    protected void validate(List<Integer> numbers) {
        ValidationUtils.validateNotNull(numbers);
        validateLottoNumbersSize(numbers);
        validateNoDuplicatedLottoNumbers(numbers);
    }

    private void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoDuplicatedLottoNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException();
        }
    }
}
