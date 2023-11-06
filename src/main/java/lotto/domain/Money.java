package lotto.domain;

import lotto.message.ExceptionMessage;

// TODO 지갑과 로또가 너무 연관있는 것 같음
public class Money {
    private int amount;

    public Money(int money) {
        validateMoney(money);
        this.amount = money;
    }

    private void validateMoney(int money) {
        validateOverThanLottoPrice(money);
        validateUnit(money);
    }

    private void validateOverThanLottoPrice(int money) {
        if (money < LottoOption.LOTTO_PRICE) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_ENOUGH_MONEY);
        }
    }

    private void validateUnit(int money) {
        if (money % LottoOption.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_UNIT);
        }
    }

    public boolean canPurchaseLotto() {
        return amount >= LottoOption.LOTTO_PRICE;
    }

    public void payLotto() {
        if (canPurchaseLotto()) {
            this.amount -= LottoOption.LOTTO_PRICE;
            return;
        }
        throw new IllegalArgumentException(ExceptionMessage.NOT_ENOUGH_MONEY);
    }
}
