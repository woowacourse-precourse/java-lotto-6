package lotto.domain;

import java.util.List;

public class CalculateLotto {
        private final Lotto lotto;
        private final int bonusNumber;
        public CalculateLotto(Lotto lotto, int bonusNumber) {
                this.lotto = lotto;
                this.bonusNumber = bonusNumber;
        }
        public WinLotto match(Lotto winningNumber){
                int countOfMatch = winningNumber.countMatch(lotto);
                boolean matchBonus = lotto.isContainNumber(bonusNumber);
                return WinLotto.findWin(countOfMatch,matchBonus);
        }
}
