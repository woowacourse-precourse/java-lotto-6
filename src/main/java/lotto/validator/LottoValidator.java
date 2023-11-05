package lotto.validator;

import lotto.domain.Lotto;

public class LottoValidator {

    private LottoValidator() {
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < Lotto.PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또는 1개 이상 구매해야 합니다.");
        }
        if (purchaseAmount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매할 수 있습니다.");
        }
    }
}
