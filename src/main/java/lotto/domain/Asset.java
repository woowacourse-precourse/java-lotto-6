package lotto.domain;

import lotto.data.Messages;

public class Asset {
    private final Double money;
    private Double income;

    public Asset(Double money) {
        validate(money);

        this.money = money;
        this.income = 0D;
    }

    private void validate(Double money) {
        validateRange(money);
        validateModulate(money);
    }

    private void validateModulate(Double money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(Messages.INPUT_ERROR_MESSAGE);
        }
    }

    private void validateRange(Double number) {
        if (number > Double.MAX_VALUE) {
            throw new IllegalArgumentException(Messages.OVERFLOW_ERROR_MESSAGE);
        }
    }

    public void increaseIncome(Grade grade) {
        income += grade.getPrize();

        validateRange(income);
    }

    public Double getRate() {
        if (money == 0) return 0D;

        return (income / money) * 100;
    }

    public Double getMoney() {
        return money;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        validateRange(income);

        this.income = income;
    }
}
