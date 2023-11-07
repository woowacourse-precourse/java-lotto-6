package lotto.model.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoRank;
import lotto.model.dto.LottoResult;
import lotto.model.dto.WinningNumber;

public class LottoChecker {

    public LottoResult findWinningLottos(List<Lotto> lottos, WinningNumber winningNumber) {
        List<LottoRank> resultRanks = new ArrayList<>();
        int totalReward = 0;

        for (Lotto lotto : lottos) {
            LottoRank rank = checkLotto(lotto, winningNumber);
            resultRanks.add(rank);
            totalReward += rank.getReward();
        }

        return new LottoResult(resultRanks, totalReward);
    }

    private LottoRank checkLotto(Lotto lotto, WinningNumber winningNumber) {
        int correct = 0;
        boolean hasBonus = false;

        for (Integer number : winningNumber.getNumbers()) {
            if (lotto.containsNumber(number)) {
                correct++;
            }
        }

        if (lotto.containsNumber(winningNumber.getBonusNumber())) {
            hasBonus = true;
        }

        return LottoRank.findRank(correct, hasBonus);
    }

}
