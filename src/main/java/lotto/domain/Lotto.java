package lotto.domain;

import lotto.constant.LottoConstants;
import lotto.exception.LottoException;
import lotto.vo.BonusNumber;
import lotto.vo.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) throws LottoException {
        // TreeSet : 로또 번호 오름차순 정렬 (Comparable<LottoNumber> 구현)
        Set<LottoNumber> uniqueNumbers = numbers.stream()
                .map(LottoNumber::new).collect(Collectors.toCollection(TreeSet::new));
        validate(new ArrayList<>(uniqueNumbers));
        this.lottoNumbers = new ArrayList<>(uniqueNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) throws LottoException {
        if (lottoNumbers.size() != LottoConstants.LOTTO_SIZE.getValue()) {
            throw new LottoException(LottoException.ErrorMessage.RANGE_BONUS_NUMBER.getMessage());
        }
    }

    public void validateAndThrowIfBonusNumberExists(BonusNumber bonusNumber) throws LottoException {
        if (containsBonusNumber(bonusNumber)) {
            throw new LottoException(LottoException.ErrorMessage.ALREADY_CONTAINS_BONUS_NUMBER.getMessage());
        }
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

    public boolean containsBonusNumber(BonusNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber.value());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
