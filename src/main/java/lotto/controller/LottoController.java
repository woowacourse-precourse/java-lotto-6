package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.Messages;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Stream;

public class LottoController {

    private Amount amount;
    private Lotto lotto;
    private WinningLotto winningLotto;
    private Result result;
    private UserLotto userLotto;
    private Profit profit;
    private Bonus bonus;

    public void run() {
        enterLottoAmount();
        enterWinningLotto();
        enterBonusNumber();
    }

    private void enterLottoAmount() {
        try {
            this.amount = new Amount(InputView.getInputAmount().trim());
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            enterLottoAmount();
        }
    }

    private void enterWinningLotto() {
        try {
            List<Integer> winningLotto = Stream
                    .of(InputView.getWinningLotto().trim().split(","))
                    .map(Integer::parseInt)
                    .toList();
            this.lotto = new Lotto(winningLotto);
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            enterWinningLotto();
        }
    }

    private void enterBonusNumber() {
        try {
            this.bonus = new Bonus(InputView.getBonusNumber().trim(), lotto);
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            enterBonusNumber();
        }
    }


}
