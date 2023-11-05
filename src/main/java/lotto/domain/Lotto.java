package lotto.domain;

import static lotto.util.ConstantUtils.LOTTO_SIZE_CRITERION;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.enums.LottoPrize;
import lotto.util.ValidationUtils;

public class Lotto {

    private final List<Number> numbers;

    public Lotto(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public LottoPrize matches(WinningLotto winningLotto) {
        int matchCount = winningLotto.getMatchCount(this.numbers);
        boolean isBonusMatched = winningLotto.isBonusMatched(this.numbers);
        return LottoPrize.findLottoPrize(matchCount, isBonusMatched);
    }

    private void validate(List<Number> numbers) {
        ValidationUtils.validateNotNull(numbers);
        validateLottoNumbersSize(numbers);
        validateNoDuplicatedLottoNumbers(numbers);
    }

    private void validateLottoNumbersSize(List<Number> numbers) {
        if (numbers.size() != LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoDuplicatedLottoNumbers(List<Number> numbers) {
        Set<Number> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException();
        }
    }
}
