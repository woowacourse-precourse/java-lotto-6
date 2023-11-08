package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.LottoGame;
import lotto.domain.WinNumber;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        int money = InputController.inputBuyingMoney();
        LottoGame lottoGame = new LottoGame(money);
        OutputView.printLottos(money, lottoGame.getLottos());

        inputWinNumbers(lottoGame);

        printResults(money, lottoGame);
    }

    private void inputWinNumbers(LottoGame lottoGame) {
        WinNumber winNums = new WinNumber(InputController.inputWinNums());
        BonusNumber bonusNum = new BonusNumber(winNums, InputController.inputBonusNum(winNums));
        lottoGame.addValueLottoMap(winNums, bonusNum);
    }

    private void printResults(int money, LottoGame lottoGame) {
        OutputView.printLottoResult(lottoGame.getLottoMap());
        OutputView.printPrizePercentage(lottoGame.calculatePrizePercentage(money));
    }
}
