package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = inputView.purchase();
        int numberOfLotto = purchaseAmount / Lotto.TICKET_PRICE;
        LottoTicket lottoTicket = LottoTicket.generate(numberOfLotto);

        List<Integer> winningNumbers = inputView.winningNumbers();
        int bonusNumber = inputView.bonusNumber();
        WinningNumbers winningNumbersObject = new WinningNumbers(winningNumbers);

        int totalPrize = lottoTicket.calculateTotalPrize(winningNumbersObject, bonusNumber);
        double earningRate = lottoTicket.calculateEarningRate(totalPrize, purchaseAmount);

        outputView.printNumberOfPurchase(numberOfLotto);
        outputView.printLottoTicket(lottoTicket);
        outputView.printPrize(lottoTicket);
        outputView.printEarningRate(earningRate);
    }
}
