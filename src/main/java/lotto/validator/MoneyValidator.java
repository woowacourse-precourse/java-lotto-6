package lotto.validator;

public class MoneyValidator {

    private final String moneyString;

    public MoneyValidator(String moneyString) {
        this.moneyString = moneyString;
    }

    public void validateAll(){
        validateDigit();
        validateRange();
    }

    public void validateDigit() throws IllegalArgumentException {
        if (!moneyString.matches("^\\d+$")) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public void validateRange() {
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
