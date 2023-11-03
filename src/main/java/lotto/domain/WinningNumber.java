package lotto.domain;

import lotto.domain.constants.LottoSetting;

import java.util.BitSet;
import java.util.List;

public class WinningNumber {
    private final BitSet winningNumbers;
    private int bonusNumber;

    public WinningNumber() {
        winningNumbers = new BitSet(LottoSetting.LOTTO_NUMBER_RANGE_END.getNumber());
        bonusNumber = 0;
    }

    public void setWinningNumbers(List<Integer> inputWinningNumbers) {
        for (int number : inputWinningNumbers) {
            winningNumbers.set(number);
        }
    }

    public void setBonusNumber(int inputBonusNumber) {
        this.bonusNumber = inputBonusNumber;
    }

    public boolean isWinningNumbersMatched(int lottoNumber) {
        return winningNumbers.get(lottoNumber);
    }

    public boolean hasBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().anyMatch(number -> number == bonusNumber);
    }
}
