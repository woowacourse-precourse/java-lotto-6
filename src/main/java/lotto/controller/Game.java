package lotto.controller;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoStorage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Game {

    private InputView inputView;
    private OutputView outputView;

    public Game() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        init();
    }

    private void init() {
        int purchasePrice = requestPurchasePrice();
        LottoGenerator.generateLotto(purchasePrice);
        List<Lotto> purchaseLotto = LottoStorage.getLotto();
        outputView.printPurchaseLotto(purchaseLotto);

        Lotto winningLotto = requestWinningLotto();
        Bonus bonusLotto = requestBonusLotto();
        inputView.closeInputConsole();
    }

    private int requestPurchasePrice() {
        while (true) {
            int purchasePrice;
            try {
                purchasePrice = inputView.requestPurchasePrice();
            } catch (IllegalArgumentException error) {
                outputView.printErrorMessage(error);
                continue;
            }
            outputView.printBlank();
            return purchasePrice;
        }
    }

    private Lotto requestWinningLotto() {
        while (true) {
            Lotto winningLotto;
            try {
                List<Integer> winningNumbers = inputView.requestWinningNumber();
                winningLotto = new Lotto(winningNumbers);
            } catch (IllegalArgumentException error) {
                outputView.printErrorMessage(error);
                continue;
            }
            outputView.printBlank();
            return winningLotto;
        }
    }

    private Bonus requestBonusLotto() {
        while (true) {
            Bonus bonus;
            try {
                int bonusNumber = inputView.requestBonusNumber();
                bonus = new Bonus(bonusNumber);
            } catch (IllegalArgumentException error) {
                outputView.printErrorMessage(error);
                continue;
            }
            outputView.printBlank();
            return bonus;
        }
    }
}
