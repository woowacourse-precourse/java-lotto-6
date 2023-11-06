package lotto.domain;

import lotto.global.constant.WinningType;

public class LottoResult {

    private final Lotto lottoNumbers;
    private WinningType winningType;

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
            winningType = WinningType.FIRST;
            return;
        }
        if (matchCount == 5) {
            checkBonusMatch(isBonusMatch);
            return;
        }
        if (matchCount == 4) {
            winningType = WinningType.FOURTH;
            return;
        }
        if (matchCount == 3) {
            winningType = WinningType.FIFTH;
            return;
        }
        winningType = WinningType.OTHER;
    }

    private void checkBonusMatch(boolean isBonusMatch) {
        if (isBonusMatch) {
            winningType = WinningType.SECOND;
            return;
        }
        winningType = WinningType.THIRD;
    }

    private boolean isContainsNumber(WinningLotto winningLotto, Integer number) {
        return winningLotto.getLotto().getNumbers().contains(number);
    }

    public WinningType getWinning() {
        return winningType;
    }

    @Override
    public String toString() {
        return lottoNumbers.getNumbers().toString();
    }
}
