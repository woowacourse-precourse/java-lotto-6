package provider;

import domain.Lottos;

public class TestProvider {
    public static Lottos createTestPurchaseLottos(final int numberOfPurchased) {
        return Lottos.create(numberOfPurchased);
    }
}
