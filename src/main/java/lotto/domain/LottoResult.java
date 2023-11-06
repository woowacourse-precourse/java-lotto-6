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
        winningType = WinningType.findByMatchCount(matchCount, isBonusMatch);
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
