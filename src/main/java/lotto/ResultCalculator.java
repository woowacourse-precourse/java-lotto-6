package lotto;

import static lotto.LottoWinMetric.getLottoWinMetric;

import java.util.List;
import lotto.message.BonusNumber;

public class ResultCalculator {

    public static void calculateWin(List<Lotto> lottoNumbers, Lotto winNumber, BonusNumber bonusNumber) {
        for (Lotto lotto : lottoNumbers) {
            int count = lotto.countDuplicate(winNumber);
            boolean isBonusWin = lotto.calculateBonus(count, bonusNumber);
            getLottoWinMetric(count, isBonusWin).increase();
        }
    }

    public static void printWin() {
        for (LottoWinMetric value : LottoWinMetric.values()) {
            if (value == LottoWinMetric.NO_WIN) {
                continue;
            }
            System.out.println(value.getMessage());
        }
    }
}
