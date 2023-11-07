package lotto.Controller;

import java.util.Map;
import lotto.Domain.Lotto;
import lotto.Domain.LottoNumber;
import lotto.Domain.LottoResult;
import lotto.Domain.LottoReward;
import lotto.Domain.Money;
import lotto.Domain.TotalLotto;
import lotto.View.InputReader;
import lotto.View.OutputPrinter;

public class LottoController {
    public void startLotto() {
        InputReader inputReader = new InputReader();
        OutputPrinter outputPrinter = new OutputPrinter();
        Money money = inputReader.inputMoney();

        TotalLotto totalLotto = new TotalLotto(money);
        outputPrinter.printTotalLotto(totalLotto);

        Lotto winLotto = inputReader.inputLottoNumbers();
        LottoNumber bonusNumber = inputReader.inputBonusNumber(winLotto);

        LottoResult lottoResult = new LottoResult(winLotto);
        Map<LottoReward, Integer> resultStatistic = lottoResult.createStatistic(totalLotto, bonusNumber);
        String yield = lottoResult.calculateSumOfReward(money);

        outputPrinter.printResult(resultStatistic, yield);
    }
}
