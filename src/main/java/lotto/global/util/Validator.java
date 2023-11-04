package lotto.global.util;

public class Validator {

    public static void validateIntFormat(String value) {
        try{
            Integer.parseInt(value);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }
}
