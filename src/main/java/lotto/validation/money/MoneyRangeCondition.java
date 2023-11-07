package lotto.validation.money;

import lotto.validation.ValidationCondition;

public class MoneyRangeCondition extends ValidationCondition {
    private static Integer intSize = Integer.MAX_VALUE;
    @Override
    public void isSatisfiedBy(String money) {
        try {
            int moneyValue = Integer.parseInt(money);
            if (moneyValue < 0 || moneyValue > intSize) {
                throw new IllegalArgumentException(ERROR_MSG + "금액이 범위를 넘어섰습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MSG + "금액이 범위를 넘어섰습니다.");
        }
    }
}
