package lotto.generator;

import java.util.function.IntSupplier;

public class MockedRandomGenerator implements RandomGenerator {
    @Override
    public int generate(IntSupplier intSupplier) {
        return intSupplier.getAsInt();
    }
}
