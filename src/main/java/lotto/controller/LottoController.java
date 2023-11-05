package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
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
        for (int i = 0; i < lottoCount; i++) {
            Lotto generatedLotto = lottoGenerator.generate();
            outputView.printLottoNumbers(generatedLotto.getNumbers());
        }
        outputView.askForWinningNumbers();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        outputView.askForBonusNumber();
        int bonusNumber = inputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        outputView.printWinningStatistics();

    }
}
