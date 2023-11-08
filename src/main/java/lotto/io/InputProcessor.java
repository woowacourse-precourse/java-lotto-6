package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.io.validator.BonusNumberValidator;
import lotto.io.validator.LottoPurchaseAmountValidator;
import lotto.io.validator.WinningNumberValidator;

import java.util.Arrays;
import java.util.List;

public class InputProcessor {
    private static final String COMMA = ",";

    private InputProcessor() {
    }

    public static int readLottoPurchaseCount() {
        System.out.println("구입금액을 입력해 주세요.");

        final String userInput = Console.readLine();
        LottoPurchaseAmountValidator.validate(userInput);

        return Integer.parseInt(userInput) / Buyer.LOTTO_PURCHASE_UNIT;
    }

    public static List<Integer> readWiningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        final String userInput = Console.readLine();
        WinningNumberValidator.validate(userInput);

        return convertStringToList(userInput);
    }

    private static List<Integer> convertStringToList(final String userInput) {
        return Arrays.stream(userInput.split(COMMA))
                .map(Integer::parseInt)
                .toList();
    }

    public static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        final String userInput = Console.readLine();
        BonusNumberValidator.validate(userInput);

        return Integer.parseInt(userInput);
    }
}
