package lotto.generator;

import java.util.function.IntSupplier;

@FunctionalInterface
public interface RandomGenerator {
    int generate(IntSupplier intSupplier);
}
