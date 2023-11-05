package lotto;

public class InputParser {

    public int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX.message + ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.message);
        }
    }
}
