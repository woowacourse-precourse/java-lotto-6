package lotto.fixture;

import lotto.domain.lottery.Lotto;
import lotto.domain.prize.Prize;

import java.util.List;

public enum NumberFixture {
    VALID(List.of(1, 2, 3, 4, 5, 6), 45),
    LESS_NUMBER_COUNT(List.of(1, 2, 3), 45),
    EXCEED_NUMBER_COUNT(List.of(1, 2, 3, 4, 5, 6, 7, 8), 45),
    DUPLICATED(List.of(1, 1, 2, 3, 4, 5), 45),
    EXCEED_CONSTRAINT(List.of(500, 1, 2, 3, 4, 5), 45),
    ZERO(List.of(0, 1, 2, 3, 4, 5), 45),
    NEGATIVE_INTEGER(List.of(-1, 1, 2, 3, 4, 5), 45),

    CONTAIN_NUMBER_1_TO_6(List.of(1, 2, 3, 4, 5, 6), 45),
    CONTAIN_BONUS_1(List.of(2, 3, 4, 5, 6, 7), 1),
    CONTAIN_BONUS_45(List.of(2, 3, 4, 5, 6, 7), 45);

    private final List<Integer> numberList;
    private final int bonusNumber;

    NumberFixture(
            List<Integer> numberList,
            int bonusNumber
    ) {
        this.numberList = numberList;
        this.bonusNumber = bonusNumber;
    }

    public Lotto toLottoEntity() {
        return new Lotto(numberList);
    }

    public Prize toPrizeEntity() {
        Lotto lotto = toLottoEntity();
        return Prize.of(lotto, bonusNumber);
    }
}
