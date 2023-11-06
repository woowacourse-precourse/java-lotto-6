package lotto.view;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import static lotto.util.CharacterUnits.ENTER;
import static lotto.util.CharacterUnits.LINE;
import static lotto.util.PatternUnits.PATTERN_FOR_DECIMAL_FORMAT;

public class OutputView {

    private final DecimalFormat formatter;
    public OutputView() {
        formatter = new DecimalFormat(PATTERN_FOR_DECIMAL_FORMAT.getPattern());
    }

    public void printPurchasedLottos(Lottos lottos) {
        System.out.print(ENTER.getUnit());
        System.out.printf("%d개를 구매했습니다.", lottos.getCount());
        System.out.print(ENTER.getUnit());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printStaticResult(Prizes prizes, Cash cash) {
        System.out.println("당첨 통계");
        System.out.print(LINE.getUnit());
        for (Prize prize : Prize.values()) {
            if (prize == Prize.LAST_PLACE) continue;
            if (!prize.isBonusNumber()) {
                System.out.printf("%d개 일치 (%s원) - %d개",
                        prize.getCountOfMatchedNumber(),
                        formatter.format(prize.getReward()),
                        prizes.countPrize(prize));
            } else if (prize.isBonusNumber()){
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                        prize.getCountOfMatchedNumber(),
                        formatter.format(prize.getReward()),
                        prizes.countPrize(prize));
            }
            System.out.println();
        }


        String prefix = String.format("총 수익률은 %.1f", prizes.getRoundedTotalBenefit(
                cash.getDepositAmount()));

        System.out.println(prefix + "%입니다.");
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
        System.out.println();
    }


}
