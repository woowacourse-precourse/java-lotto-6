package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class CompareLotto {
    public static Rank compareWinningWithLotto(Lotto lotto, WinningLotto winningLotto) {
        int count = (int) lotto.getNumbers().stream().filter(winningLotto.getNumbers()::contains)
                .count(); //로또와 당첨 번호 비교해서 몇개 맞았는지
        if (count == 5 && lotto.getNumbers().contains(winningLotto.getBonusNumber())) { //만약 5개라면 보너스와 맞는지
            return Rank.SECOND;
        }
        return Rank.fromMatchingCount(count);
    }
}
