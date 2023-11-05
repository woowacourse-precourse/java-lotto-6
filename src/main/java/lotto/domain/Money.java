package lotto.domain;

public class Money {
    Integer money;
    public Money(Integer money) {
        validateNull(money);
        validateNegativeNumber(money);
        validateDivideByThousand(money);

        this.money = money;
    }

    private void validateNull(Integer money) {

    }
    private void validateNegativeNumber(Integer money) {

    }
    private void validateDivideByThousand(Integer money) {

    }

    public Integer getMoney() {
        return money;
    }
}
