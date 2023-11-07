package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getPurchaseAmountFromUser() {
        return Integer.parseInt(Console.readLine());
    }
}
