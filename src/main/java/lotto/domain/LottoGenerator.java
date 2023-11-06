package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(numberGenerator.generateNumber()));
        }
        return lottos;
    }
}
