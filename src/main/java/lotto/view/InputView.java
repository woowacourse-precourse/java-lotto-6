package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputViewException;

public class InputView {
    public InputView() {
    }

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount =  Integer.parseInt(Console.readLine());

        InputViewException.checkLottoPriceException(amount);

        return amount;
    }
}
