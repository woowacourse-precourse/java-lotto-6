package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCollectionGenerator {
    private final int lottoCount;
    private final NumberGenerator numberGenerator;

    public LottoCollectionGenerator(int lottoCount, NumberGenerator numberGenerator) {
        this.lottoCount = lottoCount;
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> generate() {
        List<Lotto> lottoCollection = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(numberGenerator.generate());
            lottoCollection.add(lotto);
        }
        return lottoCollection;
    }
}
