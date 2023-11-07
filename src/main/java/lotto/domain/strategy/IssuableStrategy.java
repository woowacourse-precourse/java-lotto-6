package lotto.domain.strategy;

import lotto.domain.Lotto;

@FunctionalInterface
public interface IssuableStrategy {

    Lotto issue();

}
