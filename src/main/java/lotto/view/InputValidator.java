package lotto.view;

import lotto.model.Lotto;

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
}
