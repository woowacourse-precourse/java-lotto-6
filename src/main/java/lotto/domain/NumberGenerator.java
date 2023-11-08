package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {
    List<Integer> generate(int minInclusive, int maxInclusive, int size);
}
