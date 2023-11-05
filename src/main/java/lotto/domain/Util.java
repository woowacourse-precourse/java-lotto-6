package lotto.domain;

public class Util {

    public static int toNumeric(String orderInputAmount) {
        try {
            return Integer.parseInt(orderInputAmount);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }
}
