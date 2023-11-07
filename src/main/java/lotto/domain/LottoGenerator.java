package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private final NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos generateLotto(Money money) {
        int numberOfLotto = money.calculateNumberOfLotto();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lottoNumbers = numberGenerator.generateNumber();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return Lottos.of(lottos);
    }
}
