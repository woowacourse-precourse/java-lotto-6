package lotto.domain.shop;

enum ShopConfig {

    LOTTO_PRICE("로또 장당 가격", 1000);

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
