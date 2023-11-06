package lotto.domain;

import lotto.global.constant.WinningType;

public class LottoResult {

    private final Lotto lottoNumbers;
    private WinningType winningType;

    public LottoResult(Lotto lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void calculateResult(WinningLotto winningLotto) {
        int matchCount = calculateMatchCount(winningLotto);
        boolean isBonusMatch = resolveBonusMatch(winningLotto);
        winningType = WinningType.findByMatchCount(matchCount, isBonusMatch);
    }

    private int calculateMatchCount(WinningLotto winningLotto) {
        int matchCount = 0;
        for (Integer number : lottoNumbers.getNumbers()) {
            if (isContainsNumber(winningLotto, number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean resolveBonusMatch(WinningLotto winningLotto) {
        return lottoNumbers.getNumbers().contains(winningLotto.getBonusNumber());
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
