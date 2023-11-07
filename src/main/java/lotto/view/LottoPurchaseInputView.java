package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.exception.InvalidLottoPurchaseException;

public class LottoPurchaseInputView {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    private static final String LOTTO_PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int getLottoPurchaseAmount() {
        while (true) {
            try {
                System.out.println(LOTTO_PURCHASE_INPUT_MESSAGE);
                String purchaseAmount = Console.readLine().trim();
                System.out.println();
                inputValidate(purchaseAmount);
                validateLottoPurchaseAmount(purchaseAmount);
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void inputValidate(String inputWinningNumbers) {
        if (!NUMBER_PATTERN.matcher(inputWinningNumbers).matches()) {
            throw new InvalidLottoPurchaseException();
        }
    }

    private static void validateLottoPurchaseAmount(String input) {
        int inputValue = Integer.parseInt(input);
        if (inputValue % 1000 != 0) {
            throw new InvalidLottoPurchaseException();
        }
    }
}
