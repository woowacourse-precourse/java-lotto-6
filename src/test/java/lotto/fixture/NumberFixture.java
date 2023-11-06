package lotto.fixture;

import lotto.model.Number;

public class NumberFixture {

    public static Number create(final int number) {
        return Number.from(number);
    }
}
