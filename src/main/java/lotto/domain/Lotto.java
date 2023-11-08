package lotto.domain;

import lotto.domain.exception.LottoError;
import lotto.domain.exception.LottoException;
import lotto.global.constant.ConstValue;

import java.util.Collections;
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
        if (lottoNumbers.size() != ConstValue.LOTTO_NUMBER_QUANTITY) {
            throw new LottoException(LottoError.UNAVAILABLE_NUMBER_QUANTITY);
        }
    }

    /** 숫자들의 범위가 유효한지 검사한다. */
    private void checkRange(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number < ConstValue.LOTTO_NUMBER_LOWER_LIMIT || number > ConstValue.LOTTO_NUMBER_UPPER_LIMIT) {
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

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    /**
     * 1등 당첨 여부를 확인할 때 사용한다.
     *
     * @param otherLotto 비교 대상 로또 객체
     * @return 비교 대상 로또의 번호와 모두 일치하는지
     */
    public boolean isSameWith(Lotto otherLotto) {
        for (Integer number : otherLotto.getLottoNumbers()) {
            if (!isExist(number)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 번호 포함 여부를 확인할 때 사용한다.
     *
     * @param number 번호
     * @return 번호가 본 로또의 번호속에 존재하는지
     * @see Lotto#isSameWith(Lotto)
     */
    public boolean isExist(Integer number) {
        return lottoNumbers.contains(number);
    }
}
