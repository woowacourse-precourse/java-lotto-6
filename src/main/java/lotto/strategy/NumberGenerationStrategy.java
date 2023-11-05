package lotto.strategy;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Stream;

public interface NumberGenerationStrategy {

    List<Integer> generateNumbers(int count, int min, int max);
}
