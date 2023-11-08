package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomNumberGenerator;

public class LottoGame {
    private final List<Lotto> lottos;
    private final int purchaseAmount;
    private final int lottoCount;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public LottoGame(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottoCount = purchaseAmount / 1000;
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            this.lottos.add(new Lotto(randomNumberGenerator.randomNumberGenerator()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
