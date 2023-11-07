package lotto.domain.lotto;

import lotto.constants.ErrorConsts;
import lotto.constants.LottoConsts;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record LottoNumbers(
        Set<LottoNumber> numbers
) {
    public LottoNumbers(final Set<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = makeUnmodifiable(numbers);
//        this.numbers = numbers;
    }

    public static LottoNumbers from(final List<Integer> numbers) {
        return new LottoNumbers(
                numbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
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
        return Collections.unmodifiableSet(new LinkedHashSet<>(numbers));
    }

    public int countMatch(final LottoNumbers otherNumbers) {
        final Set<LottoNumber> intersection = new LinkedHashSet<>(this.numbers);
        intersection.retainAll(otherNumbers.numbers);

        return intersection.size();
    }

    public boolean checkBonusNumber(final LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
