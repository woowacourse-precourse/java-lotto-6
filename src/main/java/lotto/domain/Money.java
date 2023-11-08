package lotto.domain;

import static lotto.domain.Constant.LOTTO_PRICE;

public class Money {
    private int purchasePrice;

    public Money(String money) {
        validateNumber(money);
        validateUnit(money);
        this.purchasePrice = Integer.parseInt(money);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    private void validateNumber(String money) {
        if (!money.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private void validateUnit(String money) {
        int number = Integer.parseInt(money);
        if (number % LOTTO_PRICE != 0 || number < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1000원 단위입니다.");
        }
    }

    public int getLottoCount() {
        return purchasePrice / LOTTO_PRICE;
    }
}
