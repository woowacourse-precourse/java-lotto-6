package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.validator.LottoPurchaseAmountValidator;
import lotto.io.validator.WinningNumberValidator;

public class InputProcessor {
    private InputProcessor() {
    }

    public static String readLottoPurchaseCount() {
        System.out.println("구입금액을 입력해 주세요.");

        final String userInput = Console.readLine();
        LottoPurchaseAmountValidator.validate(userInput);

        return userInput;
    }

    public static String readWiningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        final String userInput = Console.readLine();
        WinningNumberValidator.validate(userInput);

        return userInput;
    }
}
