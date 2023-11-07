package lotto.validator;

public class Validator {

    public boolean containsNonNumericCharacters(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPositiveMultiplesOfThousand(int input) {
        return input % 1000 == 0 && input >= 0;
    }
}
