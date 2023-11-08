package lotto;

public class Change {
    public static int stringToInt(String input) {
        Validator.isInteger(input);
        return Integer.parseInt(input);
    }

}
