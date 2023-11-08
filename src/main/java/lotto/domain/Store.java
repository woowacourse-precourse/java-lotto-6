package lotto.domain;

import lotto.domain.policy.PricePolicy;

public class Store {

    private static final int MAX_INPUT= 2_100_000_000;

    private final int priceInput;

    public Store(int priceInput, PricePolicy pricePolicy) {
        validate(priceInput,pricePolicy);
        this.priceInput = priceInput;
    }

    private void validate(int priceInput, PricePolicy pricePolicy){
        if (isLowerThanMinimumPrice(priceInput, pricePolicy)) {
            throw new IllegalArgumentException("[ERROR] 최소 금액보다는 작은값을 입력하셨습니다.");
        }
        if (isNotDivisibleByMinimumPrice(priceInput, pricePolicy)) {
            throw new IllegalArgumentException("[ERROR] 최소 금액으로 나누어 떨어지는 값을 입력해주세요.");
        }
        if (isHigherThanMaxInput(priceInput)) {
            throw new IllegalArgumentException("[ERROR] 최대 금액보다 큰 값을 입력하셨습니다.");
        }
    }

    private boolean isLowerThanMinimumPrice(int priceInput, PricePolicy pricePolicy) {
        return priceInput < pricePolicy.price();
    }

    private boolean isNotDivisibleByMinimumPrice(int priceInput, PricePolicy pricePolicy) {
        return priceInput % pricePolicy.price() != 0;
    }

    private boolean isHigherThanMaxInput(int priceInput) {
        return priceInput > MAX_INPUT;
    }

    public int getLottoCount(PricePolicy pricePolicy) {
        return this.priceInput / pricePolicy.price();
    }

    public int getMoney() {
        return this.priceInput;
    }

}
