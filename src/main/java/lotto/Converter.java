package lotto;

public class Converter {
    public static int parseToInt(String rawValue) {
        try {
            return Integer.parseInt(rawValue);
        } catch (NumberFormatException wrongType) {
            throw new IllegalArgumentException();
        }
    }
}
