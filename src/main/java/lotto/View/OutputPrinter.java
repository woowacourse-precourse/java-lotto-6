package lotto.View;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.Constant.Constant;
import lotto.Domain.Lotto;
import lotto.Domain.LottoReward;
import lotto.Domain.TotalLotto;

public class OutputPrinter {

    public void printTotalLotto(TotalLotto totalLotto) {
        System.out.println();
        System.out.println(totalLotto.getLottoAmount() + "개를 구매했습니다.");
        for (Lotto lotto : totalLotto.getTotalLotto()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printResult(Map<LottoReward, Integer> resultStatistic, String yield) {
        System.out.println("당첨 통계");
        System.out.println("---");
        List<LottoReward> lottoRewards = Arrays.asList(LottoReward.values());
        Collections.reverse(lottoRewards);
        for (LottoReward lottoReward : lottoRewards) {
            printStatistic(lottoReward, resultStatistic);
        }
        System.out.printf("총 수익률은 %s%%입니다.", yield);
    }

    public void printStatistic(LottoReward lottoReward, Map<LottoReward, Integer> resultStatistic) {
        if (lottoReward.equals(LottoReward.SECOND_PLACE)) {
            printBonusStatistic(lottoReward, resultStatistic);
            return;
        } else if (lottoReward.equals(LottoReward.DEFAULT)) {
            return;
        }

        System.out.printf("%d개 일치 (%s원) - %d개\n",
                lottoReward.getEqualCount(),
                Constant.DECIMAL_FORMAT.format(lottoReward.getReward()),
                resultStatistic.get(lottoReward));
    }

    public void printBonusStatistic(LottoReward lottoReward, Map<LottoReward, Integer> resultStatistic) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                lottoReward.getEqualCount(),
                Constant.DECIMAL_FORMAT.format(lottoReward.getReward()),
                resultStatistic.get(lottoReward));
    }
}
