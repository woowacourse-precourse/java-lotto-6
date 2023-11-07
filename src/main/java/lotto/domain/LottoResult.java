package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import lotto.global.constant.WinningType;

public class LottoResult {

    private final Lotto lottoNumbers;
    private WinningType winningType;

    public LottoResult(Lotto lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void calculateResult(WinningLotto winningLotto) {
        int matchCount = calculateMatchCount(winningLotto);
        winningType = WinningType.findByCondition(matchCount, isBonusMatch(matchCount, winningLotto));
    }

    private int calculateMatchCount(WinningLotto winningLotto) {
        Set<Integer> winningNumbers = new HashSet<>(winningLotto.getLotto().getNumbers());
        return (int) lottoNumbers.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusMatch(int matchCount, WinningLotto winningLotto) {
        return matchCount == WinningType.SECOND.getMatchCount()
                && lottoNumbers.getNumbers().contains(winningLotto.getBonusNumber());
    }

    public WinningType getWinningType() {
        return winningType;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
