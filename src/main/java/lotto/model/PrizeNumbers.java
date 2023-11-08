package lotto.model;

import lotto.constant.ExceptionMessage;

import java.util.List;

public class PrizeNumbers {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public PrizeNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = new Lotto(winningNumbers);
    }

    public void setBonusNumber(Integer bonusNumber) {
        validateDuplication(bonusNumber);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public void validateDuplication(Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_BONUST_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public Integer matchedWinningNumberCount(Lotto lotto) {
        Integer count = 0;
        for (LottoNumber lottoNumber : lotto.getNumbers()) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    public Boolean matchedBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}