package lotto.domain.producer;

import lotto.domain.common.Lotto;

public record Bonus(Lotto producerLotto, int value) {

    public Bonus {

    }
}
