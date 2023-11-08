package lotto.domain.view;

import java.util.Collections;
import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoPrice;

public class OutputView {
    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printWinningStatistics(List<Integer> matchingCountList, List<Boolean> isMatchBonusNumber) {
        int totalProfit = 0;

        int match3Count = Collections.frequency(matchingCountList, 3);
        System.out.println(OutputType.MATCH_3_MESSAGE.getValue() + match3Count + "개");
        totalProfit += match3Count * LottoPrice.MATCH_3_PRICE.getValue();

        int match4Count = Collections.frequency(matchingCountList, 4);
        System.out.println(OutputType.MATCH_4_MESSAGE.getValue() + match4Count + "개");
        totalProfit += match4Count * LottoPrice.MATCH_4_PRICE.getValue();

        int match5WithBonusCount = 0;
        int match5WithoutBonusCount = 0;
        for (int i = 0; i < matchingCountList.size(); i++) {
            if (matchingCountList.get(i) == 5) {
                if (isMatchBonusNumber.get(i)) {
                    match5WithBonusCount++;
                } else {
                    match5WithoutBonusCount++;
                }
            }
        }
        System.out.println(OutputType.MATCH_5_MESSAGE.getValue() + match5WithoutBonusCount + "개");
        totalProfit += match5WithoutBonusCount * LottoPrice.MATCH_5_PRICE.getValue();
        System.out.println(OutputType.MATCH_5_AND_BONUS_BALL_MESSAGE.getValue() + match5WithBonusCount + "개");
        totalProfit += match5WithBonusCount * LottoPrice.MATCH_5_WITH_BONUS_PRICE.getValue();

        int match6Count = Collections.frequency(matchingCountList, 6);
        System.out.println(OutputType.MATCH_6_MESSAGE.getValue() + match6Count + "개");
        totalProfit += match6Count * LottoPrice.MATCH_6_PRICE.getValue();
        int money = matchingCountList.size() * LottoPrice.LOTTO_PRICE.getValue();
        float dividendRate = (totalProfit / money) * 100;

        System.out.println("총 수익률은 " + String.format("%.1f", dividendRate) + "%입니다.");
    }

}
