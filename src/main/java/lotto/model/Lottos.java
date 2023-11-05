package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(Integer lottoCount) {
        IntStream.range(0, lottoCount)
                .forEach(count -> lottos.add(new Lotto(lottoGenerator())));
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }


    private static List<Integer> lottoGenerator() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
