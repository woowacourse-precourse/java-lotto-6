package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final LottoIssueController lottoIssueController = new LottoIssueController();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private int getMoneyInput() {
        outputView.printInputMoneyMessage();
        return inputView.getMoney();
    }

    private Lottos purchaseLottos(int inputMoney) {
        return lottoIssueController.createLottos(inputMoney);
    }

    private void getPurchaseDetails(int inputMoney, Lottos lottos) {
        outputView.printPurchaseDetailsMessage(lottoIssueController.getLottoCount(inputMoney));
        outputView.printPurchasedLottos(lottos.getPurchaseDetails());
    }

    public void play() {
        int inputMoney = getMoneyInput();
        Lottos lottos = purchaseLottos(inputMoney);
        getPurchaseDetails(inputMoney, lottos);
    }
}
