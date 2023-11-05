package lotto.domain;

public class Cash {

    private static final Integer UNIT = 1000;
    private static final Integer ZERO = 0;
    private final Integer depositAmount;
    private Integer spendAmount;

    public Cash(final Integer depositAmount) {
        validateMoreThanUnit(depositAmount);
        validateDivisibleByUnit(depositAmount);
        this.depositAmount = depositAmount;
        this.spendAmount = ZERO;
    }

    private void validateMoreThanUnit(Integer amount) {
        if (amount < UNIT) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력하셔야 합니다.");
        }
    }


    private void validateDivisibleByUnit(Integer amount) {
        int remainder = amount % UNIT;
        if (remainder != ZERO) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지는 금액을 입력하셔야 합니다.");
        }
    }


    public Boolean isAfford() {
        int leftAmount = depositAmount - spendAmount;
        return leftAmount >= UNIT;
    }

    public Boolean spend() {
        Boolean afford = isAfford();
        if (afford) {
            spendAmount += UNIT;
        }

        return afford;
    }

    public Integer getDepositAmount() {
        return depositAmount;
    }

}
