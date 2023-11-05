package lotto.validator;

public class MoneyValidator implements Validator<String>{

    private static final int UNIT = 1000;
    @Override
    public void validate(String input) {
        int amount = Integer.parseInt(input);
        validateNotDivisibleWithUnit(amount);
    }

    private void validateNotDivisibleWithUnit(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
