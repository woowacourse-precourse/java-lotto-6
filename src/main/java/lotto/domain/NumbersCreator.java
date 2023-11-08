package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface NumbersCreator {
    List<Integer> createNumbers(int startInclusive, int endInclusive, int length);
}
