package lotto.view.impl;

import java.text.DecimalFormat;
import lotto.domain.Prize;
import lotto.domain.Statistic;
import lotto.view.Outputable;
import lotto.view.View;

public class StatisticView extends View implements Outputable {
    private final static String statisticOutputText = "당첨 통계\n---";
    private final static String EXCEPTION_MSG = "시스템 에러";

    @Override
    public void outputView(Object obj) {
        if (!(obj instanceof Statistic statistic)) {
            throw new IllegalArgumentException(ERROR_MSG + EXCEPTION_MSG);
        }

        printView(statisticOutputText);
        printStatistic(statistic);
    }

    private void printStatistic(Statistic statistic) {
        printView("3개 일치 (5,000원) - " + statistic.getPrizeCount(Prize.FIFTH) + "개");
        printView("4개 일치 (50,000원) - " + statistic.getPrizeCount(Prize.FOURTH) + "개");
        printView("5개 일치 (1,500,000원) - " + statistic.getPrizeCount(Prize.THIRD) + "개");
        printView("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistic.getPrizeCount(Prize.SECOND) + "개");
        printView("6개 일치 (2,000,000,000원) - " + statistic.getPrizeCount(Prize.FIRST) + "개");

        viewBenefit(statistic);
    }

    private static void viewBenefit(Statistic statistic) {
        double benefit = statistic.getBenefit();

        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        String formattedBenefit = decimalFormat.format(benefit);

        printView("총 수익률은 " + formattedBenefit + "%입니다.");
    }

}
