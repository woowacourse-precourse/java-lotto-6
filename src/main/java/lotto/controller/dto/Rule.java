package lotto.controller.dto;

import lotto.policy.SortPolicy;
import lotto.policy.NumberGeneratePolicy;
import lotto.policy.PricePolicy;

public record Rule(NumberGeneratePolicy numberGeneratePolicy,
                   PricePolicy pricePolicy,
                   SortPolicy sortPolicy) {

}
