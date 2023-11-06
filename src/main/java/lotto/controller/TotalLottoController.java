package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoConsumer;
import lotto.domain.ResultStatics;
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

    public LottoConsumer issueLottos() {
        LottoConsumer issueLottoConsumer = null;
        while (issueLottoConsumer == null) {
            try {
                int money = inputView.inputMoney();
                issueLottoConsumer = issueController.issueLottos(money);
            } catch (IllegalArgumentException e) {
                outputView.showErrorReason(e.getMessage());
            }
        }
        return issueLottoConsumer;
    }

    public void showLottoNumbers(LottoConsumer lottoConsumer) {
        outputView.showLottosNumber(lottoConsumer.getIssuedLottos());
    }

    public LottoResult issueLottoResult() {
        LottoResult lottoResult = null;
        Lotto winningLotto = issueWinningLotto();
        while (lottoResult == null) {
            try {
                int bonusNumber = inputView.inputBonusNumber();
                lottoResult = issueController.issueLottoResult(winningLotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.showErrorReason(e.getMessage());
            }
        }
        return lottoResult;
    }

    private Lotto issueWinningLotto() {
        Lotto lotto = null;
        while (lotto == null) {
            try {
                outputView.enterYourNumber();
                List<Integer> winningNumber = inputView.inputNumbers();
                lotto = issueController.issueWinningLotto(winningNumber);
            } catch (IllegalArgumentException e) {
                outputView.showErrorReason(e.getMessage());
            }
        }
        return lotto;
    }

    public void showStatistics(ResultStatics resultStatics) {
        outputView.showResultStatistics(resultStatics);
    }
}
