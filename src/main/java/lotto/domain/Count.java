package lotto.domain;

import static lotto.constants.DomainConstants.COUNT_END;
import static lotto.constants.DomainConstants.ONE_COUNT;

public record Count(int count) {

    public Count next() {
        return new Count(count - ONE_COUNT.getValue());
    }

    public boolean hasMoreCount() {
        return count > COUNT_END.getValue();
    }
}
