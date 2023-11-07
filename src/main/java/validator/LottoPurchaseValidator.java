package validator;

public class LottoPurchaseValidator {
    void validMinimumPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 최소 구입금액은 1000원 입니다.");
        }
    }
}
