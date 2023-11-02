package lotto.factory;

import lotto.RandomNumberProvider;

import java.util.List;

public class RandomNumberProviderFactory {
    private final List<RandomNumberProvider> randomNumberProviders;

    public RandomNumberProviderFactory(List<RandomNumberProvider> randomNumberProviders) {
        this.randomNumberProviders = randomNumberProviders;
    }


}
