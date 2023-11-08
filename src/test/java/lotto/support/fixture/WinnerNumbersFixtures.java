package lotto.support.fixture;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinnerNumbers;

public enum WinnerNumbersFixtures {

    당첨번호_1_부터_6_보너스_7(List.of(1,2,3,4,5,6), 7),
    당첨번호_4_부터_9_보너스10(List.of(4,5,6,7,8,9), 10);

    public final List<Integer> numbers;

    public final Integer bonus;

    WinnerNumbersFixtures(final List<Integer> numbers, final Integer bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public WinnerNumbers 생성() {
        return new WinnerNumbers(numbers, bonus);
    }
}
