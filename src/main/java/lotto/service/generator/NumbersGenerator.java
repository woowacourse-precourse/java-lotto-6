package lotto.service.generator;

import java.util.List;

public interface NumbersGenerator {
    List<Integer> generateSortedUniqueNumbersInRange(int startInclusive, int endInclusive, int count);
}
