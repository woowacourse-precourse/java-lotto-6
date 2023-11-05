package lotto.fixture;

import lotto.model.Number;

public class NumberFixture {

    public static Number createNumber(final int number) {
        return Number.from(number);
    }
}
