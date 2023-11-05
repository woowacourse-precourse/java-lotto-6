package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class TotalLottoController {

    private final LottoIssueController issueController;
    private final OutputView outputView;
    private final InputView inputView;

    public TotalLottoController() {
        this.issueController = new LottoIssueController();
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public List<Lotto> issueLottos() {
        List<Lotto> issueLottos = null;
        while (issueLottos == null) {
            try {
                outputView.enterYourAmount();
                int money = inputView.inputMoney();
                issueLottos = issueController.issueLottos(money);
            } catch (IllegalArgumentException e) {
                outputView.printInvalidateMoneyStatement();
            }
        }
        return issueLottos;
    }

    public void showLottoNumbers(List<Lotto> lottos) {
        outputView.showLottosNumber(lottos);
    }
}
