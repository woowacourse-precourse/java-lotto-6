package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoGame {
    private LottoMachine lottoMachine;
    private Player player;
    private Lotto winningNumber;

    public LottoGame() {
    }

    public void run() {
        int bonusNumber;
        int inputMoney = InputView.inputBuyMoney();

        player = purchaseLotto(inputMoney);

        OutputView.showPlayerLotto(player, lottoMachine.calculatePurchaseCount());

        winningNumber = new Lotto(InputView.inputDrawingNumber());
        bonusNumber = InputView.inputBonusNumber();
        winningNumber.validateContainsBonusInLotto(bonusNumber);

        player.checkWinning(winningNumber, bonusNumber);

        OutputView.showPlayerWinningStatistics(player, inputMoney);
    }

    private Player purchaseLotto(int inputMoney) {
        lottoMachine = new LottoMachine(inputMoney);
        return lottoMachine.generatePlayerLotto();
    }
}
