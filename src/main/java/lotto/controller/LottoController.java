package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoNumber;
import lotto.model.LottoResult;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.validator.BonusNumberInputValidator;
import lotto.validator.MoneyInputValidator;
import lotto.validator.WinningNumbersInputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView(
            new MoneyInputValidator(),
            new WinningNumbersInputValidator(),
            new BonusNumberInputValidator()
    );
    LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        outputView.askForMoney();
        int money = inputView.inputMoney();

        int lottoCount = money / LottoNumber.PURCHASE_PRICE.getNumber();
        outputView.printLottoCount(lottoCount);

        LottoResult lottoResult = new LottoResult(generateLotto(lottoCount));
        outputView.askForWinningNumbers();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();

        outputView.askForBonusNumber();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        Map<Rank, Integer> result = lottoResult.checkResult(winningLotto);
        outputView.printWinningStatistics(result);
        double returnRate = lottoResult.calculateReturnRatePercentage(result, money);
        outputView.printTotalProfit(returnRate);
    }

    private List<Lotto> generateLotto(int lottoCount) {
        List<Lotto> lottoArrayList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto generatedLotto = lottoGenerator.generate();
            lottoArrayList.add(generatedLotto);
            outputView.printLottoNumbers(generatedLotto.getNumbers());
        }
        return lottoArrayList;
    }

}
