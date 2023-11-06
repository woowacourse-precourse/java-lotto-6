package lotto.domain.shop;

enum ShopConfig {

    LOTTO_PRICE("로또 장당 가격", 1000),
    LOTTO_PURCHASE_LIMIT("로또 구매액 한도", 100000);

    private final String description;
    private final int value;

    ShopConfig(String description, int value) {
        this.description = description;
        this.value = value;
    }

    int getValue() {
        return value;
    }

}
