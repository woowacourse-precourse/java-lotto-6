package lotto.validator;

public class MoneyValidator implements Validator<Integer>{

    private static final int UNIT = 1000;
    @Override
    public void validate(Integer amount) {
        validateNotDivisibleWithUnit(amount);
        validateLessThanUnit(amount);
    }

    private void validateNotDivisibleWithUnit(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private void validateLessThanUnit(int amount) {
        if (amount < UNIT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000보다 작을 수 없습니다.");
        }
    }
}
