package lotto.util;

public class ValidationUtils {

    public static void validateNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
    }
}
