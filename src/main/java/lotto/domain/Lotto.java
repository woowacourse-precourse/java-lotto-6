package lotto.domain;

import lotto.domain.exception.LottoError;
import lotto.domain.exception.LottoException;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<Integer> lottoNumbers) {
        checkSize(lottoNumbers);
        checkRange(lottoNumbers);
        checkDuplicate(lottoNumbers);
    }

    // TODO: 추가 기능 구현
    /** 숫자의 갯수를 검사한다. */
    private void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new LottoException(LottoError.UNAVAILABLE_NUMBER_QUANTITY);
        }
    }

    /** 숫자들의 범위가 유효한지 검사한다. */
    private void checkRange(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number < 1 || number > 45) {
                throw new LottoException(LottoError.UNAVAILABLE_NUMBER_RANGE);
            }
        }
    }

    /** 숫자 중복이 없는지 검사한다. */
    private void checkDuplicate(List<Integer> lottoNumbers) {
        long countUnique = lottoNumbers.stream().distinct().count();
        if (countUnique < lottoNumbers.size()) {
            throw new LottoException(LottoError.DUPLICATED_NUMBER_EXIST);
        }
    }


}
