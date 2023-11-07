package lotto.generator;

import lotto.domain.BonusNumber;
import lotto.domain.LottoBundle;
import lotto.domain.Money;
import lotto.domain.Statistics;
import lotto.domain.WinningNumbers;

public class StatisticsGenerator {

    public static Statistics generateStatistics(Money money, LottoBundle lottoBundle, WinningNumbers winningNumbers,
                                                BonusNumber bonusNumber) {

        return new Statistics(money, lottoBundle, winningNumbers, bonusNumber);
    }
}
