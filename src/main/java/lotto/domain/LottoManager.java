package lotto.domain;

public class LottoManager {
    public static final int PURCHASE_AMOUNT_UNIT = 1_000;

    public int calculateNumberOfLottos(int money) {
        validatePurchaseAmount(money);
        int LottosAmount = money / PURCHASE_AMOUNT_UNIT;

        return LottosAmount;
    }

    public void validatePurchaseAmount(int money) {
        if (money % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public double calculateProfitRate(int purchaseAmount, int totalPrize) {
        return ((double) totalPrize) / purchaseAmount * 100;
    }
}
