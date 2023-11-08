package lotto.controller;

import java.util.List;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.PrizeCalculator;
import lotto.domain.WinningCalculator;
import lotto.domain.WinningResult;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        Amount amount = receiveMoney();
        List<Lotto> lottos = buyLottos(amount);
        List<Integer> winningNumbers = getWinningNumbers();
        Integer bonusNumber = getBonusNumber();
        WinningResult winningResult = getWinningResult(lottos, winningNumbers, bonusNumber);
        Output.printTotalReturn(PrizeCalculator.getRateOfReturn(winningResult, amount));
    }

    private WinningResult getWinningResult(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        WinningCalculator winningCalculator = new WinningCalculator(winningNumbers, bonusNumber);
        WinningResult winningResult = winningCalculator.calculate(lottos);
        Output.printWinningStatistics(winningResult);
        return winningResult;
    }

    private Integer getBonusNumber() {
        Output.askBonusNumber();
        Integer bonusNumber = Input.receiveOneNumber();
        return bonusNumber;
    }

    private List<Integer> getWinningNumbers() {
        Output.askWinningNumber();
        List<Integer> winningNumbers = Input.receiveNumbersSeparatedByCommas();
        return winningNumbers;
    }

    private Amount receiveMoney() {
        Output.askAmount();
        Integer money = Input.receiveOneNumber();
        return new Amount(money);
    }

    private List<Lotto> buyLottos(Amount amount) {
        List<Lotto> lottos = lottoGenerator.generateLottoes(amount);
        Output.printPublishedLottoInformation(lottos);
        return lottos;
    }

}
