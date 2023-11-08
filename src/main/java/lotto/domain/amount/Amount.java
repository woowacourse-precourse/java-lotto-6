package lotto.domain.amount;

import lotto.constant.Constant;
import lotto.domain.amount.validator.AmountValidator;

public record Amount(int amount) {
    // 도메인 테스트 코드 작성 해야함
    // 로또 최댓값 10만원으로 설정할 것

    public Amount {
        AmountValidator.validateAmount(amount);
    }

    public int getPurchasedCount() {
        return this.amount / Constant.ALLOWED_MINIMUM_AMOUNT_VALUE;
    }

    public double getProfitMargin(final long totalProfit) {
        return (double) totalProfit / this.amount;
    }
}
