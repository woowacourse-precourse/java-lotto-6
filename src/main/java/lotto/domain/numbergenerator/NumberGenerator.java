package lotto.domain.numbergenerator;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {
    List<Integer> generate();
}
