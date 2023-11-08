package lotto.view;

import lotto.Lotto;
import lotto.constant.Constant;
import lotto.constant.Rank;
import lotto.domain.Purchase;
import lotto.domain.Statistics;

public final class Output {
    public static void illegalArgumentException(final IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }

    public static void lottoNumber(final Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void purchasedLotto(final Purchase purchase) {
        System.out.println("\n" + purchase.getAmount() + Constant.purchaseCount);

        for (final Lotto lotto : purchase.getPurchasedLotto()) {
            Output.lottoNumber(lotto);
        }
    }

    public static void rank(final Statistics statistics) {
        System.out.println(Constant.result);
        System.out.printf("%s%d개\n", Constant.fourth,
                statistics.getRanking().getRankStatus().get(Rank.FOURTH));
        System.out.printf("%s%d개\n", Constant.third,
                statistics.getRanking().getRankStatus().get(Rank.THIRD));
        System.out.printf("%s%d개\n", Constant.second,
                statistics.getRanking().getRankStatus().get(Rank.SECOND));
        System.out.printf("%s%d개\n", Constant.secondWithBonus,
                statistics.getRanking().getRankStatus().get(Rank.SECOND_WITH_BONUS));
        System.out.printf("%s%d개\n", Constant.first,
                statistics.getRanking().getRankStatus().get(Rank.FIRST));
    }

    public static void revenue(final Statistics statistics) {
        System.out.printf("총 수익률은 %.1f%%입니다.", statistics.getTotalRevenue());
    }
}
