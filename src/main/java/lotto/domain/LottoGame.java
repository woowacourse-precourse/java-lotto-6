package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private LottoMachine lottoMachine;
    private Player player;
    private Lotto winningNumber;

    public LottoGame() {
    }

    public void run() {
        int bonusNumber;
        int inputAmount = InputView.inputPurchaseAmount();

        player = purchaseLotto(inputAmount);

        OutputView.showPlayerLotto(player, lottoMachine.calculatePurchaseCount());

        winningNumber = new Lotto(InputView.inputWinningNumber());
        bonusNumber = InputView.inputBonusNumber(winningNumber);

        player.checkWinning(winningNumber, bonusNumber);

        OutputView.showPlayerWinningStatistics(player, inputAmount);
    }

    private Player purchaseLotto(int inputAmount) {
        lottoMachine = new LottoMachine(inputAmount);
        return lottoMachine.generatePlayerLotto();
    }
}
