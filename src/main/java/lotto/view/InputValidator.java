package lotto.view;

public class InputValidator {

    public void validateWholeNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }
}
