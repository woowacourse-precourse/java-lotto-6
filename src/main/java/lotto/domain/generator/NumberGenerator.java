package lotto.domain.generator;

import java.util.List;

public interface NumberGenerator {

    List<Integer> generateNumbers(int start, int end, int count);
}
