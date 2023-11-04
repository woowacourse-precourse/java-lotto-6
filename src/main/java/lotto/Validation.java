package lotto;

public class Validation {
    static void emptyCheck(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException();
        }
    }

    static void naturalNumberCheck(String raw) {
        try {
            if (Integer.parseInt(raw) <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static void nanCheck(String raw) {
        try {
            Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static void devide1000Check(String raw) {
        try {
            if (Integer.parseInt(raw) % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static void inputMoneyExceptionCheck(String raw) {
        emptyCheck(raw);
        nanCheck(raw);
        naturalNumberCheck(raw);
        devide1000Check(raw);
    }
}
