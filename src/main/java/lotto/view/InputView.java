package lotto.view;

import lotto.util.Convert;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public Integer readPurchaseAmount() {
        return Convert.stringToInteger(readLine());
    }
}
