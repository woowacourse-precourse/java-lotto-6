package lotto.fixture;

import lotto.domain.lottery.Lotto;

import java.util.List;

public enum NumberFixture {

    VALID(List.of(1, 2, 3, 4, 5, 6)),
    DUPLICATED(List.of(1, 1, 2, 3, 4, 5)),
    EXCEED_CONSTRAINT(List.of(500, 1, 2, 3, 4, 5)),
    ZERO(List.of(0, 1, 2, 3, 4, 5)),
    NEGATIVE_INTEGER(List.of(-1, 1, 2, 3, 4, 5));

    private final List<Integer> numberList;

    NumberFixture(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public Lotto toEntity() {
        return new Lotto(numberList);
    }
}
