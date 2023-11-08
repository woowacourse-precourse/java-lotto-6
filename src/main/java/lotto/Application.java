package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.Purchase;
import lotto.domain.RewardCalculator;
import lotto.domain.WinningLotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Purchase p = new Purchase();
        int trials = p.purchasing();

        LottoGenerator lottos = new LottoGenerator(trials);
        WinningLotto.setWinningLotto();

        RewardCalculator calc = new RewardCalculator(lottos.getLottoTrials());
        calc.getResults();
        calc.printResults();
    }
}
