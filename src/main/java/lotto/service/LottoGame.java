package lotto.service;

import java.util.EnumMap;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.UserLotto;

public class LottoGame {
    private static final int PRICE_PER_LOTTO = 1000;
    public void run(UserLotto userLotto, Lotto winLotto, int bonusNum){
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }

        int totalPrize = 0;

        for (Lotto lotto : userLotto.getLottos()) {
            int matchCount = lotto.getMatchCount(winLotto);
            boolean bonusMatch = lotto.contains(bonusNum);
            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

            result.put(rank, result.get(rank) + 1);
            totalPrize += rank.getPrizeMoney();
        }

        // Print the result
        System.out.println("당첨 통계");
        System.out.println("---");
        result.forEach((rank, count) -> {

                System.out.printf("%d개 일치 (%s원) - %d개%n",
                        rank.getMatchCount(),
                        rank.isBonusMatch() ? rank.getPrizeMoney() + ", 보너스 볼 일치" : rank.getPrizeMoney(),
                        count);

        });

        // Calculate and print total revenue rate
        int purchaseAmount = userLotto.getLottos().size() * PRICE_PER_LOTTO;
        double revenueRate = (totalPrize / (double) purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다%n", revenueRate);
    }
}
