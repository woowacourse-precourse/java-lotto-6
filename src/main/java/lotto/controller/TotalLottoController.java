package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
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

    public Lotto issueWinningLotto() {
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

    public List<Lotto> issueLottos() {
        List<Lotto> issueLottos = null;
        while (issueLottos == null) {
            try {
                int money = inputView.inputMoney();
                issueLottos = issueController.issueLottos(money);
            } catch (IllegalArgumentException e) {
                outputView.showErrorReason(e.getMessage());
            }
        }
        return issueLottos;
    }

    public void showLottoNumbers(List<Lotto> lottos) {
        outputView.showLottosNumber(lottos);
    }

    public WinningLotto issueLottoResult(Lotto winningLotto) {
        WinningLotto lottoResult = null;
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
}
