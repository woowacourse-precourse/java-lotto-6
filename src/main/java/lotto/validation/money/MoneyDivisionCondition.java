package lotto.validation.money;

import lotto.domain.Money;
import lotto.validation.ValidationCondition;

public class MoneyDivisionCondition extends ValidationCondition {

    private Money lottoPrice;

    public MoneyDivisionCondition(Money lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    @Override
    public void isSatisfiedBy(String money) {
        Money wons = Money.wons(Integer.parseInt(money));
        if (!wons.calculateChange(lottoPrice).equals(Money.ZERO)) {
            throw new IllegalArgumentException(ERROR_MSG + "잔돈이 남습니다.");
        }
    }
}
