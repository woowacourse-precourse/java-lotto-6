package lotto.view;

import static lotto.constant.Constant.LOTTO_PURCHASE_MINIMUM_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Constant;
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
        return Integer.parseInt(lottoPurchaseAmount) / LOTTO_PURCHASE_MINIMUM_AMOUNT;
    }

}
