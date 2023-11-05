package lotto.domain.lotto;

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
        // TreeSet : 로또 번호 오름차순 자동 정렬
        Set<LottoNumber> uniqueNumbers = numbers.stream()
                .map(LottoNumber::new).collect(Collectors.toCollection(TreeSet::new));
        validate(new ArrayList<>(uniqueNumbers));
        this.lottoNumbers = new ArrayList<>(uniqueNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) throws LottoException {
        if (lottoNumbers.size() != LottoConstants.LOTTO_SIZE.getValue()) {
            throw new LottoException(LottoException.ErrorMessage.INVALID_NUMBERS.getMessage());
        }
    }

    public void checkAndThrowIfBonusNumberExists(BonusNumber number) throws LottoException {
        if (lottoNumbers.contains(number.value())) {
            throw new LottoException(LottoException.ErrorMessage.ALREADY_CONTAINS_BONUS_NUMBER.getMessage());
        }
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
}
