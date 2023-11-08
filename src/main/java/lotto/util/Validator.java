package lotto.util;

import java.util.Objects;

public class Validator {
    private Validator() {
    }

    public static boolean isNotValid(Object object) {
        return Objects.isNull(object);
    }
}
