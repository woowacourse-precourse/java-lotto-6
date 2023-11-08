package lotto;

import static lotto.Application.LOTTO_PRICE;

public class Validation {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;


    public void price(int userPurchaseAmount) {
        if (userPurchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원 입니다. 1,000원 단위로 다시 입력해 주세요.");
        }
    }

    public void bonusNumberCheck(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다. 다시 입력해 주세요.");
        }
    }

    public void numberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위는 1~45 입니다.");
        }
    }
}
