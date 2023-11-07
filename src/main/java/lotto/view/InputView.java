package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.*;

public class InputView {

    private InputView() {

    }

    protected Integer readPurchaseAmount() {
        return parseInt(Console.readLine());
    }
}
