package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
        if (winningLotto.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    public LottoRank determineRank(Lotto lotto) {
        int matchCount = lotto.countMatchingNumbers(winningLotto.getNumbers());
        boolean matchBonus = lotto.containsNumber(bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }
}
