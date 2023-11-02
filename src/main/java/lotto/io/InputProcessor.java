package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.User;
import lotto.io.validator.LottoPurchaseAmountValidator;

public class InputProcessor {
    private InputProcessor() {
    }

    public static int readLottoPurchaseCount() {
        System.out.println("구입금액을 입력해 주세요.");

        final String userInput = Console.readLine();
        LottoPurchaseAmountValidator.validate(userInput);

        return Integer.parseInt(userInput) / User.LOTTO_PURCHASE_UNIT;
    }
}
