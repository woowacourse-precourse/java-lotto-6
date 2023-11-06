package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.LottoPurchaseAmountValidator;

public class InputView {

    public static int getLottoPurchaseAmount() {
        String lottoPurchaseAmount = "";
        boolean isNotRightInput = true;

        while (isNotRightInput) {
            System.out.println("구입금액을 입력해 주세요.");
            lottoPurchaseAmount = Console.readLine();
            try {
                LottoPurchaseAmountValidator.validateLottoPurchaseAmount(lottoPurchaseAmount);
                isNotRightInput = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(lottoPurchaseAmount);
    }

}
