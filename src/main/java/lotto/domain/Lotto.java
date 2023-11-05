package lotto.domain;

import static lotto.util.ConstantUtils.LOTTO_SIZE_CRITERION;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.enums.LottoPrize;
import lotto.util.ValidationUtils;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public LottoPrize matches(WinningLotto winningLotto) {
        int matchCount = winningLotto.getMatchCount(this.numbers);
        boolean isBonusMatched = winningLotto.isBonusMatched(this.numbers);
        return LottoPrize.findLottoPrize(matchCount, isBonusMatched);
    }

    private void validate(List<Integer> numbers) {
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
