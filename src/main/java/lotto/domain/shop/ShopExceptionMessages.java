package lotto.domain.shop;

enum ShopExceptionMessages {

    LOTTO_PURCHASE_OVER_LIMIT(String.format(
            "로또 구매액 한도는 %d원입니다.",
            ShopConfig.LOTTO_PURCHASE_LIMIT.getValue()
    ));

    private final String message;

    ShopExceptionMessages(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }

}
