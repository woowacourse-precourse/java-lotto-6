package lotto.fixture;

import lotto.domain.Purchase;

public enum PurchaseFixture {
    다섯장(5000L),
    네장(4000L),
    세장(3000L),
    두장(2000L),
    한장(1000L),
    비정상(1200L);

    private final long price;

    PurchaseFixture(final long price) {
        this.price = price;
    }

    public Purchase 생성() {
        return new Purchase(price);
    }
}
