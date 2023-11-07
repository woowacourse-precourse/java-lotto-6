package lotto.strategy;

import java.util.List;
public interface NumberGenerationStrategy {

    List<Integer> generateNumbers(int count, int min, int max);
}
