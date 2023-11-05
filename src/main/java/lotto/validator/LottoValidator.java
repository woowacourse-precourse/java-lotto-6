package lotto.validator;

public class LottoValidator {

    private static final int LOTTO_PRICE = 1_000;

    private LottoValidator() {
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또는 1개 이상 구매해야 합니다.");
        }
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매할 수 있습니다.");
        }
    }
}
