package lotto;

import java.util.List;

public class LottoBundle {
    List<Lotto> lottoBundle;

    public LottoBundle(int lottoCount, List<Integer> randomNumber) {
        for (int i = 0; i < lottoCount; i++) {
            lottoBundle.add(new Lotto(randomNumber));
        }
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }
}
