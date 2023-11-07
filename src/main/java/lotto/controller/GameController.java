package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Amount amount;
    private LottosPurchased lottosPurchased;
    private Lotto winningLotto;
    private LottoBonus lottoBonus;
    private LottoStatistics lottoStatistics;

    public void playGame() {
        repeatInputAmount();
        purchaseLottos();
        repeatInputWinningNumbers();
        repeatInputBonusNumber();
        printLottoStatistics();
    }

    private void repeatInputAmount() {
        while (true) {
            try {
                amount = new Amount(inputView.inputAmount());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        System.out.println();
    }

    private void purchaseLottos() {
        lottosPurchased = new LottosPurchased(amount.getAmount());

        outputView.printNumberOfLottosPurchased(lottosPurchased);
        outputView.printLottosPurchased(lottosPurchased);
        System.out.println();
    }

    private void repeatInputWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = Lotto.convertToIntegers(inputView.inputWinningNumbers());
                winningLotto = new Lotto(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        System.out.println();
    }

    private void repeatInputBonusNumber() {
        while (true) {
            try {
                lottoBonus = new LottoBonus(winningLotto, inputView.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        System.out.println();
    }

    private void printLottoStatistics() {
        lottoStatistics = new LottoStatistics(lottosPurchased, winningLotto, lottoBonus, amount);

        outputView.printStatistics(lottoStatistics);
    }
}
