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
        int money = Integer.parseInt(moneyString);
        if (isWrongRange(money) || isWrongMoneyUnit(money)) {
            throw new IllegalArgumentException("투입 금액은 1000원이상, 1000단위의 숫자를 입력하세요.");
        }
    }

    private boolean isWrongRange(int money) {
        return money < 1000;
    }

    private boolean isWrongMoneyUnit(int money) {
        return money % 1000 > 0;
    }

}
