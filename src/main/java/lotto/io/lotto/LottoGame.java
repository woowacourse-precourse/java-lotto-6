package lotto.io.lotto;

import lotto.io.Input;
import lotto.io.Output;

public class LottoGame {

    public void run() {
        Output.consoleLine("구입금액을 입력해 주세요.");
        int purchaseAmount = Input.consoleNumber();
    }

}
