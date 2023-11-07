package lotto.controller;

import java.util.List;
import lotto.model.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.askForPurchaseAmount();
        int amount = inputView.getPurchaseAmount();

        LottoManager lottoManager = new LottoManager(amount);
        lottoManager.issueLottos();

        outputView.answerForPurchase(lottoManager.getLottoTicketCount(), lottoManager.getLottoNumbers());

        outputView.askForWinningNumbers();
        List<Integer> winningNumbers = inputView.getWinningNumbers();

        outputView.askForBonusNumber();
        int bonusNumber = inputView.getBonusNumber(winningNumbers);

        lottoManager.checkLottosResult(winningNumbers, bonusNumber);
        double rateOfReturn = lottoManager.getRateOfReturn();

        outputView.printLottoResult(lottoManager.printLottosResult(), rateOfReturn);
    }
}
