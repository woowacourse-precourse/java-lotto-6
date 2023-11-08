package lotto.domain;

/**
 * @author 민경수
 * @description lotto purchase amount
 * @since 2023.11.04
 **********************************************************************************************************************/
public class LottoPurchaseAmount {

    private int value;

    private LottoPurchaseAmount(int value) {
        this.value = value;
    }

    public static LottoPurchaseAmount valueOf(int amount) {
        validateMinimumAmount(amount);
        validatePurchaseUnit(amount);
        return new LottoPurchaseAmount(amount);
    }

    private static void validateMinimumAmount(int amount) {
        if (amount < Lotto.PRICE) {
            throw new IllegalArgumentException("[ERROR] " + Lotto.PRICE + "원보다 작은 금액은 입력하실 수 없습니다. 입력한 금액 : " + amount);
        }
    }

    private static void validatePurchaseUnit(int amount) {
        if (amount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 " + Lotto.PRICE + "원 단위로 입력해주세요. 입력한 금액 : " + amount);
        }
    }

    public boolean isBuyable() {
        return value >= Lotto.PRICE;
    }

    public void subtractOnePriceUnit() {
        value -= Lotto.PRICE;
    }

}