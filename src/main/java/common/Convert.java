package common;

public class Convert {
    public static int StringToInteger(String src) {
        try {
            return Integer.parseInt(src);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
