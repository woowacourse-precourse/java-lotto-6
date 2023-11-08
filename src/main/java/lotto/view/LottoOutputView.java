package lotto.view;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.Member;

public class LottoOutputView {

    public static void showPurchasedLotto(Member member) {
        System.out.println(member.calculateQuantity() + "개를 구매했습니다.");
        member.lottos()
                .forEach(System.out::println);
    }

    public static void showGameResult(Member member, List<LottoRank> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoRank rank : LottoRank.findValidRanks()) {
            long count = rank.calculateCount(results);
            System.out.printf("%s%d개%n", rank.getMessage(), count);
        }

        double earningRate = calculateRate(LottoRank.calculate(results), member.inputMoney());
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earningRate);
    }

    private static double calculateRate(long profit, long inputMoney) {
        return (double) (profit * 100) / inputMoney;
    }

}
