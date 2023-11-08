package lotto.model.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoRank;
import lotto.model.dto.BonusNumber;
import lotto.model.dto.LottoResult;
import lotto.model.dto.LottoWallet;
import lotto.model.dto.WinningNumbers;

public class LottoChecker {

    public LottoResult findWinningLottos(LottoWallet lottoWallet, WinningNumbers winningNumber,
                                         BonusNumber bonusNumber) {
        List<LottoRank> resultRanks = new ArrayList<>();
        int totalReward = 0;

        for (Lotto lotto : lottoWallet.getLottos()) {
            LottoRank rank = checkLotto(lotto, winningNumber, bonusNumber);
            resultRanks.add(rank);
            totalReward += rank.getReward();
        }

        return new LottoResult(resultRanks, totalReward);
    }

    private LottoRank checkLotto(Lotto lotto, WinningNumbers winningNumber, BonusNumber bonusNumber) {
        int correct = 0;
        boolean hasBonus = false;

        for (Integer number : winningNumber.getNumbers()) {
            if (lotto.containsNumber(number)) {
                correct++;
            }
        }

        if (lotto.containsNumber(bonusNumber.getNumber())) {
            hasBonus = true;
        }

        return LottoRank.findRank(correct, hasBonus);
    }

}
