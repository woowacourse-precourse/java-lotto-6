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
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView(
            new MoneyInputValidator(),
            new WinningNumbersInputValidator(),
            new BonusNumberInputValidator()
    );
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void run() {
        int money = getMoneyFromUser();
        int lottoCount = calculateLottoCount(money);
        outputView.printLottoCount(lottoCount);
        List<Lotto> lottos = generateLotto(lottoCount);
        LottoResult lottoResult = new LottoResult(lottos);
        WinningLotto winningLotto = getWinningLottoFromUser();
        Map<Rank, Integer> result = lottoResult.checkResult(winningLotto);
        outputView.printWinningStatistics(result);
        double returnRate = lottoResult.calculateReturnRatePercentage(result, money);
        outputView.printTotalProfit(returnRate);
    }

    private WinningLotto getWinningLottoFromUser() {
        outputView.askForWinningNumbers();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        outputView.askForBonusNumber();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private int calculateLottoCount(int money) {
        return money / LottoNumber.PURCHASE_PRICE.getNumber();
    }

    private int getMoneyFromUser() {
        outputView.askForMoney();
        return inputView.inputMoney();
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
