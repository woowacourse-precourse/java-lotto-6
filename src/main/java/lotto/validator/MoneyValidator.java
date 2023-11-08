package lotto.validator;

public class MoneyValidator {

    private final String moneyString;

    public MoneyValidator(String moneyString) {
        this.moneyString = moneyString;
    }

    public void validateAll(){
        validateRange();
    }

    private void validateRange() {
        long money = Long.parseLong(moneyString);
        if (isWrongRange(money) || isWrongMoneyUnit(money)) {
            throw new IllegalArgumentException("1000 이상, 1000 단위의 금액을 입력하세요.");
        }
    }

    private boolean isWrongRange(long money) {
        return money < 1000;
    }

    private boolean isWrongMoneyUnit(long money) {
        return money % 1000 > 0;
    }

}
