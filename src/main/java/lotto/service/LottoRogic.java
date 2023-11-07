package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class LottoRogic {
    public static void matchWinningLotto(Lottos lottos, WinningLotto winningLotto) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            boolean bonus = false;
            int count = getMatchCounts(lotto, winningLotto);
            if (count == 5) {
                bonus = getMatchBonus(lotto, winningLotto);
            }
            lottoResults.add(new LottoResult(count, bonus));
        }
    }

    public static int getMatchCounts(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = 0;
        List<Integer> winningLottoNumbers = winningLotto.getWinningLotto().getNumbers();
        for (Integer number : lotto.getNumbers()) {
            if (winningLottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static boolean getMatchBonus(Lotto lotto, WinningLotto winningLotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNumber());
    }
}
