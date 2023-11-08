package lotto;

import java.util.List;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private LottoManagement lottoManagement;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoManagement = new LottoManagement();
        this.outputView = new OutputView();
    }

    public void run() {
        int amount = inputView.purchaseLottoAmount();
        List<Lotto> lottery = lottoManagement.buyLotto(amount);
        outputView.writePurchaseDetails(lottery);
        Lotto winningNumbers = new Lotto(inputView.readWinningLotto());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, inputView.readBonusNumber(winningNumbers.getNumbers()));
        LottoResult lottoResult = new LottoResult(lottery, winningLotto);
        LottoWinningResultSummary lottoWinningResultSummary = new LottoWinningResultSummary(lottoResult);
        outputView.writeLottoResult(lottoWinningResultSummary);
    }
}
