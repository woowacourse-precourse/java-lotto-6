package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Yield;
import lotto.ui.Input;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Money;
import lotto.domain.PrizeChecker;
import lotto.domain.WinningNumber;
import lotto.ui.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Money money = null;
        money = input.askToPayAgainWhenError(input, money);
        long howManyLotto = money.getHowManyLotto();

        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottos = generator.generateLotto(howManyLotto);
        Output output = new Output();
        output.printLotto(howManyLotto, lottos);

        WinningNumber winningNumber = null;
        winningNumber = input.askWinningNumberAgainWhenError(input, winningNumber);
        BonusNumber bonusNumber = null;
        bonusNumber = input.askBonusAgainWhenError(input, winningNumber, bonusNumber);

        PrizeChecker checker = new PrizeChecker();
        Map<Integer, Integer> winningByRank = checker.recordWinningByRank(
                lottos, winningNumber.getWinningNumber(), bonusNumber.getBonusNumber());
        output.printWinning(winningByRank);

        Yield yield = new Yield();
        long totalPrizeMoney = yield.sumPrizeMoney(winningByRank);
        double rateOfReturn = yield.calculate(totalPrizeMoney, money.getMoney());
        output.printYield(rateOfReturn);
    }
}
