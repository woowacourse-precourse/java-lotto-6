package lotto.util;

import java.util.List;
import java.util.Objects;

public class Util {
    public static int distinctListSize(List<?> temp) {
        return (int) temp.stream()
                .distinct()
                .count();
    }

}
