package lotto.application;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoPicker;

import java.util.List;
import java.util.stream.IntStream;

public class RandomLottoPicker implements LottoPicker {
    private static final int MIM = 1;
    private static final int MAX = 45;
    private static final int NUMBER_LENGTH = 6;

    @Override
    public List<Lotto> picker(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(generateNumber()))
                .toList();
    }

    private List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(MIM, MAX, NUMBER_LENGTH);
    }
}
