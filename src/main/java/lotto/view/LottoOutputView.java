package lotto.view;

import lotto.Lotto;

import java.text.DecimalFormat;
import java.util.List;

public class LottoOutputView {
    private static final String MONEY_FORMAT = "###,###원";
    private static final int SIX_MATCH_PRIZE = 2000000000;
    private static final int FIVE_WITH_BONUS_MATCH_PRIZE = 30000000;
    private static final int FIVE_MATCH_PRIZE = 1500000;
    private static final int FOUR_MATCH_PRIZE = 50000;
    private static final int THREE_MATCH_PRIZE = 5000;

    public void printBuyingPriceInputRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printBoughtResult(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printLottoResult(
            int matchingThree,
            int matchingFour,
            int matchingFive,
            int matchingFiveWithBonus,
            int matchingSix
    ) {
        DecimalFormat format = new DecimalFormat(MONEY_FORMAT);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("%d개 일치 (%s) - %d개\n", 3, format.format(THREE_MATCH_PRIZE), matchingThree);
        System.out.printf("%d개 일치 (%s) - %d개\n", 4, format.format(FOUR_MATCH_PRIZE), matchingFour);
        System.out.printf("%d개 일치 (%s) - %d개\n", 5, format.format(FIVE_MATCH_PRIZE), matchingFive);
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개\n", 5, format.format(FIVE_WITH_BONUS_MATCH_PRIZE), matchingFiveWithBonus);
        System.out.printf("%d개 일치 (%s) - %d개\n", 6, format.format(SIX_MATCH_PRIZE), matchingSix);
    }

    public void printProfit(int before, int after) {
        double profit = (double) (after - before) / before * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }
}
