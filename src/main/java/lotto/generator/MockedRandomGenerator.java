package lotto.generator;

import java.util.function.IntSupplier;

public class MockedRandomGenerator implements RandomStrategy {

    private final IntSupplier intSupplier;

    public MockedRandomGenerator(IntSupplier intSupplier) {
        this.intSupplier = intSupplier;
    }

    @Override
    public int generate() {
        // 주입받은 IntSupplier가 반환하는 값을 사용한다는 말을 하고 있다
        return intSupplier.getAsInt();
    }
}
