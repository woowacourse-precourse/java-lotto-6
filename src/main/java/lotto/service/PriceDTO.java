package lotto.service;

import lotto.domain.PriceAmount;

public class PriceDTO {
    private final int price;
    private final int purchaseNumber;

    public PriceDTO(PriceAmount priceAmount) {
        this.price = priceAmount.getPriceAmount();
        this.purchaseNumber = priceAmount.getPurchaseNumber();
    }

    public int getPrice() {
        return price;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }
}
