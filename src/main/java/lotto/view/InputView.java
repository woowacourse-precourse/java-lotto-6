package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Utils;

public class InputView {

    public int inputPurchaseAmount() {
        return Utils.convertStringToInt(Console.readLine());
    }
}
