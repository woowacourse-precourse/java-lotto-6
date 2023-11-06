package lotto;

import static lotto.Application.LOTTO_PRICE;

public class Validation {

    public void price(int userPurchaseAmount) {
        if (userPurchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원 입니다. 1,000원 단위로 다시 입력해주세요.");
        }
    }
}
