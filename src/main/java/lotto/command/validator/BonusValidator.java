package lotto.command.validator;

public class BonusValidator implements Validator {
    @Override
    public void validate(String input) {
        validateIsNumber(input);
        validateOverNumber(Integer.parseInt(input));
    }

    private void validateIsNumber(String input) {
        if(isNotNumeric(input)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private boolean isNotNumeric(String str) {
        return !str.chars().allMatch(Character::isDigit);
    }

    private void validateOverNumber(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
