package lotto.domain;

import static lotto.constant.CashConstant.UNIT;
import static lotto.constant.CashConstant.ZERO;

public class Cash {
    private final Integer depositAmount;
    private Integer spendAmount;

    public Cash(final Integer depositAmount) {
        validateMoreThanUnit(depositAmount);
        validateDivisibleByUnit(depositAmount);
        this.depositAmount = depositAmount;
        this.spendAmount = ZERO.getSetting();
    }

    private void validateMoreThanUnit(Integer amount) {
        if (amount < UNIT.getSetting()) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력하셔야 합니다.");
        }
    }


    private void validateDivisibleByUnit(Integer amount) {
        int remainder = amount % UNIT.getSetting();
        if (remainder != ZERO.getSetting()) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지는 금액을 입력하셔야 합니다.");
        }
    }


    public Boolean isAfford() {
        int leftAmount = depositAmount - spendAmount;
        return leftAmount >= UNIT.getSetting();
    }

    public Boolean spend() {
        Boolean afford = isAfford();
        if (afford) {
            spendAmount += UNIT.getSetting();
        }

        return afford;
    }

    public Integer getDepositAmount() {
        return depositAmount;
    }

}
