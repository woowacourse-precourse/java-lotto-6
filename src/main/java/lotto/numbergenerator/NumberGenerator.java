package lotto.numbergenerator;

import java.util.List;

public interface NumberGenerator {
    List<Integer> generateNumbers(int startInclusive, int endInclusive, int size);
}
