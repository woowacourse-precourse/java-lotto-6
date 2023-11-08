package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private static final int ONE_LOTTO = 1000;

    private LottoGenerator lottoGenerator;

    public LottoSeller(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> sellLotto(int money) {
        List<Lotto> lottos = new ArrayList<>();

        int count = (money / ONE_LOTTO);
        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }

        return lottos;
    }


}
