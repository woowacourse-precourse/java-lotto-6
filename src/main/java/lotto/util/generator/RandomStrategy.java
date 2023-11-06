package lotto.util.generator;

import java.util.List;

@FunctionalInterface
public interface RandomStrategy {
    List<Integer> generate();
}
