package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.LottosPurchased;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Amount amount;
    private LottosPurchased lottosPurchased;

    public void playGame() {
        repeatInputAmount();
        purchaseLottos();
    }

    private void repeatInputAmount() {
        while (true) {
            try {
                amount = new Amount(inputView.inputAmount());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private void purchaseLottos() {
        lottosPurchased = new LottosPurchased(amount.getAmount());
        outputView.printNumberOfLottosPurchased(lottosPurchased.getNumberOfLottos());
        outputView.printLottosPurchased(lottosPurchased.getLottos());
    }

    private void repeatInputWinningNumbers() {
        //
    }

    private void repeatInputBonusNumber() {
        //
    }

    private void getAndPrintResults() {
        //
    }
}
