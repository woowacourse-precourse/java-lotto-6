package lotto.domain;

import lotto.exception.BonusNumberException;

import java.util.List;

public class BonusNumber {
    private final String bonusNumber;

    public BonusNumber(String bonusNumber, List<Integer> winnerNum) {
        validate(bonusNumber, winnerNum);
        this.bonusNumber = bonusNumber;
    }

    private void validate(String bonusNumber, List<Integer> winnerNum) {
        BonusNumberException bonusNumberException = new BonusNumberException(bonusNumber, winnerNum);
    }

}
