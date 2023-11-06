package lotto.domain;

import lotto.global.constant.Winning;

public class LottoResult {

    private final Lotto lottoNumbers;
    private Winning winning;

    public LottoResult(Lotto lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void calculateResult(WinningLotto winningLotto) {
        int matchCount = 0;
        boolean isBonusMatch = false;
        for (Integer number : lottoNumbers.getNumbers()) {
            if (isContainsNumber(winningLotto, number)) {
                matchCount++;
            }
        }
        if (lottoNumbers.getNumbers().contains(winningLotto.getBonusNumber())) {
            isBonusMatch = true;
        }
        calculateWinningByMatchCountAndBonus(matchCount, isBonusMatch);
    }

    private void calculateWinningByMatchCountAndBonus(int matchCount, boolean isBonusMatch) {
        if (matchCount == 6) {
            winning = Winning.FIRST;
            return;
        }
        if (matchCount == 5) {
            checkBonusMatch(isBonusMatch);
            return;
        }
        if (matchCount == 4) {
            winning = Winning.FOURTH;
            return;
        }
        if (matchCount == 3) {
            winning = Winning.FIFTH;
            return;
        }
        winning = Winning.OTHER;
    }

    private void checkBonusMatch(boolean isBonusMatch) {
        if (isBonusMatch) {
            winning = Winning.SECOND;
            return;
        }
        winning = Winning.THIRD;
    }

    private boolean isContainsNumber(WinningLotto winningLotto, Integer number) {
        return winningLotto.getLotto().getNumbers().contains(number);
    }

    public Winning getWinning() {
        return winning;
    }

    @Override
    public String toString() {
        return lottoNumbers.getNumbers().toString();
    }
}
