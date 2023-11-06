package lotto.domain;

import lotto.util.NumberUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private LottoMachine lottoMachine;
    private Player player;

    public LottoGame() {
    }

    public void run() {
        int inputMoney = NumberUtil.toInt(InputView.inputBuyMoney());

        player = purchaseLotto(inputMoney);

        OutputView.showPlayerLotto(player, lottoMachine.calculatePurchaseCount());
    }

    private Player purchaseLotto(int inputMoney) {
        lottoMachine = new LottoMachine(inputMoney);
        return lottoMachine.generatePlayerLotto();
    }
}
