package base;

public class Converter {
    public final int stringToInteger(String string) {
        return Integer.parseInt(string);
    }

    public final String[] tokenizeByComma(String string) {
        return string.split(",");
    }
}