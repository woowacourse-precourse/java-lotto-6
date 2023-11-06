package lotto.domain;

import lotto.util.NumberUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private LottoMachine lottoMachine;
    private Player player;
    private Lotto winningNumber;

    public LottoGame() {
    }

    public void run() {
        int inputMoney = InputView.inputBuyMoney();

        player = purchaseLotto(inputMoney);

        OutputView.showPlayerLotto(player, lottoMachine.calculatePurchaseCount());

        winningNumber = new Lotto(InputView.inputDrawingNumber());
    }

    private Player purchaseLotto(int inputMoney) {
        lottoMachine = new LottoMachine(inputMoney);
        return lottoMachine.generatePlayerLotto();
    }
}
