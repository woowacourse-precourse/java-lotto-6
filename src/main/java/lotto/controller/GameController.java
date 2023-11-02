package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final LottoIssueController lottoIssueController = new LottoIssueController();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void purchaseLottosAndPrintDetails() {
        int inputMoney = lottoIssueController.getMoneyInput();
        int lottoCount = lottoIssueController.getLottoCount(inputMoney);
        Lottos lottos = lottoIssueController.createLottos(lottoCount);
        lottoIssueController.getPurchaseDetails(lottos, lottoCount);
    }
}
