package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

public class InputValue {

    public int getPurchaseAmountInput() {
        return Integer.parseInt(Console.readLine());
    }
}
