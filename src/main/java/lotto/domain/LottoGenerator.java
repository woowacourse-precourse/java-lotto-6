package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {
    private final int MIN = 1;
    private final int MAX = 45;
    private final int SIZE = 6;

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, SIZE);
        return new Lotto(numbers);
    }
}
