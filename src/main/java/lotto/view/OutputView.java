package lotto.view;

import lotto.domain.*;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;

public enum OutputView {
    INSTANCE;

    public static void printLottoCount(final LottoMoney lottoMoney) {
        System.out.println(lottoMoney.getLottoCount() + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> System.out.println("[" + toLottoOutput(lotto) + "]"));
    }

    public static void printLottoResult(LottoResult lottoResult, LottoMoney lottoMoney) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printLottoRankResults(lottoResult);
        printProfitRate(lottoResult, lottoMoney);
    }

    private static String toLottoOutput(Lotto lotto) {
        return lotto.toString();
    }

    private static void printProfitRate(LottoResult lottoResult, LottoMoney lottoMoney) {
        double profitRate = lottoResult.getProfitRate(lottoMoney);
        String result = String.format(
                "총 수익률은 %.1f%%입니다.",
                Math.round(profitRate * 1000) / 10.0
        );
        System.out.println(result);
    }

    private static void printLottoRankResults(LottoResult lottoResult) {
        Arrays.stream(Rank.values())
                .sorted(Collections.reverseOrder())
                .filter(rank -> rank != Rank.MISS)
                        .forEach(rank -> printRankResult(rank, lottoResult.countRank(rank)));
    }

    private static void printRankResult(Rank rank, Integer lottoCount) {
        String bonusBallMatch = "";
        if (rank.getMatchBonus()) {
            bonusBallMatch = ", 보너스 볼 일치";
        }

        String rankResult = String.format(
                "%d개 일치%s (%s원) - %d개",
                rank.getMatchCount(),
                bonusBallMatch,
                winnginMoneyToString(rank),
                lottoCount
        );
        System.out.println(rankResult);
    }

    private static String winnginMoneyToString(Rank rank) {
        return NumberFormat.getInstance().format(rank.getWinningMoney());
    }
}
