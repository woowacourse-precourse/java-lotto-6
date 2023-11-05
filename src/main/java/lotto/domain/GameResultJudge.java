package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.vo.Lotto;
import lotto.vo.WinLotto;

public class GameResultJudge {

    /**
     * 전체 로또들 당첨 결과 보기
     */
    public static Map<Rank, Integer> judge(WinLotto winLotto, List<Lotto> lottos) {
        Map<Rank, Integer> rankCountMap = getRankCountMap();

        for (Lotto lotto : lottos) {
            // 몇등인지 계산한다.
            Rank rank = calculateRank(winLotto, lotto);
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }

        return rankCountMap;
    }

    private static Map<Rank, Integer> getRankCountMap() {
        Map<Rank, Integer> rankCountMap = new LinkedHashMap<>();

        rankCountMap.put(Rank.RANK_5, 0);
        rankCountMap.put(Rank.RANK_4, 0);
        rankCountMap.put(Rank.RANK_3, 0);
        rankCountMap.put(Rank.RANK_2, 0);
        rankCountMap.put(Rank.RANK_1, 0);

        return rankCountMap;
    }

    private static Rank calculateRank(WinLotto winLotto, Lotto lotto) {
        int matchCount = countMatch(lotto, winLotto);
        boolean isMatchBonus = isMatchBonus(lotto, winLotto.getBonusNum());

        if (matchCount == 6) {
            return Rank.RANK_1;
        }

        if (matchCount == 5 && isMatchBonus) {
            return Rank.RANK_2;
        }

        if (matchCount == 5) {
            return Rank.RANK_3;
        }

        if (matchCount == 4) {
            return Rank.RANK_4;
        }

        if (matchCount == 3) {
            return Rank.RANK_5;
        }

        return Rank.UNRANK;
    }

    private static boolean isMatchBonus(Lotto lotto, int bonus) {
        List<Integer> list = lotto.getNumbers();
        return list.contains(bonus);
    }

    private static int countMatch(Lotto lotto, WinLotto winLotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(number -> winLotto.getNumbers().contains(number))
                .count();
    }
}
