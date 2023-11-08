package lotto.controller;

import static lotto.domain.LottoNumbers.setRandomLottoNumbers;

import lotto.Lotto;
import lotto.domain.PlayerLottoAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static PlayerLottoAmount playerLottoAmount;

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int ticketCount = inputPlayerAmount();

        Lotto lotto = new Lotto(InputView.inputLottoNumber());

        int bonusNum = InputView.inputBonusNumber();

        OutputView.printPurchaseCount(ticketCount);
        for (int i = 0; i < ticketCount; ++i) {
            OutputView.printRandomLottoNumbers(setRandomLottoNumbers());
        }
    }

    private int inputPlayerAmount() {
        playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerPrice());
        return playerLottoAmount.calculateLottoCount();
    }
}
