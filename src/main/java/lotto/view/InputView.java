package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Validator.isValidPurchaseAmount(Console.readLine());
    }
}
