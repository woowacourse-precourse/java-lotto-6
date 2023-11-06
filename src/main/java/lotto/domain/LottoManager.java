package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;

public class LottoManager {

    public void isValidPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
