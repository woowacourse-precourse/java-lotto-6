package lotto;

import static lotto.LottoWinMetric.getLottoWinMetric;
import static lotto.message.LottoGameAnnouncement.getProfitPercentageMessage;

import java.util.List;
import java.util.Optional;
import lotto.message.BonusNumber;
import org.assertj.core.util.VisibleForTesting;

public class ResultCalculator {

    @VisibleForTesting
    protected static void calculateWin(List<Lotto> lottoNumbers, Lotto winNumber, BonusNumber bonusNumber) {
        for (Lotto lotto : lottoNumbers) {
            int count = lotto.countDuplicate(winNumber);
            boolean isBonusWin = lotto.calculateBonus(count, bonusNumber);
            getLottoWinMetric(count, isBonusWin).increase();
        }
    }

    public static void printWin(List<Lotto> lottoNumbers, Lotto winNumber, BonusNumber bonusNumber) {
        calculateWin(lottoNumbers, winNumber, bonusNumber);
        for (LottoWinMetric value : LottoWinMetric.values()) {
            if (value == LottoWinMetric.NO_WIN) {
                continue;
            }
            System.out.println(value.getMessage());
        }
    }

    public static void printProfitPercentage(LottoMoney money) {
        Optional<Integer> totalWinMoneyOptional = LottoWinMetric.getTotalWinMoney();
        if (totalWinMoneyOptional.isEmpty()) {
            return;
        }
        int totalWinMoney = totalWinMoneyOptional.get();
        double profit = money.calculateProfitPercentage(totalWinMoney);
        System.out.println(getProfitPercentageMessage(profit));
    }
}
