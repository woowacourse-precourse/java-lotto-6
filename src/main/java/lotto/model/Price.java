package lotto.model;

import lotto.constant.response.Exception;

public enum Price {
    LOTTO(1000);

    private final int amount;

    Price(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int divide(int money){
        if(money == 0 || money % amount != 0){
            throw new IllegalArgumentException(Exception.ERROR_PREFIX.getMessage()
                    + Exception.LOTTO_PRICE.getMessage());
        }
        return money / amount;
    }
}
