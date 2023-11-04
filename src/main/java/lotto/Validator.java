package lotto;

public class Validator {
    void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    void isInRange(int input) {
        if (input >= 1 & input <= 45) {
            return;
        }
        throw new IllegalArgumentException("[ERROR]");
    }


}
