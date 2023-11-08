package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
    public Lotto LottoMaker() {
        NumberRandomGenerator random = new NumberRandomGenerator();
        return new Lotto(random.generate());
    }

    public List<Lotto> FullLottoMaker(int numOfLotto) {
        List<Lotto> lottos = new ArrayList<>();

        while(lottos.size() < numOfLotto) {
            lottos.add(LottoMaker());
        }

        return lottos;
    }
}
