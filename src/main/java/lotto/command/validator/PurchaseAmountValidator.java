package lotto.command.validator;

public class PurchaseAmountValidator implements Validator {

    @Override
    public void validate(String input) {
        validateIsNumber(input);
    }

    private void validateIsNumber(String input) {
        if(isNotNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private boolean isNotNumeric(String str) {
        return !str.chars().allMatch(Character::isDigit);
    }
}
