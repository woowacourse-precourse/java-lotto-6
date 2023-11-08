package view;

import validator.LottoPurchaseValidator;
import camp.nextstep.edu.missionutils.Console;

public class LottoPurchaseInputView {
    final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";

    LottoPurchaseValidator lottoPurchaseValidator = new LottoPurchaseValidator();

    public int readLottoPurchaseValidator() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        String lottoPurchaseAmount = Console.readLine();
        while (true) {
            try {
                int lottoPurchasePrice = lottoPurchaseValidator.validPurchaseAmount(lottoPurchaseAmount);
                return lottoPurchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

                System.out.println(PURCHASE_AMOUNT_PROMPT);
                lottoPurchaseAmount = Console.readLine();
            }
        }
    }
}