package lotto.domain;

import lotto.domain.policy.NumberGeneratePolicy;
import lotto.domain.policy.PricePolicy;

public class Rule {

    private final NumberGeneratePolicy numberGeneratePolicy;
    private final PricePolicy pricePolicy;

    public Rule(NumberGeneratePolicy numberGeneratePolicy, PricePolicy pricePolicy) {
        this.numberGeneratePolicy = numberGeneratePolicy;
        this.pricePolicy = pricePolicy;
    }

    public PricePolicy getPricePolicy() {
        return pricePolicy;
    }

    public NumberGeneratePolicy getNumberGeneratePolicy() {
        return numberGeneratePolicy;
    }

}
