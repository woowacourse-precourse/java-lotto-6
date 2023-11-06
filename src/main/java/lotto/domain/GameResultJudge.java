package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.vo.Lotto;
import lotto.vo.WinLotto;

public class GameResultJudge {

    public static Map<Rank, Integer> judge(WinLotto winLotto, List<Lotto> lottoes) {
        Map<Rank, Integer> rankingCountResult = initRankingCountResult();

        for (Lotto lotto : lottoes) {
            Rank rank = calculateRank(winLotto, lotto);
            rankingCountResult.put(rank, rankingCountResult.getOrDefault(rank, 0) + 1);
        }

        return rankingCountResult;
    }

    private static Map<Rank, Integer> initRankingCountResult() {
        Map<Rank, Integer> rankingCountResult = new LinkedHashMap<>();

        rankingCountResult.put(Rank.RANK_5, 0);
        rankingCountResult.put(Rank.RANK_4, 0);
        rankingCountResult.put(Rank.RANK_3, 0);
        rankingCountResult.put(Rank.RANK_2, 0);
        rankingCountResult.put(Rank.RANK_1, 0);

        return rankingCountResult;
    }

    private static Rank calculateRank(WinLotto winLotto, Lotto lotto) {
        int matchCount = countMatch(lotto, winLotto);
        boolean isMatchBonus = isMatchBonus(lotto, winLotto.getBonusNum());

        return Rank.getRank(matchCount, isMatchBonus);
    }

    private static boolean isMatchBonus(Lotto lotto, int bonus) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(bonus);
    }

    private static int countMatch(Lotto lotto, WinLotto winLotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(number -> winLotto.getNumbers().contains(number))
                .count();
    }
}
