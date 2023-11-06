package lotto.controller;

import lotto.LottoUtil;
import lotto.constant.LottoRank;
import lotto.domain.dto.LottoAnswer;
import lotto.domain.dto.LottoNumbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    public static Map<LottoRank, Integer> calculateLottoResult(
            LottoAnswer answerLotto,
            List<LottoNumbers> checkLottos
    ) {
        Map<LottoRank, Integer> rankCount = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            rankCount.put(rank, 0);
        }

        for (LottoNumbers checkLotto : checkLottos) {
            LottoRank rank = calculateLottoRank(answerLotto, checkLotto);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        return rankCount;
    }

    public static LottoRank calculateLottoRank(
            LottoAnswer answerLotto,
            LottoNumbers checkLotto
    ) {
        int matchCount = LottoUtil.getMatchingNumberCount(answerLotto.numbers(), checkLotto.numbers());
        boolean hasBonus = checkLotto.numbers().contains(answerLotto.bonus());

        return LottoRank.getLottoMatchByCount(matchCount, hasBonus);
    }
}
