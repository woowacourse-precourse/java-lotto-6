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
        amount = repeatInputAmount();
        lottosPurchased = new LottosPurchased(amount.getAmount());
        outputView.printNumberOfLottosPurchased(lottosPurchased.getNumberOfLottos());
    }

    private Amount repeatInputAmount() {
        while (true) {
            try {
                return new Amount(inputView.inputAmount());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
