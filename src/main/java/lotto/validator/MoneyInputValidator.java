package lotto.validator;

public class MoneyInputValidator implements BasicValidator<String> {

    @Override
    public void validate(String input) {
        isNumeric(input);
        isPositive(input);
        isMultipleOfThousand(input);
        isMoreThanOneThousand(input);
    }

    private void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
        }
    }

    private void isPositive(String input) {
        int money = Integer.parseInt(input);
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력값이 0보다 커야 합니다.");
        }
    }

    private void isMultipleOfThousand(String input) {
        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 가능합니다.");
        }
    }

    private void isMoreThanOneThousand(String input) {
        int money = Integer.parseInt(input);
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 최소 1000원 이상이어야 합니다.");
        }
    }
}