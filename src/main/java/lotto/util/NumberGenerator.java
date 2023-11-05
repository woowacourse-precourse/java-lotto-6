package lotto.util;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {

    List<Integer> generate(int startInclusive, int endInclusive, int count);

}
