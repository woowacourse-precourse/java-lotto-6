package lotto.view;

import lotto.domain.*;

import java.text.DecimalFormat;

public class OutputView {

    private final DecimalFormat formatter;
    public OutputView() {
        formatter = new DecimalFormat("###,###");
    }

    public void printPurchasedLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.", lottos.getCount());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printStaticResult(Prizes prizes, Cash cash) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize prize : Prize.values()) {
            if (!prize.getCheckBonus()) {
                System.out.printf("%d개 일치 (%s) - %d개",
                        prize.getCountOfSameNumbers(),
                        formatter.format(prize.getReward()),
                        prizes.countPrize(prize));
            } else {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개",
                        prize.getCountOfSameNumbers(),
                        formatter.format(prize.getReward()),
                        prizes.countPrize(prize));
            }
            System.out.println();
        }

        System.out.printf("총 수익률은 %d %입니다.",
                prizes.calculateBenefit(cash
                        .getSeed())
        );
    }


}
