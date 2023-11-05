package lotto.util.generator;

import java.util.function.IntSupplier;

@FunctionalInterface
public interface RandomStrategy {
    int generate();
}
