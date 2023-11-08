package lotto.Util;

import static lotto.Util.ViewConstant.*;

public class ErrorCollection {

    public static void ErrorEmpty() {
        throw new IllegalArgumentException(EMPTY_INPUT);
    }

    public static void ErrorStringInput() {
        throw new IllegalArgumentException(ONLY_NUMBER);
    }

    public static void ErrorRange() {
        throw new IllegalArgumentException(RANGE_ERROR);
    }

    public static void ErrorLackInput() {
        throw new IllegalArgumentException(LACK_INPUT);
    }

    public static void ErrorDuplication() {
        throw new IllegalArgumentException(DUPLICATION);
    }

    public static void ErrorBanknote() {
        throw new IllegalArgumentException(BANKNOTE);
    }
}
