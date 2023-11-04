package lotto.io.collaboration;

import lotto.io.Input;
import lotto.io.Output;

public class Lottos {

    private int purchaseAmount;

    public void purchase() {
        Output.consoleLine("구입금액을 입력해 주세요.");
        purchaseAmount = Input.consoleNumber();
    }

}
