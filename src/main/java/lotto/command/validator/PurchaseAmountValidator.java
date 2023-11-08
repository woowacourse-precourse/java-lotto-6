package lotto.command.validator;

public class PurchaseAmountValidator implements Validator {
    @Override
    public void validate(String input) {
        validateIsNumber(input);
        validateIsDivide(Integer.parseInt(input));
    }

    private void validateIsDivide(int number) {
        if(isNotDivide(number)) {
            throw new IllegalArgumentException("1,000원 단위로 입력해 주세요.");
        }
    }

    private boolean isNotDivide(int number) {
        return number % 1000 != 0;
    }


    private void validateIsNumber(String input) {
        if(isNotNumeric(input)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private boolean isNotNumeric(String str) {
        return !str.chars().allMatch(Character::isDigit);
    }
}
