package lotto.util.generator;

import java.util.List;

@FunctionalInterface
public interface NumberGenerator {
    List<Integer> generate(int min, int max, int length);
}
