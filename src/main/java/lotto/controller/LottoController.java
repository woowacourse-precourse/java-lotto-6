package lotto.controller;

import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public static void run() {
        OutputView.askAmountForLotto();
        List<Lotto> lottos = OutputView.repeatGenerateRandomLotto();
        OutputView.askWinningNumbers();
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        OutputView.askBonusNumbers();
        int bonusNumber = InputView.getBonusNumber(winningNumbers);
        Lotto.countWinningTickets(winningNumbers, lottos, bonusNumber);
    }
}
