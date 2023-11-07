package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottosGenerator {

    private static final int ZERO = 0;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public Lottos generateLottos(int numberOfLottos) {
        List<Lotto> lottos = IntStream.range(ZERO, numberOfLottos)
                .mapToObj(i -> generateLotto())
                .toList();
        return new Lottos(lottos);
    }

    private Lotto generateLotto() {
        return new Lotto(generateSortedNumbersInRange());
    }

    private List<Integer> generateSortedNumbersInRange() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE)
                .stream()
                .sorted()
                .toList();
    }
}
