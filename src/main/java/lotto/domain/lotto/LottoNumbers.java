package lotto.domain.lotto;

import lotto.constants.LottoConsts;
import lotto.exception.constants.ErrorConsts;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public record LottoNumbers(
        List<LottoNumber> numbers
) {
    public LottoNumbers(final List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = makeUnmodifiable(numbers);
    }

    private void validate(final List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
    }

    private void validateSize(final List<LottoNumber> numbers) {
        if (numbers.size() != LottoConsts.LOTTO_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorConsts.LOTTO_NUMBERS_SIZE_NOT_MATCH.getMessage());
        }
    }

    private void validateDuplicated(final List<LottoNumber> numbers) {
        final Set<LottoNumber> lottoNumbers = Set.copyOf(numbers);

        if (lottoNumbers.size() != LottoConsts.LOTTO_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorConsts.LOTTO_NUMBERS_DUPLICATED.getMessage());
        }
    }

    private List<LottoNumber> makeUnmodifiable(final List<LottoNumber> numbers) {
        return Collections.unmodifiableList(numbers);
    }
}
