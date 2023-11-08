package lotto.domain;

import java.util.List;
import lotto.constant.Message;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        validateDuplicated(lottoNumbers);
        validateOutOfRange(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(Message.ERROR_LOTTO_NUMBERS_NOT_SIX.toString());
        }
    }

    private void validateDuplicated(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream()
                .distinct()
                .count() != 6) {
            throw new IllegalArgumentException(Message.ERROR_LOTTO_NUMBERS_DUPLICATED.toString());
        }
    }

    private void validateOutOfRange(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber < 1 || lottoNumber > 45)) {
            throw new IllegalArgumentException(Message.ERROR_LOTTO_NUMBERS_OUT_OF_RANGE.toString());
        }
    }
    
    public int match(List<Integer> lottoNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public final int match(WinningLotto winningNumber) {
        return winningNumber.match(this.lottoNumbers);
    }

    public final boolean hasBonusNumber(WinningLotto winningNumber) {
        return winningNumber.containBonusNumber(this.lottoNumbers);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
