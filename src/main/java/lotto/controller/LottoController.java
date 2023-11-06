package lotto.controller;

import lotto.LottoUtil;
import lotto.constant.LottoRanking;
import lotto.domain.Lotto;
import lotto.domain.dto.LottoAnswer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    public static Map<LottoRanking, Integer> calculateLottoResult(
            LottoAnswer answerLotto,
            List<Lotto> checkLottos
    ) {
        Map<LottoRanking, Integer> rankCount = new HashMap<>();
        for (LottoRanking rank : LottoRanking.values()) {
            rankCount.put(rank, 0);
        }

        for (Lotto checkLotto : checkLottos) {
            LottoRanking rank = calculateLottoRank(answerLotto, checkLotto);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        return rankCount;
    }

    public static LottoRanking calculateLottoRank(
            LottoAnswer answerLotto,
            Lotto checkLotto
    ) {
        int matchCount = LottoUtil.getMatchingNumberCount(answerLotto.getNumbers(), checkLotto.getNumbers());
        boolean hasBonus = checkLotto.getNumbers().contains(answerLotto.bonus());

        return LottoRanking.findRanking(matchCount, hasBonus);
    }

    public static int calculateTotalPrize(Map<LottoRanking, Integer> rankCount) {
        int sum = 0;
        for (LottoRanking rank : rankCount.keySet()) {
            sum += rank.getPrize() * rankCount.get(rank);
        }
        return sum;
    }
}
