package lotto.domain;

public class Cash {

    private static final Integer UNIT = 1000;
    private static final Integer ZERO = 0;
    private final Integer totalAmount;
    private Integer spendAmount;

    public Cash(final Integer totalAmount) {
        validateAvailableAmount(totalAmount);
        validateAvailableCash(totalAmount);
        this.totalAmount = totalAmount;
        this.spendAmount = ZERO;
    }

    private void validateAvailableAmount(Integer amount) {
        if (amount < UNIT) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력하셔야 합니다.");
        }
    }


    private void validateAvailableCash(Integer amount) {
        int remainder = amount % UNIT;
        if (remainder != ZERO) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지는 금액을 입력하셔야 합니다.");
        }
    }


    public Boolean isAfford() {
        int leftAmount = totalAmount - spendAmount;
        return leftAmount >= UNIT;
    }

    public Boolean spend() {
        Boolean afford = isAfford();
        if (afford) {
            spendAmount += UNIT;
        }

        return afford;
    }

    public Integer getSeed() {
        return totalAmount;
    }

}
