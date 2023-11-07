package lotto.domain.lotto;

import lotto.constants.LottoConsts;
import lotto.exception.constants.ErrorConsts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record LottoNumbers(
        Set<LottoNumber> numbers
) {
    public LottoNumbers(final Set<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = makeUnmodifiable(numbers);
    }

    public static LottoNumbers from(final List<Integer> numbers) {
        return new LottoNumbers(
                numbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toSet())
        );
    }

    private void validate(final Set<LottoNumber> numbers) {
        validateSize(numbers);
    }

    private void validateSize(final Set<LottoNumber> numbers) {
        if (numbers.size() != LottoConsts.LOTTO_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorConsts.LOTTO_NUMBERS_SIZE_NOT_MATCH.getMessage());
        }
    }

    private Set<LottoNumber> makeUnmodifiable(final Set<LottoNumber> numbers) {
        return Set.copyOf(numbers);
    }

    public int countMatch(final LottoNumbers otherNumbers) {
        final Set<LottoNumber> intersection = new HashSet<>(this.numbers);
        intersection.retainAll(otherNumbers.numbers);

        return intersection.size();
    }

    public boolean checkBonusNumber(final LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
