package lotto.domain;

import lotto.LottoUtil;
import lotto.constant.LottoRanking;
import lotto.domain.dto.LottoAnswer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoJudgement {
    private final LottoAnswer answer;

    public LottoJudgement(LottoAnswer answer) {
        this.answer = answer;
    }

    public Map<LottoRanking, Integer> calculateLottoRanking(List<Lotto> checkLottos) {
        Map<LottoRanking, Integer> rankCount = new HashMap<>();
        for (LottoRanking rank : LottoRanking.values()) {
            rankCount.put(rank, 0);
        }

        for (Lotto checkLotto : checkLottos) {
            LottoRanking rank = calculateLottoRanking(checkLotto);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        return rankCount;
    }

    public LottoRanking calculateLottoRanking(Lotto checkLotto) {
        int matchCount = LottoUtil.getMatchingNumberCount(answer.getNumbers(), checkLotto.getNumbers());
        boolean hasBonus = checkLotto.getNumbers().contains(answer.bonus());
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
