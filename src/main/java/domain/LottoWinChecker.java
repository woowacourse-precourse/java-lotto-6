package domain;

import lotto.Lotto;
import lotto.LottoRank;

import java.util.List;

public class LottoWinChecker {
    private final List<Integer> winningNumbers;
    private List<Integer> lottoNumbers;

    public LottoWinChecker(Lotto lotto, List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.lottoNumbers = lotto.getNumbers();

        int correctNumbers = getCorrectNumbersCount();

        if (correctNumbers == 6) lotto.setRank(LottoRank.FIRST);
        if (correctNumbers == 5 && hasBonusNumber()) lotto.setRank(LottoRank.SECOND);
        if (correctNumbers == 5 && !hasBonusNumber()) lotto.setRank(LottoRank.THIRD);
        if (correctNumbers == 4) lotto.setRank(LottoRank.FOURTH);
        if (correctNumbers == 3) lotto.setRank(LottoRank.FIFTH);
    }

    int getCorrectNumbersCount() {
        int correctNumbersCount = 0;

        for (int i = 0; i < 6; i++) {
            int winningNumber = this.winningNumbers.get(i);
            if (this.lottoNumbers.contains(winningNumber)) {
                correctNumbersCount++;
            }
        }

        return correctNumbersCount;
    }

    boolean hasBonusNumber() {
        int bonusNumber = this.winningNumbers.get(6);

        if (this.lottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
