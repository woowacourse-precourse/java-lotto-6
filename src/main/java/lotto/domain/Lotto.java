package lotto.domain;

import java.util.List;
import lotto.constant.Constant;
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
        if (lottoNumbers.size() != Constant.SIZE_OF_LOTTO_NUMBERS.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_LOTTO_NUMBERS_NOT_SIX.getMessage());
        }
    }

    private void validateDuplicated(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream()
                .distinct()
                .count() != Constant.SIZE_OF_LOTTO_NUMBERS.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_LOTTO_NUMBERS_DUPLICATED.getMessage());
        }
    }

    private void validateOutOfRange(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber < Constant.MINIMUM_LOTTO_NUMBER.getValue()
                    || lottoNumber > Constant.MAXIMUM_LOTTO_NUMBER.getValue()) {
                throw new IllegalArgumentException(Message.ERROR_LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
            }
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
        return winningNumber.containsBonusNumber(this.lottoNumbers);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
