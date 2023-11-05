package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public final class Util {
    private Util() {
    }

    public static String makeIntegerListToStringFormat(List<Integer> target){
        return target.stream().map(Object::toString).collect(Collectors.joining(","));
    }
}
