package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import lotto.domain.wrapper.LottoNumber;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstant;
import lotto.utils.LottoConstantValue;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validate(List<Integer> lottoNumbers) {
        validateLength(lottoNumbers);
        validateDuplication(lottoNumbers);
    }

    private void validateLength(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoConstantValue.LOTTO_NUMBERS_LENGTH.get()) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_LOTTO_NUMBERS_LENGTH.getWithFormatAndPrefix(
                            LottoConstantValue.LOTTO_NUMBERS_LENGTH.get()
                    )
            );
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATION.getWithPrefix());
        }
    }

    public boolean doesHaveLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int getSameCount(Lotto otherLotto) {
        return lottoNumbers.stream()
                .filter(otherLotto.lottoNumbers::contains)
                .toList()
                .size();
    }

    @Override
    public String toString() {
        List<LottoNumber> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLottoNumbers);
        return sortedLottoNumbers.toString();
    }
}
