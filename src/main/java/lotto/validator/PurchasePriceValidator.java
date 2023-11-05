package lotto.validator;

public class PurchasePriceValidator {
    private final int THOUSAND = 1000;

    private boolean isUnderMinPrice(int price) {
        return price < THOUSAND;
    }

    public void checkOverMinPrice(int price) {
        if (isUnderMinPrice(price)) {
            throw new IllegalArgumentException("[ERROR] 최소 구매 금액은 1000원입니다.");
        }
    }

    private boolean isRemainderNotZero(int price) {
        return price % THOUSAND != 0;
    }

    public void checkRemainderZero(int price) {
        if (isRemainderNotZero(price)) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나눠지지 않습니다. 1000원 단위로 입력해주세요.");
        }
    }
}
