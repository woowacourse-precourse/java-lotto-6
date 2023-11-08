package lotto.validation.money.domain;

import lotto.domain.Money;
import lotto.validation.ValidationCondition;

public class MoneyDivisionCondition extends ValidationCondition {

    private Money lottoPrice;
    private static final String EXCEPTION_MSG = "잔돈이 남습니다.";

    public MoneyDivisionCondition(Money lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    @Override
    protected void validateCondition(Object obj) {
        Money money = Money.wons((Integer) obj);

        if (!money.calculateChange(lottoPrice).equals(Money.ZERO)) {
            throw new IllegalArgumentException(ERROR_MSG + EXCEPTION_MSG);
        }
    }

    @Override
    protected boolean isObjectOf(Object obj) {
        return obj instanceof Integer;
    }
}
