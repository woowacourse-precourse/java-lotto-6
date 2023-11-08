package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManagement {
    static final int PRICE_LOTTO = 1000;
    private RandomNumberGenerator lottoGenerator;

    public LottoManagement() {
        lottoGenerator = new RandomNumberGenerator();
    }

    public List<Lotto> buyLotto(int amount) {
        int lottoCount = amount / PRICE_LOTTO;
        List<Lotto> lottery = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = lottoGenerator.generate();
            Lotto lotto = new Lotto(randomNumbers);
            lottery.add(lotto);
        }
        return lottery;
    }
}
