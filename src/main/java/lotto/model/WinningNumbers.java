package lotto.model;

import java.util.Map;

public class WinningNumbers {
    private Map<Integer, Integer> sequencedNumbers;
    private int bonusNumber;

    public WinningNumbers(Map<Integer, Integer> sequencedNumbers, int bonusNumber) {
        this.sequencedNumbers = sequencedNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isMatched(int lottoNumber, int sequence) {
        if (sequencedNumbers.containsKey(lottoNumber)) {
            return sequencedNumbers.get(lottoNumber) == sequence;
        }
        return false;
    }

    public boolean isBonusNumber(int lottoNumber) {
        return bonusNumber == lottoNumber;
    }
}
