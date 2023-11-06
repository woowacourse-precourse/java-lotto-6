package lotto.view;

import lotto.model.lotto.Lotto;

public class InputValidator {
    private static final String DIVISIBILITY_ERROR = "구입 금액은 " + Lotto.PRICE + "으로 나누어져야 합니다.";
    private static final String MINIMUM_AMOUNT_ERROR = "구입 금액은 " + Lotto.PRICE + " 이상이어야 합니다.";


    public static void divisibleByThousand(int purchaseAmount){
        if (purchaseAmount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(DIVISIBILITY_ERROR);
        }
    }

    public static void greaterThanThousand(int purchaseAmount){
        if (purchaseAmount < Lotto.PRICE) {
            throw new IllegalArgumentException(MINIMUM_AMOUNT_ERROR);
        }
    }

    public static void inRange(int number) {
        if(number < Lotto.LOTTO_MIN || number > Lotto.LOTTO_MAX){
            throw new IllegalArgumentException(Lotto.OUT_OF_RANGE_ERROR);
        }
    }
}
