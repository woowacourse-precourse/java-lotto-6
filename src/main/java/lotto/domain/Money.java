package lotto.domain;

import static lotto.domain.Constant.LOTTO_PRICE;

public class Money {
    private int purchasePrice;

    public Money(String money) {
        validateNumber(money);
        validateUnit(money);
        this.purchasePrice = Integer.parseInt(money);
    }

    private void validateNumber(String money) {
        if (!money.chars().allMatch(Character::isDigit)) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(String money) {
        int number = Integer.parseInt(money);
        if (number % LOTTO_PRICE != 0 || number < LOTTO_PRICE) {
            System.out.println("[ERROR] 구매금액은 1000원 단위입니다.");
            throw new IllegalArgumentException();
        }
    }

    public int getLottoCount() {
        return purchasePrice / LOTTO_PRICE;
    }
}
