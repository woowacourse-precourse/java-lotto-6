package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int SIZE = 6;
    private final List<Lotto> lottos;
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private Lottos(int lottoCount) {
        this.lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> getLotto())
                .toList();
    }

    public static Lottos ofRandom(int lottoCount) {
        return new Lottos(lottoCount);
    }

    private static Lotto getLotto() {
        List<Integer> integers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SIZE));
        integers.sort(Comparator.naturalOrder());
        return new Lotto(integers);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public void calculateWinning(StandardLotto standardLotto) {
        this.lottos.forEach(lotto -> IncomeCalculator.addCount(standardLotto.matchPrize(lotto)));
    }
}