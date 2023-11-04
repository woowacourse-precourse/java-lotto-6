package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private String request() {
        return Console.readLine();
    }

    public String requestPurchaseAmount() {
        return request();
    }
}
