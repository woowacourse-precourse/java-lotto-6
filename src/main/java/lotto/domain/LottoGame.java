package lotto.domain;

import lotto.util.NumberUtil;
import lotto.view.InputView;

public class LottoGame {
    private LottoMachine lottoMachine;
    private Player player;

    public LottoGame() {
    }

    public void run() {
        int inputMoney = NumberUtil.toInt(InputView.inputBuyMoney());

        player = purchaseLotto(inputMoney);
    }

    private Player purchaseLotto(int inputMoney) {
        lottoMachine = new LottoMachine(inputMoney);
        return lottoMachine.generatePlayerLotto();
    }
}
