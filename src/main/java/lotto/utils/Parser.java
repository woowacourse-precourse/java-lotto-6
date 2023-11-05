package lotto.utils;

import lotto.domain.PurchaseAmount;

public class Parser {
    static final int cost = 1000;
    public static int parseStringToInt(String stringValue) {
        try {
            int intValue = Integer.parseInt(stringValue);
            return intValue;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 정수값을 입력해 주세요.");
        }
    }

    public static int parseAmountToLottoNumber(PurchaseAmount purchaseAmount){
        return purchaseAmount.getAmount()/cost;
    }
}
