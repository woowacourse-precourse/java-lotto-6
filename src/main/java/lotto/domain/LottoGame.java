package lotto.domain;

import lotto.util.NumberUtil;
import lotto.view.InputView;

public class LottoGame {
    public void run() {
        int inputMoney = NumberUtil.toInt(InputView.inputBuyMoney());
        LottoMachine lottoMachine = new LottoMachine(inputMoney);
    }
}
