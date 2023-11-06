package lotto.controller;

import java.util.List;
import lotto.model.LottoPlayer;
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

        LottoPlayer lottoPlayer = new LottoPlayer(amount);
        lottoPlayer.buyLottos();

        outputView.answerForPurchase(lottoPlayer.getLottoTicketCount(), lottoPlayer.getLottoNumbers());

        outputView.askForWinningNumbers();
        List<Integer> winningNumbers = inputView.getWinningNumbers();

        outputView.askForBonusNumber();
        int bonusNumber = inputView.getBonusNumber(winningNumbers);

        lottoPlayer.checkLottoResult(winningNumbers, bonusNumber);

        outputView.printLottoResult(lottoPlayer.getLottoResult());
    }
}
