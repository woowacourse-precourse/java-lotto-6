package lotto.domain;

import static lotto.common.ErrorMessages.DUPLICATE_NUMBERS_MESSAGE;
import static lotto.common.ErrorMessages.INVALID_NUMBERS_COUNT_MESSAGE;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.InputValidationException;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumbers(List<LottoNumber> lottoNumbers) {
        if (!isLottoSize(lottoNumbers)) {
            throw new InputValidationException(INVALID_NUMBERS_COUNT_MESSAGE);
        }

        if (hasDuplicateNumbers(lottoNumbers)) {
            throw new InputValidationException(DUPLICATE_NUMBERS_MESSAGE);
        }
    }

    private boolean isLottoSize(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != 6;
    }

    private boolean hasDuplicateNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream().distinct().count() != lottoNumbers.size();
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int getCountingMatchingNumbers(Lotto lotto) {
        int count = 0;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (containsNumber(lotto.getNumbers().get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean containsNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
