package lotto.service.generator;

import java.util.List;

public interface NumbersGenerator {
    List<Integer> generateUniqueNumbersInRange(int startInclusive, int endInclusive, int count);
}
