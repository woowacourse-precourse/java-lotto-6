package lotto.controller;

import lotto.LottoUtil;
import lotto.constant.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.dto.LottoAnswer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    public static Map<LottoRank, Integer> calculateLottoResult(
            LottoAnswer answerLotto,
            List<Lotto> checkLottos
    ) {
        Map<LottoRank, Integer> rankCount = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankCount.put(rank, 0);
        }

        for (Lotto checkLotto : checkLottos) {
            LottoRank rank = calculateLottoRank(answerLotto, checkLotto);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        return rankCount;
    }

    public static LottoRank calculateLottoRank(
            LottoAnswer answerLotto,
            Lotto checkLotto
    ) {
        int matchCount = LottoUtil.getMatchingNumberCount(answerLotto.getNumbers(), checkLotto.getNumbers());
        boolean hasBonus = checkLotto.getNumbers().contains(answerLotto.bonus());

        return LottoRank.getLottoMatchByCount(matchCount, hasBonus);
    }

    public static int calculateTotalPrize(Map<LottoRank, Integer> rankCount) {
        int sum = 0;
        for (LottoRank rank : rankCount.keySet()) {
            sum += rank.getPrize() * rankCount.get(rank);
        }
        return sum;
    }
}
