package lotto.generator;

import java.util.function.IntSupplier;

@FunctionalInterface
public interface RandomStrategy {
    int generate();
}
