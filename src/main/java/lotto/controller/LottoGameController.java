package lotto.controller;

import lotto.model.*;
import lotto.view.*;

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
        LottoTicket lottoTicket = generateLottoTicket(purchaseAmount);

        WinningNumbers winningNumbers = receiveWinningNumbers();
        int bonusNumber = inputView.bonusNumber();

        int totalPrize = lottoTicket.calculateTotalPrize(winningNumbers, bonusNumber);
        double earningRate = lottoTicket.calculateEarningRate(totalPrize, purchaseAmount);

        outputView.printNumberOfPurchase(lottoTicket.getLottoList().size());
        outputView.printLottoTicket(lottoTicket);
        outputView.printPrize(lottoTicket);
        outputView.printEarningRate(earningRate);
    }

    private LottoTicket generateLottoTicket(int purchaseAmount) {
        int numberOfLotto = purchaseAmount / Lotto.TICKET_PRICE;
        return LottoTicket.generate(numberOfLotto);
    }

    private WinningNumbers receiveWinningNumbers() {
        List<Integer> winningNumbers = inputView.winningNumbers();
        return new WinningNumbers(winningNumbers);
    }
}
