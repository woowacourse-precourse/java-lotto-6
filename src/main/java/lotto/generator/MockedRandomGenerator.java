package lotto.generator;

import java.util.function.IntSupplier;

public class MockedRandomGenerator implements RandomStrategy {
    @Override
    public int generate(IntSupplier intSupplier) {
        return intSupplier.getAsInt();
    }
}
