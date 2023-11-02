package lotto.domain;

import java.util.List;

public class WinningChecker {

    final Lottos lottos;
    final List<Integer> winningNumbers;
    final int bonusNumber;

    public WinningChecker(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> countMatchedNumbersEachLotto() {
        return lottos.matchNumbersEachLotto(winningNumbers, bonusNumber);
    }
}
