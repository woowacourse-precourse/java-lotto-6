package lotto.fixture;

import lotto.domain.Lotto;

import java.util.List;

public enum LottoFixture {
    WINNING(List.of(1, 2, 3, 4, 5, 6)),
    SECOND(List.of(1, 2, 3, 4, 5, 7)),
    THIRD(List.of(1, 2, 3, 4, 5, 8)),
    FOURTH(List.of(1, 2, 3, 4, 7, 8)),
    FIFTH(List.of(1, 2, 3, 7, 8, 9)),
    NONE(List.of(1, 2, 10, 20, 30, 40));

    private final List<Integer> numbers;

    LottoFixture(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto 생성() {
        return new Lotto(numbers);
    }
}
