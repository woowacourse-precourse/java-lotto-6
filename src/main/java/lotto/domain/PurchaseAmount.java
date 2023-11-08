package lotto.domain;

import lotto.view.message.ExceptionMessage;

public class PurchaseAmount {
    private int money;

    public PurchaseAmount(int money) {
        validate(money);
        this.money = money;
    }

    public int getLottoCount() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
    private void validate(int money) {
        validateInputZero(money);
        validatePurchaseAmount(money);
    }
    private void validatePurchaseAmount(int money) {
        if (money % 1000 != 0) {
            System.out.println(ExceptionMessage.ERROR_MESSAGE_ABOUT_NOT_DIVIDED_THOUSAND.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void validateInputZero(int money) {
        if (money == 0) {
            System.out.println(ExceptionMessage.ERROR_MESSAGE_ABOUT_ZERO.getMessage());
            throw new IllegalArgumentException();
        }
    }


}
