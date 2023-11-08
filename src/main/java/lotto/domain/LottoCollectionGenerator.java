package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
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
            List<Integer> lottoNumbers = generateSortedLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoCollection.add(lotto);
        }

        return lottoCollection;
    }

    private List<Integer> generateSortedLottoNumbers() {
        List<Integer> rawLottoNumbers = numberGenerator.generate();
        List<Integer> lottoNumbers = new ArrayList<>(rawLottoNumbers);
        Collections.sort(lottoNumbers);
        return Collections.unmodifiableList(lottoNumbers);
    }
}
