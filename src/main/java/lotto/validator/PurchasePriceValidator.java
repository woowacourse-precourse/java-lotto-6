package lotto.validator;

public class PurchasePriceValidator {
    private final int THOUSAND = 1000;

    private boolean isOverMinPrice() {
        return true;
    }

    private void checkOverMinPrice() {

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
