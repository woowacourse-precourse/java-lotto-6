package lotto.view;

import lotto.model.lotto.Lotto;

public class InputValidator {
    public static void divisibleByThousand(int purchaseAmount){
        if (purchaseAmount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000으로 나누어져야 합니다.");
        }
    }

    public static void greaterThanThousand(int purchaseAmount){
        if (purchaseAmount < Lotto.PRICE) {
            throw new IllegalArgumentException("구입 금액은 1000 이상이어야 합니다.");
        }
    }

    public static void inRange(int number) {
        if(number < Lotto.LOTTO_MIN || number > Lotto.LOTTO_MAX){
            throw new IllegalArgumentException(Lotto.OUT_OF_RANGE_ERROR);
        }
    }
}
