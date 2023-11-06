package lotto;

public final class GameUtils {
    private GameUtils() {
    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static boolean isNotNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
}
