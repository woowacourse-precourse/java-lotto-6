package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        outputView.askForMoney();
        int money = inputView.inputMoney();
        int lottoCount = money / 1000;
        outputView.printLottoCount(lottoCount);
        List<Lotto> lottoArrayList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto generatedLotto = lottoGenerator.generate();
            lottoArrayList.add(generatedLotto);
            outputView.printLottoNumbers(generatedLotto.getNumbers());
        }
        LottoResult lottoResult = new LottoResult(lottoArrayList);
        outputView.askForWinningNumbers();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        outputView.askForBonusNumber();
        int bonusNumber = inputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        outputView.printWinningStatistics(lottoResult.checkResult(winningLotto));
        outputView.printTotalProfit(lottoResult.calculateReturnRate(lottoResult.checkResult(winningLotto), money));
    }
}
