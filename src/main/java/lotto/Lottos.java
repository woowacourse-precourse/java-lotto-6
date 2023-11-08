package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottoList;
    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }
    public void calculateWinning(StandardLotto standardLotto){
        this.lottoList.forEach(lotto -> WinningCalculator.addCount(standardLotto.matchPrize(lotto)));
    }
    private Lottos(int lottoCount) {
        this.lottoList = IntStream.range(0, lottoCount)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .map(this::getLotto)
                .toList();
    }

    public static Lottos ofRandom(int lottoCount){
        return new Lottos(lottoCount);
    }

    private Lotto getLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
