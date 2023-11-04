package lotto.support.fixture;

import java.util.List;
import lotto.domain.Lotto;

public enum LottoFixtures {

    로또_1_부터_6(List.of(1,2,3,4,5,6)),
    로또_4_부터_9(List.of(4,5,6,7,8,9)),
    로또_7_부터_12(List.of(7,8,9,10,11,12));

    public final List<Integer> numbers;

    LottoFixtures(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto 생성() {
        return new Lotto(numbers);
    }
}
