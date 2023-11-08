package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicates(lottoNumbers);
        this.lottoNumbers = sortLottoNumbers(lottoNumbers);
    }

    private void validateSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw LottoException.of(ErrorMessage.INVALID_LOTTO_SIZE);
        }
    }

    private void validateDuplicates(final List<LottoNumber> lottoNumbers) {
        final Set<LottoNumber> setNumbers = new HashSet<>(lottoNumbers);
        if (setNumbers.size() != lottoNumbers.size()) {
            throw LottoException.of(ErrorMessage.INVALID_LOTTO_DUPLICATES);
        }
    }

    private List<LottoNumber> sortLottoNumbers(final List<LottoNumber> lottoNumbers) {
        final List<LottoNumber> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        sortedLottoNumbers.sort(Comparator.comparingLong(LottoNumber::getNumber));
        return sortedLottoNumbers;
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
