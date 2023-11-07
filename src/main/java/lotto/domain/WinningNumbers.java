package lotto.domain;

import lotto.domain.constants.LottoSetting;

import java.util.BitSet;
import java.util.List;

public class WinningNumbers {
    private final BitSet winningNumbers;

    public WinningNumbers() {
        winningNumbers = new BitSet(LottoSetting.LOTTO_NUMBER_RANGE_END.getNumber() + 1);
    }

    public void setWinningNumbers(List<Integer> inputWinningNumbers) {
        for (int number : inputWinningNumbers) {
            winningNumbers.set(number);
        }
    }

    public boolean hasNumber(int number) {
        return winningNumbers.get(number);
    }
}
