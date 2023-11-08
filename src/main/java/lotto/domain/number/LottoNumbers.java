package lotto.domain.number;

import lotto.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.validateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateNumbers(List<LottoNumber> lottoNumbers) {
        this.validateIsEmpty(lottoNumbers);
        this.validateSize(lottoNumbers);
        this.validateIsDuplicate(lottoNumbers);
    }

    private void validateIsEmpty(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_EMPTY.message());
        }
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_ENOUGH.message());
        }
    }

    private void validateIsDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> duplicateCheck = new HashSet<>();
        lottoNumbers.forEach(number -> {
            if (!duplicateCheck.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED.message());
            }
        });
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int getHitCount(List<Integer> numbers) {
        return (int) this.lottoNumbers.stream()
                .filter(number -> number.isHit(numbers))
                .count();
    }
}
