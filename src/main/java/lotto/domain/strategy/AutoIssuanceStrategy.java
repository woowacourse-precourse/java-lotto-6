package lotto.domain.strategy;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class AutoIssuanceStrategy implements IssuableStrategy {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int SIZE = 6;

    @Override
    public Lotto issue() {
        return new Lotto(createSortedRandomNumbers());
    }

    private List<Integer> createSortedRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SIZE)
                .stream()
                .sorted()
                .toList();
    }

}
