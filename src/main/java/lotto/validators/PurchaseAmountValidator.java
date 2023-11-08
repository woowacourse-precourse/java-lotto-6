package lotto.validators;

import lotto.utils.NumericUtil;

public class PurchaseAmountValidator {

    public static void validateType(String purchaseAmount) {
        for (int i = 0; i < purchaseAmount.length(); i++) {
            if (!NumericUtil.isNumeric(purchaseAmount.charAt(i))) {
                System.out.println("[ERROR] 구입금액은 숫자!\n");
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateUnit(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) % 1000 != 0) {
            System.out.println("[ERROR] 구입금액은 1,000원 단위!\n");
            throw new IllegalArgumentException();
        }
    }
}
