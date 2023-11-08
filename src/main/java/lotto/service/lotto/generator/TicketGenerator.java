package lotto.service.lotto.generator;

import lotto.model.Lotto;

abstract class TicketGenerator {
    protected final int startInclusive;
    protected final int endInclusive;
    protected final int count;

    public TicketGenerator(int startInclusive, int endInclusive, int count) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.count = count;
    }

    public abstract Lotto createLotto();
}
