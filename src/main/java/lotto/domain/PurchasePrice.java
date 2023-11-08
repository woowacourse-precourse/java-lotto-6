package lotto.domain;

import lotto.constant.MagicNumber;

public class PurchasePrice {
    private final int purchasePrice;

    public PurchasePrice(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public int getTotalLottoTickets() {
        return purchasePrice / MagicNumber.PRICE_UNIT.getNumber();
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    private void validate(int price) {
        checkDivideByPriceUnit(price);
        checkIsZeroOrMinus(price);
    }

    private void checkDivideByPriceUnit(int price) {
        if (price % MagicNumber.PRICE_UNIT.getNumber() != 0) {
            throw new IllegalArgumentException("[ERROR] " + MagicNumber.PRICE_UNIT.getNumber() + "원 단위로 구입 금액을 입력해 주세요.");
        }
    }

    private void checkIsZeroOrMinus(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("[ERROR] " + MagicNumber.PRICE_UNIT.getNumber() + "이상의 금액을 입력해 주세요.");
        }
    }
}
