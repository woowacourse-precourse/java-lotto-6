package lotto.utils;

import java.util.Arrays;
import java.util.Objects;

public class StateChecker {
    private StateChecker() {

    }

    public static void checkNullState (Object ...objects) {
        Arrays.stream(objects).forEach(Objects::requireNonNull);
    }
}
