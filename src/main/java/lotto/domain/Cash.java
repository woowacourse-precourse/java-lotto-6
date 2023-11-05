package lotto.domain;

import lotto.exception.CashExceptionMessage;

import static lotto.constant.CashConstant.UNIT;
import static lotto.constant.CashConstant.ZERO;
import static lotto.exception.CashExceptionMessage.*;

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
            throw new IllegalArgumentException(NOT_MORE_THAN_UNIT.getMessage());
        }
    }


    private void validateDivisibleByUnit(Integer amount) {
        int remainder = amount % UNIT.getSetting();
        if (remainder != ZERO.getSetting()) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_UNIT.getMessage());
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
