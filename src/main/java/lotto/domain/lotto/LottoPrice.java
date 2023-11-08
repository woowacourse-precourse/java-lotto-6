package lotto.domain.lotto;

import lotto.exception.ExceptionMessage;

public enum LottoPrice {
    THOUSAND_WON(1_000);

    private final int price;

    LottoPrice(int price) {
        this.price = price;
    }

    public void validate(int purchaseAmount){
        if(purchaseAmount % price != 0){
            ExceptionMessage.PURCHASE_AMOUNT_NOT_DIVIDED.throwException();
        }
    }

    public int calcLottoCount(int purchaseAmount){
        return purchaseAmount / price;
    }

    public int getPrice() {
        return price;
    }
}
