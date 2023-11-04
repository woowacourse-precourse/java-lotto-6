package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.lottogenerator.LottoGenerator;

public class LottoStore {
    static final int LOTTO_PRICE = 1000;

    final LottoGenerator lottoGenerator;

    public LottoStore(LottoGenerator lottoGenerator){
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos purchase(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoNum = money / LOTTO_PRICE;
        while (lottos.size() < lottoNum) {
            Lotto generatedLotto = lottoGenerator.generate();
            lottos.add(generatedLotto);
        }

        return new Lottos(lottos);
    }
}
